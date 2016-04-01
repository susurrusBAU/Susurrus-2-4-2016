/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javauitest.DatabaseSus;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javauitest.UIMain.UserLogin;
import javauitest.UIMain.UserRegister;

/**
 *
 * @author P
 */
public class Reg1 {
   public static boolean LogedinUser=false;
    public static boolean LogedinPass=false;
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   static Connection conn = null;
   static Statement stmt = null; 
   
   public static void main(String[] args) {
       System.out.println("heheeh");
       try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/susurrus5","root","root");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();
            String sql = "select * from lessons;";
            ResultSet rs=stmt.executeQuery(sql);
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
        for (int i = 1; i <= columnsNumber; i++) {
            if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
        }
        }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   }
}
