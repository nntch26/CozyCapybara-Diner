package DBJava;

import java.sql.*;

public class DatabaseConnect {
    public Connection conn;
    public Statement st;
    public String url="jdbc:mysql://localhost:3306/dbjava";
    public String user="root";
    public String password="1234";

    
    // เชื่อมต่อ MySQL
    public void DBConnect(){
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url, user, password);
            System.out.println("The connection to MySQL is complete.");

        }catch(Exception e){
            System.out.println("Unable to connect to MySQL : " + e.getMessage());
        }
    }


    // ปิดการทำงาน MySQL
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}