import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.IOException;

public class Aaa extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://localhost:8180/Lab8/Bbb");

        post.addRequestHeader("X-Aaa1", "1");
        post.addRequestHeader("X-Aaa2", "2");
        post.addRequestHeader("X-Aaa3", "3");
        post.addParameter("X-Aaa1", "1");
        post.addParameter("X-Aaa2", "2");
        post.addParameter("X-Aaa3", "3");

        client.executeMethod(post);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Aaa: response body \n"+post.getResponseBodyAsString());
        printWriter.println("Aaa: All response Headers: ");

        Header[] headers = post.getResponseHeaders();

        for (Header header : headers)
            printWriter.println(header.getName() + ": " + header.getValue());
    }
}