package com.example.moviebooking2.controller.user;

import com.example.moviebooking2.common.EmailService;
import com.example.moviebooking2.common.Utility;
import com.example.moviebooking2.dao.RoleDao;
import com.example.moviebooking2.dto.SignUpDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.exception.Error;
import com.example.moviebooking2.model.Role;
import com.example.moviebooking2.service.UserService;
import com.example.moviebooking2.validation.UserValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SignUpController extends HttpServlet {
    private UserService userService = new UserService();
    private SignUpDTO signUpDTO = new SignUpDTO();
    private EmailService emailService = new EmailService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fillSignUpMasterData(req);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SignUp.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        signUpDTO.setFirstName(request.getParameter("firstName"));
        signUpDTO.setLastName(request.getParameter("lastName"));
        signUpDTO.setEmail(request.getParameter("email"));
        signUpDTO.setMobileNumber(request.getParameter("mobileNumber"));
        signUpDTO.setDateOfBirth(request.getParameter("dateOfBirth"));
        signUpDTO.setGender(request.getParameter("gender"));
        signUpDTO.setAddress(request.getParameter("address"));
        signUpDTO.setPassword(request.getParameter("password"));
        signUpDTO.setRoleId((request.getParameter("roleId")));

        List<Error> errorList = UserValidation.validateUser(signUpDTO);
        if (!errorList.isEmpty()) {
            fillSignUpMasterData(request);
            request.setAttribute("errorList", errorList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("SignUp.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        try {
            String verificationCode = Utility.generateVerificationCode();
            signUpDTO.setVerificationCode(verificationCode);
            userService.createUser(signUpDTO);
            sendMail(signUpDTO);
            request.setAttribute("user",signUpDTO.getUserId());


        } catch (DAOException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Verification.jsp");
        requestDispatcher.forward(request, response);
    }

    private void fillSignUpMasterData(HttpServletRequest request) {
        RoleDao roleDao = new RoleDao();
        List<Role> roles = roleDao.getRole();
        request.setAttribute("Role", roles);
    }

    private void sendMail(SignUpDTO signUpDTO) {

        StringBuilder mailContent = new StringBuilder();
        mailContent.append("<H1>")
                .append("Hi, ").append(signUpDTO.getFirstName()).append(" ").append(signUpDTO.getLastName())
                .append("</H1>")
                .append("Your verification code :").append(signUpDTO.getVerificationCode());
        emailService.sendMail(signUpDTO.getEmail(), "Movie Booking: verification code", mailContent.toString());
    }

}

