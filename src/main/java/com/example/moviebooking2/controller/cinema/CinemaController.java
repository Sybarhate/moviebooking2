package com.example.moviebooking2.controller.cinema;

import com.example.moviebooking2.dao.CinemaDao;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Cinema;
import com.example.moviebooking2.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CinemaController extends HttpServlet {
    private CinemaDao cinemaDao = new CinemaDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        HttpSession session = request.getSession(false);
        user = (User) session.getAttribute("currentuser");
        int id = user.getUserId();
        List<Cinema> cinemas = null;
        try {
            cinemas = cinemaDao.getCinemaDetails(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute("cinemas", cinemas);

        request.getRequestDispatcher("CinemaManagement.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
