/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcon;

import java.sql.*;


/**
 *
 * @author Asus
 */
public class dbconnection {
    private static Connection con;

    public static Connection getConnection() {
        try {

            if (con == null) {
                //driver class load
                Class.forName("com.mysql.cj.jdbc.Driver");

                //create a connection..
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ewallet", "root", "Bhanu@123");
                System.out.println("connection created....");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    
}
