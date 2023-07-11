package com.example.moviebooking2.validation;

import com.example.moviebooking2.dto.CinemaDTO;
import com.example.moviebooking2.exception.Error;

import java.util.ArrayList;
import java.util.List;

public class AddCinemaValidation {
    public static List<Error> validateCinema(CinemaDTO cinemaDTO) {
        List<Error> errorList = new ArrayList<>();
        if (Validation.isEmpty(cinemaDTO.getName())) {
            errorList.add(new Error("Please enter Cinema name"));
        }
        if (Validation.isEmpty(cinemaDTO.getState().getStateName())) {
            errorList.add(new Error("Please select state name"));
        }
        if (Validation.isEmpty(cinemaDTO.getCity().getCityName())) {
            errorList.add(new Error("Please select city name"));
        }
        if (Validation.isEmpty(cinemaDTO.getAddress().getAddressLine())) {
            errorList.add(new Error("Please enter Address"));
        }
        if (Validation.isEmpty(cinemaDTO.getAddress().getPincode())) {
            errorList.add(new Error("Please enter Pincode"));
        }
        return errorList;
    }
}