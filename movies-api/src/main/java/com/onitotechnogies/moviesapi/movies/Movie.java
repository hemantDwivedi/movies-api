package com.onitotechnogies.moviesapi.movies;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String tconst;

    @Column(name = "titleType")
    private String titleType;

    @Column(name = "primaryTitle")
    private String primaryTitle;

    @Column(name = "runtimeMinutes")
    private Integer runtimeMinutes;

    private String genres;
}
