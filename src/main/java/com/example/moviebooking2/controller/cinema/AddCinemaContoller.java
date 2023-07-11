package com.example.moviebooking2.controller.cinema;

import com.example.moviebooking2.dao.AddressDao;
import com.example.moviebooking2.dao.CinemaDao;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.*;
import com.example.moviebooking2.service.CinemaService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
@MultipartConfig
public class AddCinemaContoller extends HttpServlet {
    private CinemaDao cinemaDao = new CinemaDao();
    private Cinema cinema = new Cinema();
    private Address address = new Address();
    private AddressDao addressDao = new AddressDao();
    private City city = new City();
    private CinemaService cinemaService = new CinemaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            List<State> stateList = cinemaService.getStateDetails();
            req.setAttribute("State", stateList);
            if (req.getParameter("stateID") != null) {
                int stateId = Integer.parseInt(req.getParameter("stateID"));
                List<City> cityList = cinemaService.getCityDetails(stateId);
                req.setAttribute("City", cityList);
            }
            req.getRequestDispatcher("AddCinema.jsp").forward(req, resp);
        } catch (DAOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Part imagePart = req.getPart("image");

        String imageFileName = getFileCinemaName(imagePart);
        String uploadDirectory = uploadCinemaFileAndGetImagePath(imagePart, imageFileName, servletContext);

        int cityId = Integer.parseInt(req.getParameter("cityId"));
        address.setAddressLine(req.getParameter("address"));
        address.setPincode(Integer.parseInt(req.getParameter("pincode")));
        try {
            cinemaService.addAddressDetails(address, cityId);
            address = cinemaService.getAddressID();
            int addressId = address.getAddressId();
            cinema.setName(req.getParameter("name"));//check
            cinema.setImage(uploadDirectory);
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("currentuser");
            int id = user.getUserId();
            cinemaService.addCinemaDetails(cinema, addressId, id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("cinema");
    }
    public static String getFileCinemaName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    public static String uploadCinemaFileAndGetImagePath(Part part, String fileName, ServletContext servletContext) throws IOException {
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
}
