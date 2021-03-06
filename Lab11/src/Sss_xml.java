package lab11;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class Sss_xml extends HttpServlet implements Servlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Random random = new Random();
            Integer n = Integer.parseInt(request.getHeader("XRand-N"));
            StringBuilder textResult = new StringBuilder("<?xml version=\"1.0\"  encoding = \"utf-8\" ?>");
            Integer count = random.nextInt(6) + 5;

            textResult.append("<rand>");
            for (Integer i = 0; i < count; i++) {
                Integer number = random.nextInt(n*2) - n;
                textResult.append("<num>").append(number).append("</num>");
            }
            textResult.append("</rand>");

            Thread.sleep(5000);

            response.setContentType("text/xml");
            response.getWriter().println(textResult);
        } catch(Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}