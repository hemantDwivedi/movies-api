package com.onitotechnogies.moviesapi.movies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("longest-duration-movies")
    public List<Movie> getLongestDurationMovies() {
        return movieService.findLongestMovies();
    }
}
