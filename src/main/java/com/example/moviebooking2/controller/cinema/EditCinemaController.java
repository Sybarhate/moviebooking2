package com.example.moviebooking2.controller.cinema;

import com.example.moviebooking2.dao.CinemaDao;
import com.example.moviebooking2.dto.CinemaDTO;
import com.example.moviebooking2.dto.CityDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Address;
import com.example.moviebooking2.model.Cinema;
import com.example.moviebooking2.model.City;
import com.example.moviebooking2.model.State;
import com.example.moviebooking2.service.CinemaService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@MultipartConfig
public class EditCinemaController extends HttpServlet {
    private CinemaDao cinemaDao = new CinemaDao();
    private CinemaService cinemaService = new CinemaService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        Part imagePart = request.getPart("img");
        String imageFileName = getEditFileCinemaName(imagePart);
        String uploadDirectory = uploadCinemaFileAndGetImagePath1(imagePart, imageFileName, servletContext);

        int cinemaId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String state = request.getParameter("stateId");
        String city = request.getParameter("cityId");
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityId(city);
        CinemaDTO cinemaDTO = new CinemaDTO();

        try {
            cinemaDao.updateCinema(uploadDirectory, cinemaId, name, address);
            cinemaDao.updateCity(cinemaId, city);
            response.sendRedirect("cinema");
        } catch (DAOException | IOException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
        public static String getEditFileCinemaName(Part part) {
            String contentDisposition = part.getHeader("content-disposition");
            String[] elements = contentDisposition.split(";");
            for (String element : elements) {
                if (element.trim().startsWith("filename")) {
                    return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
                }
            }
            return null;
        }
        public static String uploadCinemaFileAndGetImagePath1(Part part, String fileName, ServletContext servletContext) throws IOException {
            String basePath = servletContext.getRealPath("/");
            String savePath = basePath + "cinema" + File.separator + fileName;
            File outputFile = new File(savePath);

            InputStream inputStream = part.getInputStream();
            OutputStream outputStream = new FileOutputStream(outputFile);
            int read;
            byte[] buffer = new byte[4096];
            while ((read = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, read);
            }
            inputStream.close();
            outputStream.close();

            String imagePath = "cinema" + File.separator + fileName;
            return imagePath;
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String state = request.getParameter("stateId");
//        String city = request.getParameter("cityId");

        try {
            String cinemaId = request.getParameter("id");
            Cinema cinema = cinemaDao.getEditCinemaDetails(Integer.parseInt(cinemaId));
            List<State> stateList = cinemaService.getStateDetails();
            request.setAttribute("State", stateList);

            request.setAttribute("stateid", cinema.getState().getStateId());
            System.out.println("stateID" + cinema.getState().getStateId());
            request.setAttribute("cityID", cinema.getCity().getCityId());

            if (request.getParameter("stateID") != null) {
                int stateId = Integer.parseInt(request.getParameter("stateID"));
                List<City> cityList = cinemaService.getCityDetails(stateId);
                request.setAttribute("City", cityList);
            }

            request.setAttribute("cinemaId", cinema.getId());
            request.setAttribute("cinemaImage", cinema.getImage());
            request.setAttribute("cinemaName", cinema.getName());
            request.setAttribute("cinemaAddress", cinema.getAddress().getAddressLine());
            request.setAttribute("cinemaCity", cinema.getCity().getCityName());
            request.setAttribute("cinemaState", cinema.getState().getStateName());

        } catch (DAOException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
        request.getRequestDispatcher("EditCinema.jsp").forward(request, response);

    }

}