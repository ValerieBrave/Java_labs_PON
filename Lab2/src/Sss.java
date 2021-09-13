import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Sss extends HttpServlet {
    public void init(ServletConfig sc) throws ServletException{
        // инициализация сервлета
        super.init();
        System.out.println("Sss: init");
    }

    public void destroy(){
        // перед уничтожением сервлета
        super.destroy();
        System.out.println("Sss: destroy");
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        // обработка http-запроса
        //System.out.println("Sss: service: " + rq.getMethod());
//        try {
//
//        } catch (ServletException | IOException e) {
//            rs.sendError(500);
//        }
        if(rq.getMethod().equals("GET")) {
            System.out.println("entered if GET" + rq.getMethod());
            serveGet(rq, rs);
        } else if(rq.getMethod().equals("POST")) {
            servePost(rq, rs);
        }

    }

    protected void servePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body>"
                + "<br>Ppp:doPost:firstname = " + rq.getParameter("firstname")
                + "<br>Ppp:doPost:lastname = " + rq.getParameter("lastname")
                + "</body></html>");
        pw.close();
    }

    protected void serveGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        System.out.println("entered serveGet" + rq.getMethod());
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body>"
                +"<br>Sss: FirstName = " + rq.getParameter("firstname")
                +"<br>Sss: LastName = " + rq.getParameter("lastname")
                +"<br>Sss: getRemoteHost: " + rq.getQueryString()
                +"</body></html>");
        pw.close();
    }
}