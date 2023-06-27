package com.onitotechnogies.moviesapi.movies;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MoviesRepository repository;

    public MovieService(MoviesRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findLongestMovies() {
        return repository.findTop10ByOrderByRuntimeMinutesDesc();
    }
}
