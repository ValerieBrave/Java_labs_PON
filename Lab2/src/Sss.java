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

//    protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        // обработка http-запроса
//        System.out.println("Sss: service");
//        if(rq.getMethod().equals("GET")) {
//            serveGet(rq, rs);
//        } else if(rq.getMethod().equals("POST")) {
//            servePost(rq, rs);
//        }
//
//    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        System.out.println("Sss: servePost");
        pw.println("<html><body>"
                + "<br>Ppp:doPost:firstname = " + rq.getParameter("firstname")
                + "<br>Ppp:doPost:lastname = " + rq.getParameter("lastname")
                + "</body></html>");
        pw.close();
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        System.out.println("Sss: serveGet");
        pw.println("<html><body>"
                +"<br>Sss: FirstName = " + rq.getParameter("firstname")
                +"<br>Sss: LastName = " + rq.getParameter("lastname")
                +"<br>Sss: getQueryString: " + rq.getQueryString()
                +"</body></html>");
        pw.close();
    }
}