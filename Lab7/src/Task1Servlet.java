package lab7;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Task1Servlet extends HttpServlet  {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpClient client = new HttpClient();
        PrintWriter printWriter = resp.getWriter();
        String urlnParam = req.getParameter("urln");
        ServletContext sc = getServletContext();
        String uri = sc.getInitParameter("URL" + urlnParam);

        if (uri != null) {
            GetMethod get = new GetMethod(uri);
            client.executeMethod(get);
            printWriter.println(get.getResponseBodyAsString());
        } else {
            printWriter.println("Parameter URLn not found");
        }
    }
}