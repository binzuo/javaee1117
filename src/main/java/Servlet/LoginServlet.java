package Servlet;

import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Administrator on 2016/11/18 0018.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        try {
            new Driver();
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Yonghu?user=root&password=xinabcd1234");
            String sql="SELECT * FROM Yonghu.message WHERE email=? AND password=?";
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1,email);
            p.setString(2,password);
            ResultSet r=p.executeQuery();

            if (r.next()){
                request.getSession().setAttribute("welcome","欢迎您："+email);
                response.sendRedirect("home.jsp");
            }else {
                request.getSession().setAttribute("您好：","您输入的账号或密码不正确");
                response.sendRedirect("index.jsp");
            }
            connection.close();
            p.close();
            r.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
