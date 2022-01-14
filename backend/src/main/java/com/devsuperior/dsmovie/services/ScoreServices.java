package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreServices {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){
        //informa email e recupera user do banco de dados pelo email (se n existir insere no banco)
        User user = userRepository.findByEmail(dto.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        //informa id do filme
        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        //salva a avaliação do user para o filme correspondente
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        //recalcula a avaliação média do filme
        double sum = 0.0;
        for(Score s : movie.getScores()){
            sum += s.getValue();
        }
        //media
        double avg = sum / movie.getScores().size();

        //salva no banco novo score media
        movie.setScore(avg);
        movie.setCount(movie.getScores().size()); //quantidade de avaliações
        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }

}
