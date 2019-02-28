package com.stackroute.quizify.searchservice.service;


import com.stackroute.quizify.searchservice.exception.GenreAlreadyExistsException;
import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * This "GenreServiceImpl" Class implements all the methods declared by "GenreService" Interface.
 *
 * Spring @Service annotation is used with classes that provide business functionalities/logics.
 */


@Service
public class GenreServiceImpl implements GenreService{
    GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

//    @Override
//    public List<Genre> getAllGenreByName(String genreName) throws GenreDoesNotExistsException {
//        List<Genre> allGenres = genreRepository.searchByGenreName(genreName);
//        if(allGenres==null)
//            throw new GenreDoesNotExistsException("No Game found");
//        else
//            return allGenres;
//    }

    @Override
    public Genres saveGenre(Genres genre) throws GenreAlreadyExistsException {
        if (this.genreRepository.existsById(genre.getId()))
            throw new GenreAlreadyExistsException("Genre Already Exists!");
        else
        {
            if(this.genreRepository.findTopByOrderByIdDesc().isEmpty())
                genre.setId(1);
            else
                genre.setId(this.genreRepository.findTopByOrderByIdDesc().get().getId()+1);
            return genreRepository.save(genre);
        }
    }

    @Override
    public List<Genres> getAllGenreByStartsWith(String genreName) throws GenreDoesNotExistsException {
        List<Genres> genres = genreRepository.searchByGenreAlphabet(genreName);
        if(genres==null)
            throw new GenreDoesNotExistsException("No Game Found");
        else
            return genres;
    }
}
