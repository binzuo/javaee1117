package Servlet;

import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/18 0018.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String[] cities=request.getParameterValues("cities");
        String[] hobbies=request.getParameterValues("hobbies");

        try {
            new Driver();
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Yonghu?user=root&password=xinabcd1234");
            String sql="INSERT INTO Yonghu.message VALUES(NULL,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3, Arrays.asList(cities).toString());
            preparedStatement.setString(4,Arrays.asList(hobbies).toString());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            //request.setAttribute("提示：","恭喜您注册成功");
            //request.getRequestDispatcher("index.jsp").forward(request,response);
            response.sendRedirect("index.jsp");


    }
}
