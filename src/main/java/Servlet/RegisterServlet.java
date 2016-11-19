package Servlet;

import com.mysql.jdbc.Driver;
import util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/18 0018.
 */
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email").trim().toLowerCase();
        String password=request.getParameter("password");
        String[] cities=request.getParameterValues("cities");
        String[] hobbies=request.getParameterValues("hobbies");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            new Driver();
            connection= DB.getConnection();
            String sql="INSERT INTO Yonghu.message VALUES(NULL,?,?,?,?)";
             preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3, Arrays.asList(cities).toString());
            preparedStatement.setString(4,Arrays.asList(hobbies).toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(null,preparedStatement,connection);
        }
            //request.setAttribute("提示：","恭喜您注册成功");
            //request.getRequestDispatcher("index.jsp").forward(request,response);
            response.sendRedirect("index.jsp");


    }
}
