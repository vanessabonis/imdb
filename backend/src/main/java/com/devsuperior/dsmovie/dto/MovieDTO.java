package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private String title;
    private Double score;
    private Integer count;
    private String image;

    public MovieDTO(Movie movie){
        this.title = movie.getTitle();
        this.score = movie.getScore();
        this.count = movie.getCount();
        this.image = movie.getImage();
    }

}
