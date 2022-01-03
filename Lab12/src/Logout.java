package lab12;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Servlet:Logout");
        if (request.getSession() != null) {
            request.getSession().invalidate();//remove session.
        }
        request.logout();//JAAS log out (from servlet specification)! It is a MUST!
        response.sendRedirect("http://localhost:8180/Lab12/index.jsp");
    }
}