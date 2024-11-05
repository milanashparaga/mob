package ru.mirea.shparaga.domain.repository;

import ru.mirea.shparaga.domain.models.Movie;

public interface MovieRepository {
    boolean saveMovie(Movie movie);
    Movie getMovie();
}
