package util;

import com.mysql.jdbc.Driver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/19.
 */
public class DB {
    private static final String URL="jdbc:mysql://localhost:3306/Yonghu";
    private static final String USER="root";
    private static final String PASSWORD="xinabcd1234";
    public static Connection getConnection(){
        try {
            new Driver();
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(ResultSet resultSet, java.sql.PreparedStatement preparedStatement, Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
