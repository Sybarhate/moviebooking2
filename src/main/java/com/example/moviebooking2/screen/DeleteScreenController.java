package com.example.moviebooking2.screen;

import com.example.moviebooking2.dao.ScreenDao;
import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Screen;
import com.example.moviebooking2.service.ScreenService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteScreenController extends HttpServlet {
    ScreenService screenService=new ScreenService();
    ScreenDTO screenDTO=new ScreenDTO();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        screenDTO.setScreenId(req.getParameter("id"));
        try {
            screenService.deleteScreens(screenDTO);
            resp.sendRedirect("screen-management");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}