package com.example.moviebooking2.service;

import com.example.moviebooking2.dao.UserDao;
import com.example.moviebooking2.dto.CredentialDTO;
import com.example.moviebooking2.dto.SignUpDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.User;

public class UserService {

    private UserDao userDAO = new UserDao();

    public User getUserByCredentials(CredentialDTO credentialDTO) throws DAOException {
        return userDAO.checkUserCredential(credentialDTO);
    }

    public SignUpDTO createUser(SignUpDTO signUpDTO) throws DAOException {
       return userDAO.createUser(signUpDTO);
    }

}
