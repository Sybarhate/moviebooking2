package com.example.moviebooking2.controller.movie;

import com.example.moviebooking2.dto.MovieDTO;
import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.service.MovieService;
import com.example.moviebooking2.service.ScreenService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMovieController extends HttpServlet {

    MovieService movieService = new MovieService();
    MovieDTO movieDTO = new MovieDTO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        movieDTO.setId(req.getParameter("id"));
        try {
            movieService.deleteMovies(movieDTO);
            resp.sendRedirect("movie-management");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}