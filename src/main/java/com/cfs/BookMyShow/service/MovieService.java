package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.entity.Movie;
import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public Movie getMovieById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("movie is not found with this id:"+id));
    }
    public List<Movie> searchByTitle(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getByLanguage(String language){
        return movieRepository.findByLanguage(language);
    }

    // update movie
    // delete movie


}
