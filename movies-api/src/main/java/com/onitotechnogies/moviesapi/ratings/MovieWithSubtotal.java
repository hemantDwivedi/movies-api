package com.onitotechnogies.moviesapi.ratings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieWithSubtotal {
    private String genres;
    private String primaryTitle;
    private Integer numVotes;
}
