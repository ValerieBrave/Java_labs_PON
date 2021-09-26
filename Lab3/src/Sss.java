import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
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
    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }
    protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss:service");
        String type = rq.getParameter("type");
        String action = rq.getParameter("action");
        System.out.println("type = "+type);
        System.out.println("action = "+action);
        if(type!=null && type.equals("forward")) {
            System.out.println("Sss:forward");
            RequestDispatcher rd = null;
            rd = rq.getRequestDispatcher("/Ggg");
            // объекты запроса и ответа остаются теми же
            rd.forward(rq, rs);
        } else if(type!=null && type.equals("redirect")) {
            System.out.println("Sss:redirect");
            rs.setStatus(307);
            rs.setHeader("Location", "Ggg");
        } else if(type==null && action != null) {
            HttpClient hc = new HttpClient();
            if(rq.getMethod().equals("GET")) {
                GetMethod gm = new GetMethod("http://localhost:8180/Lab3/Ggg?type=request&firstname=aaa&lastname=bbb");
                hc.executeMethod(gm);
                rs.setContentType("text/html");
                PrintWriter pw = rs.getWriter();
                pw.println(gm.getResponseBodyAsString());
                pw.flush();
            } else if(rq.getMethod().equals("POST")) {
                PostMethod gm = new PostMethod("http://localhost:8180/Lab3/Ggg");
                gm.addParameter("type",action);
                gm.addParameter("firstname","aaa");
                gm.addParameter("lastname","bbb");
                hc.executeMethod(gm);
                rs.setContentType("text/html");
                PrintWriter pw = rs.getWriter();
                pw.println(gm.getResponseBodyAsString());
                pw.flush();
            }
        }
    }
}