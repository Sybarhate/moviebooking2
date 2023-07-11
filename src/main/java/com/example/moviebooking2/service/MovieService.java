package com.example.moviebooking2.service;

import com.example.moviebooking2.dao.CinemaDao;
import com.example.moviebooking2.dao.MovieDao;
import com.example.moviebooking2.dto.MovieDTO;
import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Cinema;
import com.example.moviebooking2.model.Movie;
import com.example.moviebooking2.model.Screen;

import java.util.List;


public class MovieService {
    MovieDao movieDao=new MovieDao();
CinemaDao cinemaDao=new CinemaDao();
    public List<Movie> getMovieDetails(MovieDTO movieDTO) throws DAOException {
        return movieDao.getMovies(movieDTO);
    }
    public void addMovieDetails(MovieDTO movieDTO) throws DAOException {
        movieDao.addMovie(movieDTO);
    }
    public List<Cinema> getCinemaDetails(int userId) throws DAOException {
        List<Cinema> cinemaList = cinemaDao.getCinemaDetails(userId);
        return cinemaList;
    }
    public List<Movie> getMovieDataByCinemaId(MovieDTO movieDTO) throws DAOException {
        return movieDao.getMovies(movieDTO);
    }
    public void deleteMovies(MovieDTO movieDTO) throws DAOException {
        movieDao.deleteMovie(movieDTO);
    }
    public void updateMovieDetails(MovieDTO movieDTO) throws DAOException {
        movieDao.updateMovieDetails(movieDTO);
    }
    public Movie getMovieEditDetails(MovieDTO movieDTO) throws DAOException {
        return movieDao.getEditMovieDetails(movieDTO);
    }
}
