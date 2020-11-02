package ru.yudin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimeZone=UTC";
        //String user = "hbstudent";
        //String pass = "hbstudent";
        String user = "springstudent";
        String pass = "springstudent";

        try {

            System.out.println("start connection");

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("connection success");

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
