package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {
    private Movie[] movies = new Movie[0];

    public void save(Movie film) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = film;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;

    }

    public void removeById(int id) {
        Movie[] tmp = new Movie[movies.length - 1];
        int copyToIndex = 0;
        for (Movie film : movies) {
            if (film.getId() != id) {
                tmp[copyToIndex] = film;
                copyToIndex++;
            }
        }
        movies = tmp;
    }

    public Movie[] findById(int id) {
        Movie[] result = new Movie[1];
        for (Movie film : movies) {
            if (film.getId() == id) {
                result[0] = film;
            }
        }
        return result;
    }

    public void removeAll() {
        Movie[] delete = new Movie[0];
        movies = delete;
    }
}
