package ru.mirea.shparaga.data.repository;

import java.time.LocalDate;

import ru.mirea.shparaga.data.storage.MovieStorage;
import ru.mirea.shparaga.domain.models.Movie;
import ru.mirea.shparaga.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

    private final MovieStorage movieStorage;

    public MovieRepositoryImpl(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @Override
    public boolean saveMovie(ru.mirea.shparaga.domain.models.Movie movie) {
        movieStorage.save(mapToStorage(movie));
        return true;
    }

    @Override
    public ru.mirea.shparaga.domain.models.Movie getMovie() {
        return mapToDomain(movieStorage.get());
    }

    private Movie mapToStorage(ru.mirea.shparaga.domain.models.Movie movie){
        String name = movie.getName();
        return new Movie(2, name, LocalDate.now().toString());
    }

    private ru.mirea.shparaga.domain.models.Movie mapToDomain(Movie movie) {
        return new ru.mirea.shparaga.domain.models.Movie(movie.getId(), movie.getName(), movie.getLocalDate());
    }
}
