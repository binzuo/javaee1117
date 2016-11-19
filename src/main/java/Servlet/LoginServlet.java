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

/**
 * Created by Administrator on 2016/11/18 0018.
 */
@WebServlet(urlPatterns ="/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email").trim().toLowerCase();
        String password=request.getParameter("password");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            new Driver();
            connection= DB.getConnection();
            String sql="SELECT * FROM Yonghu.message WHERE email=? AND password=?";
             preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                request.getSession().setAttribute("email",email);

                request.getSession().setAttribute("welcome","欢迎您"+email);
                response.sendRedirect("home.jsp");
            }else {
                request.setAttribute("message","您输入的账号或密码不正确");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(resultSet,preparedStatement,connection);
        }

    }
}
