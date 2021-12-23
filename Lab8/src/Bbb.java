import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.io.IOException;

public class Bbb extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String result = "Bbb: request headers";
        Enumeration headers = req.getHeaderNames();
        Enumeration params = req.getParameterNames();

        while (headers.hasMoreElements()) {
            String headerName = (String) headers.nextElement();
            if (headerName.contains("x"))
                result += "\n" + headerName + ": " + req.getHeader(headerName);
        }
        result += "\n";

        while (params.hasMoreElements()) {
            String paramName = (String) params.nextElement();
            result += "\n" + paramName + ": " + req.getParameter(paramName);
        }

        resp.addHeader("X-Bbb1", "15");
        resp.addHeader("X-Bbb2", "1478");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(result);

    }
}