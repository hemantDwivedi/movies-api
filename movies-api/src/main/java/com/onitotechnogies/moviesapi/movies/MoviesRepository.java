package com.onitotechnogies.moviesapi.movies;

import com.onitotechnogies.moviesapi.ratings.MovieTopRated;
import com.onitotechnogies.moviesapi.ratings.MovieWithSubtotal;
import com.onitotechnogies.moviesapi.ratings.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoviesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String FIND_BY_RUNTIME_MINTUES = "SELECT * FROM onito.movies order by runtime_minutes desc limit 10;";
    private static String SAVE_NEW_MOVIE = "INSERT INTO onito.movies(tconst, title_type, primary_title, runtime_minutes, genres) VALUES(?,?,?,?,?);";
    private static String GET_MOVIES_BY_RATING = "select movies.tconst, movies.primary_title, movies.genres, ratings.average_rating from onito.movies inner join onito.ratings on movies.tconst = ratings.tconst where average_rating > 6.0 order by average_rating asc;";

    private static String UPDATE_RUNTIME_MINUTES = "update movies set runtime_minutes = case when genres = 'documentary' then runtime_minutes + 15 when genres = 'animation' then runtime_minutes + 30 else runtime_minutes + 45 end;";
    private static String MOVIE_WITH_SUBTOTALS = "SELECT m.genres, m.primary_title, r.num_votes\n" +
            "FROM movies m\n" +
            "JOIN ratings r ON m.tconst = r.tconst\n" +
            "UNION ALL\n" +
            "SELECT m.genres, 'TOTAL', SUM(r.num_votes)\n" +
            "FROM movies m\n" +
            "JOIN ratings r ON m.tconst = r.tconst\n" +
            "GROUP BY m.genres\n" +
            "ORDER BY genres, primary_title;";

    public List<Movie> findMoviesByRuntimeMinutes() {
        return jdbcTemplate.query(FIND_BY_RUNTIME_MINTUES, new BeanPropertyRowMapper<>(Movie.class));
    }

    public void newMovie(Movie movie) {
        jdbcTemplate.update(SAVE_NEW_MOVIE, movie.getTconst(), movie.getPrimaryTitle(), movie.getRuntimeMinutes(), movie.getGenres());
    }

    public void updateRuntimeMinutes() {
        jdbcTemplate.update(UPDATE_RUNTIME_MINUTES);
    }

    public List<MovieTopRated> getRating() {
        return jdbcTemplate.query(GET_MOVIES_BY_RATING, new BeanPropertyRowMapper<>(MovieTopRated.class));
    }

    public List<MovieWithSubtotal> getMovieWithSubtotals() {
        return jdbcTemplate.query(MOVIE_WITH_SUBTOTALS, new BeanPropertyRowMapper<>(MovieWithSubtotal.class));
    }


}