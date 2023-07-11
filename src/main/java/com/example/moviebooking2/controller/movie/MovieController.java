package com.example.moviebooking2.controller.movie;

import com.example.moviebooking2.dto.MovieDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Cinema;
import com.example.moviebooking2.model.Movie;
import com.example.moviebooking2.model.Screen;
import com.example.moviebooking2.model.User;
import com.example.moviebooking2.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MovieController extends HttpServlet {
    private MovieDTO movieDTO = new MovieDTO();
    MovieService movieService = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        HttpSession session = req.getSession(false);
        user = (User) session.getAttribute("currentuser");
        int id = user.getUserId();
        List<Cinema> cinemaList = null;
//        try {
//            cinemaList = movieService.getCinemaDetails(id);
//            req.setAttribute("Cinema", cinemaList);
//
////            String cinemaId = req.getParameter("cinemaId");
//
//            if (req.getParameter("cinemaId") != null) {
//                String cinemaId = req.getParameter("cinemaId");
//                System.out.println(cinemaId);
//                movieDTO.setCinemaId(cinemaId);
//                List<Movie> movies = null;
//                try {
//                    movies = movieService.getMovieDataByCinemaId(movieDTO);
//                    req.setAttribute("Movie", movies);
//
//                } catch (DAOException e) {
//                    e.printStackTrace();
//                }
////                System.out.println(movies.);
//
//            }
//
//
//            req.getRequestDispatcher("MovieManagement.jsp").forward(req, resp);
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
//    }
        try {
            cinemaList = movieService.getCinemaDetails(id);
            String cinemaId = req.getParameter("cinemaId");

            if (cinemaId != null) {
                movieDTO.setCinemaId(cinemaId);

                List<Movie> movies = movieService.getMovieDataByCinemaId(movieDTO);
                req.setAttribute("Movie", movies);

            }
        } catch (DAOException ex) {
            ex.printStackTrace();
        }


        req.setAttribute("Cinema", cinemaList);
        req.getRequestDispatcher("MovieManagement.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
