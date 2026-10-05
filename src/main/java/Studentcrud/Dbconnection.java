package Studentcrud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/arun_db";
        String user = "root";
        String password = "Kumar$10";

        return DriverManager.getConnection(url, user, password);
    }
}