package com.example.moviebooking2.controller.user;

import com.example.moviebooking2.constant.AppConstant;
import com.example.moviebooking2.dto.CredentialDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.exception.Error;
import com.example.moviebooking2.model.User;
import com.example.moviebooking2.service.UserService;
import com.example.moviebooking2.validation.UserValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController extends HttpServlet {

    private UserService userService = new UserService();

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        CredentialDTO credentialDTO = new CredentialDTO();
        credentialDTO.setUserName(request.getParameter("email"));
        credentialDTO.setPassword(request.getParameter("password"));
        List<Error> errorList = UserValidation.validate(credentialDTO);
        if (!errorList.isEmpty()) {
            request.setAttribute("errorList", errorList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
            return;
        }

        User user = null;
        try {
            user = userService.getUserByCredentials(credentialDTO);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        if (user == null) {
            errorList = new ArrayList<>();
            errorList.add(new Error("Wrong credentials"));
            request.setAttribute("errorList", errorList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("currentuser", user);
        RequestDispatcher requestDispatcher = null;
        if (user.isVerified()) {
            if (user.getRoleId() == AppConstant.ROLE_CINEMA_USER) {
                requestDispatcher = request.getRequestDispatcher("cinemaAdminMenu.jsp");
            } else if (user.getRoleId() == AppConstant.ROLE_CUSTOMER) {
                requestDispatcher = request.getRequestDispatcher("CustomerPage.jsp");
            } else {
                requestDispatcher = request.getRequestDispatcher("error.jsp");
            }
            requestDispatcher.forward(request, response);
        }
        else{
            requestDispatcher = request.getRequestDispatcher("Verification.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}