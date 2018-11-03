package com.scj.xingzhengquyu.dao;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlOption {
    public static Statement sqlConntion(){
        Statement statement = null;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://132.323.9.41:3306/sancaijia";
            String user = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
