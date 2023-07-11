//package com.example.moviebooking2.controller;
//
//import com.example.moviebooking2.dao.UserDao;
//import com.example.moviebooking2.model.User;
//
//import java.io.*;
//import javax.servlet.http.*;
//
//public class aaa extends HttpServlet {
//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//        PrintWriter printWriter=response.getWriter();
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        UserDao userDAO = new UserDao();
//        User user = userDAO.checkUserCredential(email, password);
//
//        if (user != null && user.getPassword().equals(password)) {
//           // response.sendRedirect("welcome.jsp");
//        printWriter.println("login successfull");
//        } else {
//            //response.sendRedirect("login.jsp?error=invalid_credentials");
//            printWriter.println("ERROR try again");
//        }
////        Connection connection = null;
////        try {
////
////            Class.forName("com.mysql.cj.jdbc.Driver");
////            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
////            // Hello
////            PrintWriter out = response.getWriter();
////            out.println("<html><body>");
////            out.println("<h1>" + connection.getMetaData().getDatabaseProductName() + "</h1>");
////            out.println("</body></html>");
////        } catch (ClassNotFoundException e) {
////
////            e.printStackTrace();
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////
////    }
//
//}}