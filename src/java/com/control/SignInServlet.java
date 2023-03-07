/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.dao.SignUpDao;
import com.model.SignUp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sethr
 */
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignInServlet"})
public class SignInServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignInServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignInServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          SignUp signUp = new SignUp();
          signUp.setEmail(request.getParameter("email"));
          signUp.setPassword(request.getParameter("password"));
          
          SignUpDao signUpdao = new SignUpDao();
     String email = request.getParameter("email");
                  SignUp user = signUpdao.findStudentByEmail(email);
          if( user != null && user.getEmail().equals(signUp.getEmail())){
              HttpSession session = request.getSession();
              session.setAttribute("email", user);
              response.sendRedirect("student.html");
          }else{
              request.setAttribute("Error message", "invalid email or password");
              RequestDispatcher rd = request.getRequestDispatcher("signin.html");
              rd.forward(request, response);
          }
               
          
          
//          SignUp login = signUpdao.findStudent(signUp);
//          if(login != null){
//              if(login.getEmail().equals(signUp.getEmail())){
//                  response.sendRedirect("student.html");
//              }else{
//                  response.sendRedirect("signup.html");
//              }
//          }else{
//              response.sendRedirect("signup.html");
//          }
//        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
