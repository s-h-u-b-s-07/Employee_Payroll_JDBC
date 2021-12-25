package com.bridgelabz.jdbc;

import java.sql.*;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {

        //1. load driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded Driver class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement stmt = null;
        //jdbc:mysql://localhost:3306/emp?user=root&password=root
        //jdbc:derby:testdb
        try {
            //2.Step create connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bridgelabzdemo", "root", "S$hubham143");
            System.out.println("Got connected");

            //3. Create statement
            stmt = connection.createStatement();
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            int id = sc.nextInt();
            String date = sc.next();

            //4 Execute query
            String query = "select * from employee_payroll;";
           // int result = stmt.executeUpdate(query);
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.println(result.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
