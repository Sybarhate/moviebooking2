package com.example.moviebooking2.controller.cinema;

import com.example.moviebooking2.dao.CinemaDao;
import com.example.moviebooking2.exception.DAOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCinemaController extends HttpServlet {
    CinemaDao cinemaDao = new CinemaDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cinemaId = Integer.parseInt(req.getParameter("id"));
        try {
            cinemaDao.deleteCinema(cinemaId);
            resp.sendRedirect("cinema");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
