package servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.Enumeration;

public class Bbb extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Url = "jdbc:sqlserver://DESKTOP-BCBSGG7\\SQLEXPRESS:1433;databaseName=univer;Trusted_Connection=No;user=svv;password=svv";
        int param1 = Integer.parseInt(req.getParameter("param1"));
        int param2 = Integer.parseInt(req.getParameter("param2"));
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Trying to connect");
            Connection connection = DriverManager.getConnection(Url);
            System.out.println("Connection Established Successfull");

            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Students where id > ? and id < ?");
            pstmt.setInt(1, param1 );
            pstmt.setInt(2, param2);
            ResultSet rs = pstmt.executeQuery();

            PrintWriter out = resp.getWriter();
            while (rs.next()) {
                out.println(
                        "Id:" + rs.getString("Id") +
                                " Name:" + rs.getString("Name") +
                                " Phone:" + rs.getString("Phone")
                );
            }

        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }
}