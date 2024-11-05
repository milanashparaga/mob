package ru.mirea.shparaga.data.storage;


import ru.mirea.shparaga.domain.models.Movie;

public interface MovieStorage {
    public Movie get();
    public void save(Movie movie);
}
