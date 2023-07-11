package com.example.moviebooking2.screen;

import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Cinema;
import com.example.moviebooking2.model.Screen;
import com.example.moviebooking2.model.User;
import com.example.moviebooking2.service.ScreenService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ScreenController extends HttpServlet {
    ScreenService screenService = new ScreenService();
    ScreenDTO screenDTO = new ScreenDTO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        HttpSession session = req.getSession(false);
        user = (User) session.getAttribute("currentuser");
        int id = user.getUserId();
        List<Cinema> cinemaList = null;
        try {
            cinemaList = screenService.getCinemaDetails(id);
            String cinemaId = req.getParameter("cinemaId");

            if (cinemaId != null) {
                screenDTO.setCinemaId(cinemaId);

                List<Screen> screen = screenService.getScreenDataByCinemaId(screenDTO);
                req.setAttribute("Screen", screen);

            }
        } catch (DAOException ex) {
            ex.printStackTrace();
        }


        req.setAttribute("Cinema", cinemaList);
        req.getRequestDispatcher("ScreenManagement.jsp").forward(req, resp);
    }
}
