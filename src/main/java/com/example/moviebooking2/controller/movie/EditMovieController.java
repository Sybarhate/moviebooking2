package com.example.moviebooking2.controller.movie;

import com.example.moviebooking2.dto.MovieDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Movie;
import com.example.moviebooking2.service.MovieService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
@MultipartConfig
public class EditMovieController extends HttpServlet {
    MovieDTO movieDTO=new MovieDTO();
    MovieService movieService=new MovieService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            movieDTO.setId(request.getParameter("id"));
            movieDTO.setCinemaId(request.getParameter("cinemaId"));
            Movie movie = movieService.getMovieEditDetails(movieDTO);
//            request.setAttribute("Movie");
            request.setAttribute("id", movie.getId());
            request.setAttribute("cinemaId", movie.getCinemaId());
            request.setAttribute("title", movie.getTitle());
            request.setAttribute("duration", movie.getDuration());
            request.setAttribute("releasedDate",movie.getReleasedDate() );
            request.setAttribute("directorName", movie.getDirectorName());
            request.setAttribute("producerName",movie.getProducerName() );
            request.setAttribute("language",movie.getMovieLanguage() );
        } catch (DAOException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
        request.getRequestDispatcher("EditMovie.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        Part imagePart = request.getPart("movieImg");
        String imageFileName = getEditFileMovieName(imagePart);
        String uploadDirectory = uploadMovieFileAndGetImagePath1(imagePart, imageFileName, servletContext);
        movieDTO.setImage(uploadDirectory);
        movieDTO.setId(request.getParameter("id"));
        movieDTO.setCinemaId(request.getParameter("cinemaId"));
        movieDTO.setTitle(request.getParameter("title"));
        movieDTO.setDuration(request.getParameter("duration"));
        movieDTO.setReleasedDate(request.getParameter("releasedDate"));
        movieDTO.setDirectorName(request.getParameter("directorName"));
        movieDTO.setProducerName(request.getParameter("producerName"));
        movieDTO.setMovieLanguage(request.getParameter("language"));

        try {
            movieService.updateMovieDetails(movieDTO);
//            response.sendRedirect("moviecontroll");
             request.setAttribute("Cinema",movieDTO);
            response.sendRedirect("movie-management");
          //  request.getRequestDispatcher("moviecontroll?id="+movieDTO.getId()).forward(request, response);
        }catch (DAOException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }


    }
    public static String getEditFileMovieName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    public static String uploadMovieFileAndGetImagePath1(Part part, String fileName, ServletContext servletContext) throws IOException {
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
