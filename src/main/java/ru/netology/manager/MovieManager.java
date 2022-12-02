package ru.netology.manager;


import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repo;
    private int limit;

    public MovieManager(MovieRepository repo) {
        this.repo = repo;
        this.limit = 10;
    }


    public MovieManager(int limit) {

        this.limit = limit;
    }

    public void addMovies(Movie movie) {

        repo.save(movie);
    }

    public Movie[] findAll() {
        Movie[] movies = repo.findAll();
        return movies;
    }

    public Movie[] findLast() {
        Movie[] movies = repo.findAll();
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }
        Movie[] tmp = new Movie[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;
    }

}
