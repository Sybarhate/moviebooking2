package com.example.moviebooking2.screen;

import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.dto.ScreenLayoutDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Screen;
import com.example.moviebooking2.model.ScreenLayout;
import com.example.moviebooking2.service.ScreenLayoutService;
import com.example.moviebooking2.service.ScreenService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//public class AddScreenController extends HttpServlet {
//    ScreenDTO screenDTO = new ScreenDTO();
//    ScreenService screenService = new ScreenService();
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String cinemaID = req.getParameter("cinemaId");
//        req.setAttribute("cinemaId", cinemaID);
//
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddScreen.jsp");
//        requestDispatcher.forward(req, resp);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String cinemaId = req.getParameter("cinemaId");
//        screenDTO.setCinemaId(cinemaId);
//        screenDTO.setScreenId(req.getParameter("id"));
//        screenDTO.setName(req.getParameter("name"));
//        screenDTO.setNoOfRows(req.getParameter("noOfRows"));
//        screenDTO.setNoOfColumns(req.getParameter("noOfCols"));
//        try {
//            screenService.addScreenDetails(screenDTO);
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
//        resp.sendRedirect("screen-management");
//     //   resp.sendRedirect("generate-seat-numbers?cinemaId=" + cinemaId + "&screenId=" + screenDTO.getScreenId());
//    }
//
//
//}**************************************above code is previous correct code


public class AddScreenController extends HttpServlet {
    ScreenDTO screenDTO = new ScreenDTO();
    ScreenService screenService = new ScreenService();
    ScreenLayoutDTO screenLayoutDTO = new ScreenLayoutDTO();
    ScreenLayoutService screenLayoutService = new ScreenLayoutService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cinemaID = req.getParameter("cinemaId");
        req.setAttribute("cinemaId", cinemaID);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddScreen.jsp");
        requestDispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cinemaId = req.getParameter("cinemaId");
        screenDTO.setCinemaId(cinemaId);
        screenDTO.setName(req.getParameter("name"));
        screenDTO.setNoOfRows(req.getParameter("noOfRows"));
        screenDTO.setNoOfColumns(req.getParameter("noOfCols"));

        List<String> seatNumbers = generateSeatNumbers(screenDTO.getNoOfRows(), screenDTO.getNoOfColumns());
        screenLayoutDTO.setSeatNumber(String.valueOf(seatNumbers));

        try {
            screenService.addScreenDetails(screenDTO);
            List<Screen> screen = screenService.getScreenDataByCinemaId(screenDTO);
            screenLayoutService.saveSeatNumbers(screenDTO.getScreenId(), seatNumbers);
            List<ScreenLayout> seatNumbersString = screenLayoutService.screenLayoutDisplayData(screenDTO.getScreenId());
            Screen screensRowsCols = screenService.getRowsCols(screenDTO);
            req.setAttribute("seatNumber", seatNumbersString);
            req.setAttribute("screenLayoutRowAndColumn", screensRowsCols);

        } catch (DAOException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ScreenLayout.jsp");
        requestDispatcher.forward(req, resp);
        //resp.sendRedirect("screen-management");// from here i need to call layout

    }

    private List<String> generateSeatNumbers(String noOfRows, String noOfColumns) {
        int numRows = Integer.parseInt(noOfRows);
        int numCols = Integer.parseInt(noOfColumns);
        List<String> seatNumbers = new ArrayList<>();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                String seatNumber = String.format("%s%d", letters.charAt(row), col + 1);
                seatNumbers.add(seatNumber);
            }
        }
        return seatNumbers;
    }

}