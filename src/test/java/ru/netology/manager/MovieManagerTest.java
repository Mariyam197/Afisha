package ru.netology.manager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MovieManagerTest {
    MovieManager manager = new MovieManager();
    MovieManager man = new MovieManager(10);

    @Test
    public void shouldAddMovies() {

        manager.addMovies("Film 1");
        manager.addMovies("Film 2");
        manager.addMovies("Film 3");
        manager.addMovies("Film 4");

        String[] actual = manager.findAll();
        String[] expected = {"Film 1", "Film 2", "Film 3", "Film 4"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfUnderLimit() {

        manager.addMovies("Film 1");
        manager.addMovies("Film 2");
        manager.addMovies("Film 3");
        manager.addMovies("Film 4");

        String[] actual = manager.findLast();
        String[] expected = {"Film 4", "Film 3", "Film 2", "Film 1"};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastIfEqualLimit() {
        manager.addMovies("Film 1");
        manager.addMovies("Film 2");
        manager.addMovies("Film 3");
        manager.addMovies("Film 4");
        manager.addMovies("Film 5");
        manager.addMovies("Film 6");
        manager.addMovies("Film 7");
        manager.addMovies("Film 8");
        manager.addMovies("Film 9");
        manager.addMovies("Film 10");

        String[] actual = manager.findLast();
        String[] expected = {"Film 10", "Film 9", "Film 8", "Film 7", "Film 6", "Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfOverLimit() {
        man.addMovies("Film 1");
        man.addMovies("Film 2");
        man.addMovies("Film 3");
        man.addMovies("Film 4");
        man.addMovies("Film 5");
        man.addMovies("Film 6");
        man.addMovies("Film 7");
        man.addMovies("Film 8");
        man.addMovies("Film 9");
        man.addMovies("Film 10");
        man.addMovies("Film 11");

        String[] actual = man.findLast();
        String[] expected = {"Film 11", "Film 10", "Film 9", "Film 8", "Film 7", "Film 6", "Film 5", "Film 4", "Film 3", "Film 2" };

        Assertions.assertArrayEquals(expected, actual);
    }
}
