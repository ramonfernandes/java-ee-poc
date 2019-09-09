package com.ramonfernandes.javaeepoc.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSetup {

    public Connection getConn() throws SQLException {
        // db parameters

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ClassCastException();
        }

        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "password";
        // create a connection to the database
        return DriverManager.getConnection(url, user, password);
    }
}
