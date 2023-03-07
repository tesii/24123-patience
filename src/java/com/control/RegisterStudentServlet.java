
package com.control;


import com.dao.SignUpDao;
import com.model.SignUp;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterStudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterStudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterStudentServlet at " + request.getContextPath() + "</h1>");
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
                  SignUpDao signUpdao = new SignUpDao();
            
         System.out.println(request.getParameter("email"));
         String email = request.getParameter("email");
//         SignUp user = signUpdao.findStudentByEmail(email);
        SignUp user = signUpdao.findStudentByEmail(request.getParameter("email"));
       user.setEmail(request.getParameter("email"));
       user.setFirstname(request.getParameter("fname"));
       user.setLastname(request.getParameter("lastname"));
       user.setGender(request.getParameter("gender"));
       user.setAge(request.getParameter("age"));
       user.setCountry(request.getParameter("country"));
       user.setPhoto(request.getParameter("photo"));
       user.setFile(request.getParameter("file"));

        SignUpDao registerdao = new SignUpDao();
        registerdao.updateStudent(user);
        response.sendRedirect("index.html");
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
