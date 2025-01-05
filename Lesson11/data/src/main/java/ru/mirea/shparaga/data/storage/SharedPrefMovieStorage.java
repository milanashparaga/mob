package ru.mirea.shparaga.data.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.time.LocalDate;

import ru.mirea.shparaga.domain.models.Movie;

public class SharedPrefMovieStorage implements MovieStorage {

    private static final String SHARED_PREFS_NAME = "films_data";
    private static final String KEY = "FAV_FILM";
    private static final String DATE_KEY = "movie_date";
    private static final String ID_KEY = "movie_id";

    private final SharedPreferences sharedPreferences;

    public SharedPrefMovieStorage(Context iContext) {
        sharedPreferences = iContext.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Movie get() {
        String movieName = sharedPreferences.getString(KEY, null);
        String movieDate = sharedPreferences.getString(DATE_KEY, LocalDate.now().toString());
        int movieId = sharedPreferences.getInt(ID_KEY, -1);

        Log.d("SharedPrefMovieStorage", "Полученные данные: " +
                "ID: " + movieId + ", Название: " + movieName + ", Дата: " + movieDate);

        if (movieName == null || movieId == -1) {
            return null;
        }

        return new Movie(movieId, movieName, movieDate);
    }

    @Override
    public void save(Movie movie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int currentId = sharedPreferences.getInt(ID_KEY, 0);
        editor.putInt(ID_KEY, currentId + 1);
        editor.putString(KEY, movie.getName());
        editor.putString(DATE_KEY, movie.getLocalDate());

        Log.d("SharedPrefMovieStorage", "Сохраняем фильм: " +
                "ID: " + (currentId + 1) + ", Название: " + movie.getName() + ", Дата: " + movie.getLocalDate());

        editor.apply();
    }
}
