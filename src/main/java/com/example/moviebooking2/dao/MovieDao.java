package com.example.moviebooking2.dao;

import com.example.moviebooking2.dto.MovieDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Movie;

import javax.servlet.http.HttpServlet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao extends HttpServlet {

    public void addMovie(MovieDTO movieDTO) throws DAOException {
        try {
            PreparedStatement statement = null;
            String sql = "insert into movie(image,title,duration,released_date,director_name,producer_name,movie_language,cinema_id) values (?,?,?,?,?,?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, movieDTO.getImage());
            statement.setString(2, movieDTO.getTitle());
            statement.setInt(3, Integer.parseInt(movieDTO.getDuration()));
            statement.setString(4, movieDTO.getReleasedDate());
            statement.setString(5, movieDTO.getDirectorName());
            statement.setString(6, movieDTO.getProducerName());
            statement.setString(7, movieDTO.getMovieLanguage());
            statement.setInt(8, Integer.parseInt(movieDTO.getCinemaId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Something went wrong", e);
        }
    }


    public List<Movie> getMovies(MovieDTO movieDTO) throws DAOException {
        List<Movie> movies = new ArrayList<>();
        try {
            String sql = "SELECT * FROM movie where cinema_id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(movieDTO.getCinemaId()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(Integer.parseInt(resultSet.getString("id")));
                movie.setImage((resultSet.getString("image")));
                movie.setTitle(resultSet.getString("title"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setReleasedDate(resultSet.getString("released_date"));
                movie.setDirectorName(resultSet.getString("director_name"));
                movie.setProducerName(resultSet.getString("producer_name"));
                movie.setMovieLanguage(resultSet.getString("movie_language"));
                movie.setCinemaId(Integer.parseInt(resultSet.getString("cinema_id")));
                movies.add(movie);
            }
        } catch (SQLException e) {
            throw new DAOException("Error while retrieving movie details", e);
        }

        return movies;
    }

    public void updateMovieDetails(MovieDTO movieDTO) throws DAOException {
        try {
            String sql = "UPDATE movie SET image=?, title=?, duration=?, released_date=?, director_name=?,producer_name=?,movie_language=?WHERE id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, movieDTO.getImage());
            statement.setString(2, movieDTO.getTitle());
            statement.setString(3, movieDTO.getDuration());
            statement.setString(4, movieDTO.getReleasedDate());
            statement.setString(5, movieDTO.getDirectorName());
            statement.setString(6, movieDTO.getProducerName());
            statement.setString(7, movieDTO.getMovieLanguage());
            statement.setString(8, movieDTO.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error updating movie details", e);
        }
    }


    public void deleteMovie(MovieDTO movieDTO) throws DAOException {
        try {
            String sql = "DELETE FROM movie WHERE id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(movieDTO.getId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error deleting movie with ID: ", e);
        }
    }

    public Movie getEditMovieDetails(MovieDTO movieDTO) throws DAOException {
        Movie movie = new Movie();

        try {
            String sql = "SELECT id,title,duration,released_date,director_name,producer_name,movie_language FROM movie where id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(movieDTO.getId()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                movie.setId(resultSet.getInt(1));
                movie.setTitle(resultSet.getString(2));
                movie.setDuration(resultSet.getInt(3));
                movie.setReleasedDate(resultSet.getString(4));
                movie.setDirectorName(resultSet.getString(5));
                movie.setProducerName(resultSet.getString(6));
                movie.setMovieLanguage(resultSet.getString(7));
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving movie details", e);
        }
        return movie;
    }
}



