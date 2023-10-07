
package com.control;

import com.dao.SignUpDao;
import com.model.SignUp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SignUpServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUpServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpServlet at " + request.getContextPath() + "</h1>");
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
        
        SignUpDao signUpDao = new SignUpDao();
        signUpDao.saveStudent(signUp);
        
         String email = request.getParameter("email");
         Properties props = new Properties();
//         props.put("mail.smtp.host", "smtp.gmail.com");
//         props.put("mail.smtp.socketFactory.port", "465");
//         props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//         props.put("mail.smtp.auth", "true");
//         props.put("mail.smtp.port", "465");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "587");
          Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

               return new PasswordAuthentication("tesipatience15@gmail.com", "oaajxfvdqbuihyxh");

             

            }
         });
         try {
         // Create a new email message
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("tesipatience15@gmail.com"));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
         message.setSubject("Confirmation Email");
         message.setText("Thank you for registering.");

         // Send the email message
         Transport.send(message);

         // Redirect the user to a confirmation page
         response.sendRedirect("signin.html");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
     }

//        response.sendRedirect("signin.html");
        
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
