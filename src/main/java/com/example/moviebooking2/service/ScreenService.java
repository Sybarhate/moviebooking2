package com.example.moviebooking2.service;

import com.example.moviebooking2.dao.CinemaDao;
import com.example.moviebooking2.dao.ScreenDao;
import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Cinema;
import com.example.moviebooking2.model.Screen;
import com.example.moviebooking2.model.State;

import java.util.List;

public class ScreenService {
    private CinemaDao cinemaDao = new CinemaDao();
    ScreenDao screenDao = new ScreenDao();

    public List<Cinema> getCinemaDetails(int userId) throws DAOException {
        List<Cinema> cinemaList = cinemaDao.getCinemaDetails(userId);
        return cinemaList;
    }

    public List<Screen> getScreenDataByCinemaId(ScreenDTO screenDTO) throws DAOException {
        return screenDao.getScreenData(screenDTO);
    }

    public Screen getScreenDetails(ScreenDTO screenDTO) throws DAOException {
       return screenDao.getEditScreenDetails(screenDTO);
    }
    public void updateScreenDetails(ScreenDTO screenDTO) throws DAOException {
        screenDao.updateScreenDetails(screenDTO);
    }
    public void deleteScreens(ScreenDTO screenDTO) throws DAOException {
        screenDao.deleteScreen(screenDTO);
    }
    public ScreenDTO addScreenDetails(ScreenDTO screenDTO) throws DAOException {
        return screenDao.addScreenData(screenDTO);
    }

    public Screen  getRowsCols(ScreenDTO screenDTO) throws DAOException {
       return screenDao.getRowsCols(screenDTO);
    }
}