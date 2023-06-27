package com.onitotechnogies.moviesapi.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Movie> {
    List<Movie> findTop10ByOrderByRuntimeMinutesDesc();
}
