package DBJava;

import java.sql.*;
import java.util.ArrayList;

public class SQLquery{
    public Connection conn;
    public Statement st;
    public String url="jdbc:mysql://localhost:3306/dbjava";
    public String user="root";
    public String password="1234";
    private ArrayList<Table> tables;
    private ArrayList<Menu> menus;
    private ArrayList<Customer> customers;
    

    public SQLquery(){

        // เชื่อมต่อ MySQL
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

    // เพิ่มข้อมูลใหม่ลงตาราง
    public void insert(String tableName, String columnNames, String values) throws SQLException {
        String query = "INSERT INTO " + tableName + "(" + columnNames + ") VALUES (" + values + ")";
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println("Data inserted successfully!");
    }

    // แก้ไขข้อมูล
    public void update(String tableName, String setValues, String whereClause) throws SQLException {
        String query = "UPDATE " + tableName + " SET " + setValues + " WHERE " + whereClause;
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println("Data updated successfully!");
    }

    // ลบข้อมูลบนตาราง
    public void delete(String tableName, String whereClause) throws SQLException {
        String query = "DELETE FROM " + tableName + " WHERE " + whereClause;
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println("Data deleted successfully!");
    }

    // แสดงข้อมูลของตาราง มีเงื่อนไข
    public ResultSet select(String tableName, String columnNames, String whereClause) throws SQLException {
        String query = "SELECT " + columnNames + " FROM " + tableName + " WHERE " + whereClause;
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    // ดึงข้อมูลจากฐานข้อมูล ArrayList 
    public ResultSet selectAr(String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName;
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }



    // ดึงข้อมูลจาก ตาราง Table 
    public ArrayList<Table> getTableList() throws SQLException{
        ResultSet rs = selectAr("tablenumber");
        // สร้าง ArrayList เพื่อเก็บข้อมูลที่ดึงมา
        tables = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("idTable");
            int cap= rs.getInt("Cap");
            String name = rs.getString("NameCus");
            String tel = rs.getString("TelCus");
            String time = rs.getString("DTime");
            String stus = rs.getString("Status");
            Table table = new Table(id, cap, name, tel, time, stus);
            tables.add(table);
        }
        return tables;

    }

    // ดึงข้อมูลจาก ตาราง MenuList 
    public ArrayList<Menu> getMenuList() throws SQLException{
        ResultSet rs = selectAr("menulist");
         // สร้าง ArrayList เพื่อเก็บข้อมูลที่ดึงมา
         menus = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("FoodName");
            String pr = rs.getString("Price");
            String type = rs.getString("Type");
            Menu menu = new Menu(id,name, pr, type);
            menus.add(menu);
        }
        return menus;

    }

     // ดึงข้อมูลจาก ตาราง Customer 
     public ArrayList<Customer> getCustomerList() throws SQLException{
        ResultSet rs = selectAr("customer");
         // สร้าง ArrayList เพื่อเก็บข้อมูลที่ดึงมา
         customers = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("idCustomer");
            String name = rs.getString("NameCustomer");
            String tel = rs.getString("TelCustomer");
            String eml = rs.getString("Email");
            int pint= rs.getInt("Point");
            Customer customer = new Customer(id, name, tel,eml, pint);
            customers.add(customer);
        }
        return customers;

    }
}