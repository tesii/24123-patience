package com.auca.patience;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate user credentials using UserRepository
        if (UserRepository.isValidUser(email, password)) {
            // Successful login
            HttpSession session = request.getSession(true); // Create a session if it doesn't exist
            session.setAttribute("user", email); // Store user information in the session
            response.sendRedirect("homePage.html");
        } else {
            // Invalid login
            response.sendRedirect("PassRcover.html");
        }
    }
}


