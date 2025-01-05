package ru.mirea.shparaga.retrofitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Todo> todos;
    private ApiService apiService;

    public TodoAdapter(Context context, List<Todo> todoList, ApiService apiService) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todos = todoList;
        this.apiService = apiService;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);

        holder.itemTitle.setText(todo.getTitle());
        holder.itemCheckBox.setChecked(todo.getCompleted());

        String imageUrl = todo.getImageUrl();
        Picasso.get()
                .load(imageUrl) // загружаем изображение
                .placeholder(R.drawable.placeholder) // изображение по умолчанию, пока загружается
                .error(R.drawable.error_image) // изображение в случае ошибки
                .resize(100, 100) // задаем размер изображения
                .centerCrop() // обрезаем изображение по центру
                .into(holder.itemImageView); // загружаем в ImageView

        // Обработчик изменения состояния чекбокса
        holder.itemCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            todo.setCompleted(isChecked);
            updateTodoStatus(todo);
        });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    // Метод для обновления состояния задачи на сервере
    private void updateTodoStatus(Todo todo) {
        Call<Todo> call = apiService.updateTodoStatus(todo.getId(), todo);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (!response.isSuccessful()) {
                    Log.e("TodoAdapter", "Update failed: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e("TodoAdapter", "Update failed: " + t.getMessage());
            }
        });
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView itemTitle;
        CheckBox itemCheckBox;
        ImageView itemImageView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemCheckBox = itemView.findViewById(R.id.itemCheckBox);
            itemImageView = itemView.findViewById(R.id.itemImageView);
        }
    }
}
