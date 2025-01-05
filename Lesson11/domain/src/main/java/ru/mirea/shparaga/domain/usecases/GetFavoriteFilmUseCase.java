package ru.mirea.shparaga.domain.usecases;

import ru.mirea.shparaga.domain.models.Movie;
import ru.mirea.shparaga.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {
    private final MovieRepository movieRepository;

    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie execute(){
        return movieRepository.getMovie();
    }
}
