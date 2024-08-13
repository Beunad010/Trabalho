package com.mycompany.projetoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/BancoDB";
    private static final String USER = "root";  // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = "";  // Substitua pela sua senha do MySQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}