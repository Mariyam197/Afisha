package ru.netology.manager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.mockito.Mockito.*;


public class MovieManagerTest {

    MovieRepository repo = Mockito.mock(MovieRepository.class);
    MovieManager manager = new MovieManager(repo);
    MovieManager man = new MovieManager(11);

    Movie film1 = new Movie(11, "Film 1");
    Movie film2 = new Movie(22, "Film 2");
    Movie film3 = new Movie(33, "Film 3");
    Movie film4 = new Movie(44, "Film 4");
    Movie film5 = new Movie(55, "Film 5");
    Movie film6 = new Movie(66, "Film 6");
    Movie film7 = new Movie(77, "Film 7");
    Movie film8 = new Movie(88, "Film 8");
    Movie film9 = new Movie(99, "Film 9");
    Movie film10 = new Movie(100, "Film 10");
    Movie film11 = new Movie(110, "Film 11");

    @BeforeEach
    public void setup() {
        manager.addMovies(film1);
        manager.addMovies(film2);
        manager.addMovies(film3);
        manager.addMovies(film4);
        manager.addMovies(film5);
        manager.addMovies(film6);
        manager.addMovies(film7);
        manager.addMovies(film8);
        manager.addMovies(film9);
        manager.addMovies(film10);
        manager.addMovies(film11);

    }

    @Test
    public void shouldAddMovies() {
        Movie[] movies = new Movie[]{film1, film2, film3};
        doReturn(movies).when(repo).findAll();


        Movie[] actual = manager.findAll();
        Movie[] expected = {film1, film2, film3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfEqualLimit() {
        Movie[] movies = new Movie[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        doReturn(movies).when(repo).findAll();

        Movie[] actual = manager.findLast();
        Movie[] expected = { film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfUnderLimit() {
        Movie[] movies = new Movie[]{film1, film2, film3 };
        doReturn(movies).when(repo).findAll();

        Movie[] actual = manager.findLast();
        Movie[] expected = { film3, film2, film1 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfOverLimit() {
        Movie[] movies = new Movie[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        doReturn(movies).when(repo).findAll();

        Movie[] actual = manager.findLast();
        Movie[] expected = { film11, film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};

        Assertions.assertArrayEquals(expected, actual);
    }
}
