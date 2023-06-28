package com.onitotechnogies.moviesapi.ratings;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieTopRated {
    private String tconst;
    private String primaryTitle;
    private String genres;
    private Double averageRating;
}
