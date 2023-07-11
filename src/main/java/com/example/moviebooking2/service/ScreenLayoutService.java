package com.example.moviebooking2.service;

import com.example.moviebooking2.dao.ScreenLayoutDao;
import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.dto.ScreenLayoutDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.ScreenLayout;

import java.util.List;

public class ScreenLayoutService {
ScreenLayoutDao screenLayoutDao=new ScreenLayoutDao();
    public void saveSeatNumbers(String screenId,List<String> seatNumbers) throws DAOException {
        screenLayoutDao.storeSeatNumbers(screenId,seatNumbers);
    }
    public List<ScreenLayout> screenLayoutDisplayData(String ScreenId) throws DAOException {
        return screenLayoutDao.fetchSeatNumbersFromDatabase(ScreenId);
    }
}
