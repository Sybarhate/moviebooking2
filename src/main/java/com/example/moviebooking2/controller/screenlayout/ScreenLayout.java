package com.example.moviebooking2.controller.screenlayout;

import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.dto.ScreenLayoutDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Screen;
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

//
//public class ScreenLayout extends HttpServlet {
//    ScreenService screenService = new ScreenService();
//    ScreenLayoutService screenLayoutService = new ScreenLayoutService();
//    ScreenDTO screenDTO = new ScreenDTO();
//    ScreenLayoutDTO screenLayoutDTO=new ScreenLayoutDTO();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        List<String> seatNumbers = generateSeatNumbers(screenDTO.getNoOfRows(), screenDTO.getNoOfColumns());
//        screenLayoutDTO.setSeatNumber(String.valueOf(seatNumbers));
//
//        try {
//            screenLayoutService.saveSeatNumbers(screenDTO.getScreenId(), seatNumbers);
//            List<Screen> screen = screenService.getScreenDataByCinemaId(screenDTO);
//            screenLayoutService.saveSeatNumbers(screenDTO.getScreenId(), seatNumbers);
//
//            List<com.example.moviebooking2.model.ScreenLayout> seatNumbersString = screenLayoutService.screenLayoutDisplayData(screenDTO.getScreenId());
//            Screen screen1 = null;
//
//            screen1 = screenService.getRowsCols(screenDTO);
//            System.out.println(screenDTO.getScreenId());
//            req.setAttribute("seatNumber", seatNumbersString);
//            req.setAttribute("screenLayoutRowAndColumn", screen1);
//
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
//
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ScreenLayout.jsp");
//        requestDispatcher.forward(req, resp);
//    }
//
//
//    private List<String> generateSeatNumbers(String noOfRows, String noOfColumns) {
////        List<String> seatNumbers = new ArrayList<>();
////
//        int numRows = Integer.parseInt(noOfRows);
//        int numCols = Integer.parseInt(noOfColumns);
////
////        for (int row = 1; row <= numRows; row++) {
////            for (int col = 1; col <= numCols; col++) {
////                char rowChar = (char) ('A' + (row - 1));
////                String seatNumber = rowChar + String.valueOf(col);
////                seatNumbers.add(seatNumber);
////            }
////        }
//        List<String> seatNumbers = new ArrayList<>();
//        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//
//        for (int row = 0; row < numRows; row++) {
//            for (int col = 0; col < numCols; col++) {
//                String seatNumber = String.format("%s%d", letters.charAt(row), col + 1);
//                seatNumbers.add(seatNumber);
//            }
//        }
//
//        return seatNumbers;
//    }
//}
