package ru.mirea.shparaga.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private List<Event> events;
    private Context context;

    public EventRecyclerViewAdapter(List<Event> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View recyclerViewItem = LayoutInflater.from(context).inflate(R.layout.event_item_view, parent, false);
        return new EventViewHolder(recyclerViewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = events.get(position);

        holder.getEventImageView().setImageResource(event.getImageName());
        holder.getEventNameView().setText(event.getEventName());
        holder.getEventDescriptionView().setText(event.getDescription());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Clicked: " + event.getEventName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}

