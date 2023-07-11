package com.example.moviebooking2.controller.user;

import com.example.moviebooking2.dao.UserDao;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VerificationController extends HttpServlet {
    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String verificationCode = request.getParameter("verification-code");
        User user = null;

        HttpSession session = request.getSession(false);

        try {
            user = (User) session.getAttribute("currentuser");
            if (user != null) {
                if (verificationCode.equals(user.getVerificationCode())) ;

                userDao.updateUserIsVerified(true, user.getEmail());
            } else {
                int userId = Integer.parseInt(request.getParameter("userId"));
                User user1 = userDao.getUserById(userId);
                if (verificationCode.equals(user1.getVerificationCode())) {
                    userDao.updateUserIsVerified(true, user1.getEmail());
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
