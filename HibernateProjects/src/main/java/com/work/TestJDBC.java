package com.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        System.out.println("Connecting to DB: " + jdbcUrl);

        try (Connection con = DriverManager.getConnection(jdbcUrl, user, pass)) {
            System.out.println("Connection successful!");
        }
    }
}