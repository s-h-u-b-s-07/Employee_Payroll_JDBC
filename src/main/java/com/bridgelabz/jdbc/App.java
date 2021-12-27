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
       // Statement stmt = null;
        PreparedStatement preparedStatement = null;
        //jdbc:mysql://localhost:3306/emp?user=root&password=root
        //jdbc:derby:testdb
        try {
            //2.Step create connection
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bridgelabzdemo", "root", "S$hubham143");
            System.out.println("Got connected");


            //3. Create statement
         //   stmt = connection.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter employee name: ");
            String name = sc.next();
            System.out.println("Enter new salary");
            int salary = sc.nextInt();
//            String date = sc.next();
            String query = "update employee_payroll set salary =? where name = ? ;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,salary);
            preparedStatement.setString(2,name);
            int result = preparedStatement.executeUpdate();
            if (result>0){
                System.out.println("Salary updated Successfully");
            }



            //4 Execute query
//            String query = "select * from employee_payroll;";
          //  String query = "update employee_payroll set salary='30000' where name = 'Shubham';";
          //  int result = stmt.executeUpdate(query);
//            ResultSet result = stmt.executeQuery(query);
//            while (result.next()) {
//                String id = result.getString(1);
//                String name = result.getString(2);
//                String gender = result.getString(3);
//                String salary = result.getString(4);
//                String startdate = result.getString(5);
//                System.out.println("ID : "+ id + ", Name : "+ name + ", Gender : "+ gender + ", Salary : "+salary+
//                        ", StartDate : " + startdate);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
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
