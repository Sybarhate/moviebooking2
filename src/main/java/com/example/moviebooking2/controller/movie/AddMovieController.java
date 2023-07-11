package com.example.moviebooking2.controller.movie;

import com.example.moviebooking2.dto.MovieDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.service.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
@MultipartConfig
public class AddMovieController extends HttpServlet {
    private MovieDTO movieDTO = new MovieDTO();
    MovieService movieService = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
        String cinemaID = req.getParameter("cinema");
        req.setAttribute("cinemaId", cinemaID);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddMovie.jsp");
        requestDispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Part imagePart = req.getPart("image");

            String imageFileName = getFileName(imagePart);
            String uploadDirectory = uploadFileAndGetImagePath(imagePart, imageFileName, servletContext);

        movieDTO.setId(req.getParameter("id"));
        movieDTO.setImage(uploadDirectory);
        movieDTO.setTitle(req.getParameter("title"));
        movieDTO.setDuration(req.getParameter("duration"));
        movieDTO.setReleasedDate(req.getParameter("releasedDate"));
        movieDTO.setDirectorName(req.getParameter("directorName"));
        movieDTO.setProducerName(req.getParameter("producerName"));
        movieDTO.setMovieLanguage(req.getParameter("language"));
        movieDTO.setCinemaId(req.getParameter("cinemaId"));
        try {
            movieService.addMovieDetails(movieDTO);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("movie-management");
    }
    public static String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    public static String uploadFileAndGetImagePath(Part part, String fileName, ServletContext servletContext) throws IOException {
        String basePath = servletContext.getRealPath("/");
        String savePath = basePath + "movie" + File.separator + fileName;
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

        String imagePath = "movie" + File.separator + fileName;
        return imagePath;
    }
}

