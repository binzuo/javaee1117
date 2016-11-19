package Servlet;

import model.Book;
import util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/19 0019.
 */
@WebServlet(urlPatterns = "/book")
public class BookServlet  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionB=request.getParameter("actionB");
        if (actionB.equals("register")){
            register(request,response);

        }
        if (actionB.equals("chaXun")){
            chaXun(request,response);
        }
    }
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        String author=request.getParameter("author");
        String publish=request.getParameter("publish");
        String date=request.getParameter("date");
        double price=Double.valueOf(request.getParameter("price"));
        int amount=Integer.valueOf(request.getParameter("amount"));
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection= DB.getConnection();
            String sql="INSERT INTO Yonghu.book VALUES (NULL ,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,author);
            preparedStatement.setString(3,publish);
            preparedStatement.setString(4,date);
            preparedStatement.setDouble(5,price);
            preparedStatement.setInt(6,amount);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(null,preparedStatement,connection);
        }
        response.sendRedirect("/book?actionB=chaXun");




    }
    protected void chaXun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DB.getConnection();
            String sql = "SELECT * FROM Yonghu.book ORDER BY id";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Book> books = new ArrayList();
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("publish"),
                        resultSet.getString("date"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("amount")
                );
                books.add(book);


            }
            request.getSession().setAttribute("books", books);
            response.sendRedirect("home.jsp");



        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            DB.close(resultSet,preparedStatement,connection);
        }
    }




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
