package com.onitotechnogies.moviesapi.movies;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Movie {
    private String tconst;
    private String primaryTitle;
    private Integer runtimeMinutes;
    private String genres;
}
