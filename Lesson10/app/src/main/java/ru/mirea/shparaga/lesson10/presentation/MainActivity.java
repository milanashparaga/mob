package ru.mirea.shparaga.lesson10.presentation;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

import ru.mirea.shparaga.data.repository.MovieRepositoryImpl;
import ru.mirea.shparaga.data.storage.MovieStorage;
import ru.mirea.shparaga.data.storage.SharedPrefMovieStorage;
import ru.mirea.shparaga.domain.repository.MovieRepository;
import ru.mirea.shparaga.lesson9.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextMovie = findViewById(R.id.editTextMovie);
        TextView textViewMovie = findViewById(R.id.textViewMovie);
        String localDate = LocalDate.now().toString();

        MovieStorage sharedPrefMovieStorage = new SharedPrefMovieStorage(this);
        MovieRepository movieRepository = new MovieRepositoryImpl(sharedPrefMovieStorage);

        Button buttonSaveMovie = findViewById(R.id.buttonSaveMovie);
        buttonSaveMovie.setOnClickListener(view -> {
            String movieName = editTextMovie.getText().toString();

            ru.mirea.shparaga.domain.models.Movie movie = new ru.mirea.shparaga.domain.models.Movie(0, movieName, localDate);

            boolean result = new ru.mirea.shparaga.domain.usecases.SaveMovieToFavoriteUseCase(movieRepository).execute(movie);

            Log.d("MainActivity", "Результат сохранения фильма: " + result + ", Название: " + movieName);

            if (result) {
                textViewMovie.setText(String.format("Фильм '%s' сохранен.", movieName));
            } else {
                textViewMovie.setText("Ошибка при сохранении фильма.");
            }
        });

        Button buttonGetMovie = findViewById(R.id.buttonGetMovie);
        buttonGetMovie.setOnClickListener(view -> {
            ru.mirea.shparaga.domain.models.Movie movie = new ru.mirea.shparaga.domain.usecases.GetFavoriteFilmUseCase(movieRepository).execute();

            if (movie != null) {
                textViewMovie.setText(String.format("Сохраненный фильм: %s", movie.getName()));
            } else {
                textViewMovie.setText("Нет сохраненного фильма.");
            }
        });
    }
}
