import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ggg extends HttpServlet {
    public Ggg() {
        super();
        System.out.println("Ggg:constructor");
    }
    protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Ggg:service");
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body>"
        + "<h3>Ggg servlet</h3>"
        + "<h3>"+rq.getMethod()+"</h3>"
        + "<br>type = " + rq.getParameter("type")
        + "<br>firstname = " + rq.getParameter("firstname")
        + "<br>lastname = " + rq.getParameter("lastname")
        + "</body></html>");
        pw.close();
    }
}