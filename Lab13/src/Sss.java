import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Sss extends HttpServlet {
    BufferedWriter writer;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("file");
        String docdir = getServletContext().getInitParameter("docs");
        System.out.println("context param " + docdir);

        if (filename == null) {
            Find files = new Find(docdir, "docx");
            resp.setContentType("text/html");

            StringBuilder result = new StringBuilder();
            for (String file : files.list) {
                result.append("<br>").append("<a href='/Lab13/files?file=").append(file).append("' >").append(file).append("</a>");
            }
            resp.getWriter().println(result);
        }
        else {
            try {
                //пересылка word клиенту
                lofFile(filename);
                File doc = new File(docdir.concat("\\").concat(filename));
                resp.setContentType("application/msword");
                resp.addHeader("Content-Disposition", "attachment; filename="+ doc.getName());
                resp.setContentLength((int) doc.length());

                FileInputStream in = new FileInputStream(doc);
                BufferedInputStream buf = new BufferedInputStream(in);
                ServletOutputStream out = resp.getOutputStream();
                int readBytes = 0;
                while ((readBytes = buf.read()) != -1) {
                    out.write(readBytes);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    public  void  lofFile(String fileName) throws IOException {

        System.out.println("log");
        writer = new BufferedWriter(new FileWriter("D:\\Java_labs\\Lab13\\stdout.txt", true));
        writer.append(fileName);
        writer.append("\n");
        writer.close();
    }
}