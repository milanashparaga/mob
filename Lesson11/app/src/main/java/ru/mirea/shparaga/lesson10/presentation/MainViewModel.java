package ru.mirea.shparaga.lesson10.presentation;

import androidx.lifecycle.ViewModel;

import ru.mirea.shparaga.domain.models.Movie;
import ru.mirea.shparaga.domain.repository.MovieRepository;
import ru.mirea.shparaga.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.shparaga.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainViewModel extends ViewModel {
    private MovieRepository movieRepository;

    public MainViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean saveMovie(Movie movie) {
        return new SaveMovieToFavoriteUseCase(movieRepository).execute(movie);
    }

    public Movie getMovie() {
        return new GetFavoriteFilmUseCase(movieRepository).execute();
    }
}
