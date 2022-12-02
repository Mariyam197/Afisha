package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

public class MovieRepositoryTest {

    Movie film1 = new Movie(11, "Film 1");
    Movie film2 = new Movie(22, "Film 2");
    Movie film3 = new Movie(33, "Film 3");

    @Test
    public void shouldSaveMovies() {
        MovieRepository repo = new MovieRepository();

        repo.save(film1);
        repo.save(film2);
        repo.save(film3);

        Movie[] expected = {film1, film2, film3};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveMoviesById() {
        MovieRepository repo = new MovieRepository();

        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.removeById(film2.getId());

        Movie[] expected = {film1, film3};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMovieById() {
        MovieRepository repo = new MovieRepository();

        repo.save(film1);
        repo.save(film2);
        repo.save(film3);


        Movie[] expected = {film2};
        Movie[] actual = repo.findById(22);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        MovieRepository repo = new MovieRepository();

        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.removeAll();

        Movie[] expected = new Movie[0];
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
