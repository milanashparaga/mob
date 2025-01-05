package ru.mirea.shparaga.lesson10.presentation;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.time.LocalDate;

import ru.mirea.shparaga.data.repository.MovieRepositoryImpl;
import ru.mirea.shparaga.data.storage.MovieStorage;
import ru.mirea.shparaga.data.storage.SharedPrefMovieStorage;
import ru.mirea.shparaga.domain.models.Movie;
import ru.mirea.shparaga.domain.repository.MovieRepository;
import ru.mirea.shparaga.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.shparaga.domain.usecases.SaveMovieToFavoriteUseCase;
import ru.mirea.shparaga.lesson11.R;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private MovieRepository movieRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new ViewModelFactory(this)).get(MainViewModel.class);

        MovieStorage movieStorage = new SharedPrefMovieStorage(this);
        movieRepository = new MovieRepositoryImpl(movieStorage);

        EditText editText = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);

        findViewById(R.id.buttonSaveMovie).setOnClickListener(view -> {
            String movieName = editText.getText().toString();
            Boolean result = new SaveMovieToFavoriteUseCase(movieRepository).execute(new Movie(2, movieName, LocalDate.now().toString()));
            textView.setText(String.format("Сохранённый фильм: %s", result));
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener(view -> {
            Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
            textView.setText(String.format("Название фильма: %s", movie.getName()));
        });

        Log.d(MainActivity.class.getSimpleName(), "MainActivity создан");
    }
}
