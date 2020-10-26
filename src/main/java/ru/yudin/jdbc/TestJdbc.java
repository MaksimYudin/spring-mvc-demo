package ru.yudin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimeZone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {

            System.out.println("start connection");

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("connection success");

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
