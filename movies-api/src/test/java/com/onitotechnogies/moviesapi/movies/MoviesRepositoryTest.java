package com.onitotechnogies.moviesapi.movies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoviesRepositoryTest {

    @Autowired
    private MoviesRepository repository;

    @Test
    public void findAllTest(){
        List<Movie> movies = repository.findAll();

        movies
                .forEach(
                        movie -> System.out.println(movie.getPrimaryTitle())
                );
    }

}