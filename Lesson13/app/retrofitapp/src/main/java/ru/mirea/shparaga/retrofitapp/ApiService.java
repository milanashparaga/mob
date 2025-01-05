package ru.mirea.shparaga.retrofitapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface ApiService {
    @GET("todos?limit=10")
    Call<List<Todo>> getTodos();

    @PATCH("todos/{id}")
    Call<Todo> updateTodoStatus(@Path("id") int id, @Body Todo todo);
}
