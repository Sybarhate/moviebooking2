package com.example.moviebooking2.screen;
import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Screen;
import com.example.moviebooking2.service.ScreenService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditScreenController extends HttpServlet {
        private ScreenDTO screenDTO = new ScreenDTO();
        private ScreenService screenService=new ScreenService();
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            String screenId = request.getParameter("id");
//            String name = request.getParameter("name");
//            String noOfRows = request.getParameter("noOfRows");
//            String noOfCols = request.getParameter("noOfCols");
            screenDTO.setScreenId(request.getParameter("id"));
            screenDTO.setName(request.getParameter("name"));
            screenDTO.setNoOfRows(request.getParameter("noOfRows"));
            screenDTO.setNoOfColumns(request.getParameter("noOfCols"));
            try {
            screenService.updateScreenDetails(screenDTO);
                response.sendRedirect("screencontrol");
            } catch ( IOException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                screenDTO.setScreenId(request.getParameter("id"));
                screenDTO.setCinemaId(request.getParameter("cinemaId"));
                Screen screen = screenService.getScreenDetails(screenDTO);
                request.setAttribute("cinemaId", screen.getCinemaId());
                request.setAttribute("screenId", screen.getScreenId());
                request.setAttribute("screenName", screen.getName());
                request.setAttribute("noOfRows", screen.getNoOfRows());
                request.setAttribute("noOfCols", screen.getNoOfColumns());
            } catch (DAOException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
            request.getRequestDispatcher("EditScreen.jsp").forward(request, response);

        }


    }
