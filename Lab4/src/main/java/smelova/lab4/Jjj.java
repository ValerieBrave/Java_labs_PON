package smelova.lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
//
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

@WebServlet(name = "Jjj", value = "/Jjj")
public class Jjj extends HttpServlet {

    private TimeHelper timeHelper = new TimeHelper();
    private String timeName = this.timeHelper.GetTimeName(LocalDateTime.now().getHour());

    private void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher(timeName + ".jsp").forward(req,resp);
    }
    private void getToJsp(HttpServletResponse resp) throws IOException{
        HttpClient hc = new HttpClient();
        //GetMethod gm = new GetMethod("http://localhost:8180/Lab4/"+timeName+".jsp");
        PostMethod gm = new PostMethod("http://localhost:8180/Lab4/"+timeName+".jsp");
        hc.executeMethod(gm);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println(gm.getResponseBodyAsString());
        pw.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToJsp(req, resp);
        //getToJsp(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToJsp(req, resp);
        //getToJsp(resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("POST")) {
            this.doPost(req, resp);
        } else if (req.getMethod().equals("GET")) {
            this.doGet(req, resp);
        }
    }
}
