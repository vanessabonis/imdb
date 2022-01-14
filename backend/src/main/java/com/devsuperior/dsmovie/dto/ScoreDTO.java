package com.devsuperior.dsmovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScoreDTO {

    private Long movieId;
    private String email;
    private Double score;

    //endpoint da req do form (salvar uma vz só com put)


}
