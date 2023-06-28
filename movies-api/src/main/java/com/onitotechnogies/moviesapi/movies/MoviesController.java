package com.onitotechnogies.moviesapi.movies;


import com.onitotechnogies.moviesapi.ratings.MovieTopRated;
import com.onitotechnogies.moviesapi.ratings.MovieWithSubtotal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MoviesController {
    private final MoviesRepository repository;

    public MoviesController(MoviesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("longest-duration-movies")
    public List<Movie> getLongestDurationMovies() {
        return repository.findMoviesByRuntimeMinutes();
    }

    @PostMapping("new-movie")
    public ResponseEntity<String> newMovie(@RequestBody Movie movie) {
        repository.newMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("top-rated-movies")
    public List<MovieTopRated> topRatedMovies() {
        return repository.getRating();
    }

    @GetMapping("genre-movies-with-subtotals")
    public List<MovieWithSubtotal> getMovieWithSubtotal() {
        return repository.getMovieWithSubtotals();
    }

    @PatchMapping("update-runtime-minutes")
    public ResponseEntity<String> updateRuntimeMinutes() {
        repository.updateRuntimeMinutes();
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}
