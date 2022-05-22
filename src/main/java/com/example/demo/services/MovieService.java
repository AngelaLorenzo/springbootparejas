package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Movie;
import com.example.demo.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }
    public ArrayList<Movie> getMovies(){
        ArrayList<Movie> movies = (ArrayList<Movie>) movieRepository.findAll();
        return movies;
    }

}
