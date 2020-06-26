package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBprocessor {

    private Connection connection;

    public DBprocessor() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    }

    public Connection getConnection(String url, String username, String password) throws SQLException {
        if (connection != null)
            return connection;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
