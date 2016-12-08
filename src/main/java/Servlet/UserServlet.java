package Servlet;
import util.DB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
@WebServlet(urlPatterns ="/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionA=request.getParameter("actionA");
        if (actionA.equals("emailWhetherExisted")){
            emailWhetherExisted(request,response);
        }
        if (actionA.equals("register")){
            register(request,response);
        }
        if (actionA.equals("login")){
            login(request,response);
        }
        if (actionA.equals("logout")){
            logout(request,response);
        }
    }
    private void emailWhetherExisted(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection= DB.getConnection();
            String sql="SELECT * FROM Yonghu.message WHERE email=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            resultSet=preparedStatement.executeQuery();
            response.setContentType("text/html charset=UTF-8");
            Writer writer = response.getWriter();
            if (resultSet.next()) {
                //System.out.println("email existed");
                writer.write("true");
            } else {
               // System.out.println("email not exist");
                writer.write("false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(resultSet,preparedStatement,connection);
        }
    }
    private void register(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email").trim().toLowerCase();
        String password=request.getParameter("password");
        String[] cities=request.getParameterValues("cities");
        String[] hobbies=request.getParameterValues("hobbies");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
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
    private void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String email=request.getParameter("email").trim().toLowerCase();
        String password=request.getParameter("password");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection= DB.getConnection();
            String sql="SELECT * FROM Yonghu.message WHERE email=? AND password=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                request.getSession().setAttribute("email",email);
                request.getSession().setAttribute("welcome","欢迎您"+email);
                response.sendRedirect("/book?actionB=chaXun");
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
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
