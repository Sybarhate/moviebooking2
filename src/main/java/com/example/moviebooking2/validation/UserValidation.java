package com.example.moviebooking2.validation;

import com.example.moviebooking2.dto.CredentialDTO;
import com.example.moviebooking2.dto.SignUpDTO;
import com.example.moviebooking2.exception.Error;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {

    public static List<Error> validate(CredentialDTO credentialDTO) {
        List<Error> errorList = new ArrayList<>();
        if (Validation.isEmpty(credentialDTO.getUserName())) {
            errorList.add(new Error("Please enter user name"));
        }
        if (Validation.isEmpty(credentialDTO.getPassword())) {
            errorList.add(new Error("Please enter password"));
        }
        return errorList;
    }

    public static List<Error> validateUser(SignUpDTO signUpDTO) {
        List<Error> errorList = new ArrayList<>();
        if (Validation.isEmpty(signUpDTO.getFirstName())) {
            errorList.add(new Error("Please enter First name"));
        }
        if (Validation.isEmpty(signUpDTO.getLastName())) {
            errorList.add(new Error("Please enter Last name"));
        }
        if (Validation.isEmpty(signUpDTO.getEmail())) {
            errorList.add(new Error("Please enter Email"));
        }
        if (Validation.isEmpty(signUpDTO.getMobileNumber())) {
            errorList.add(new Error("Please enter Mobile number"));
        }
        if (Validation.isEmpty(signUpDTO.getDateOfBirth())) {
            errorList.add(new Error("Please enter Date of Birth"));
        }
        if (Validation.isEmpty(signUpDTO.getGender())) {
            errorList.add(new Error("Please select Gender"));
        }
        if (Validation.isEmpty(signUpDTO.getAddress())) {
            errorList.add(new Error("Please enter Address"));
        }
        if (Validation.isEmpty(signUpDTO.getPassword())) {
            errorList.add(new Error("Please enter Password"));
        }
        if (Validation.isEmpty(signUpDTO.getRoleId())) {
            errorList.add(new Error("Please Select Role Id"));
        }
        return errorList;
    }


}
