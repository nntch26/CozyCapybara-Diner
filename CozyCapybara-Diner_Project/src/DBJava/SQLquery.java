package DBJava;

import java.sql.*;

public class SQLquery extends DatabaseConnect {

    public SQLquery(){
        DBConnect();
    }

    public void insert(String tableName, String columnNames, String values) throws SQLException {
        String query = "INSERT INTO " + tableName + "(" + columnNames + ") VALUES (" + values + ")";
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println("Data inserted successfully!");
    }

    public void update(String tableName, String setValues, String whereClause) throws SQLException {
        String query = "UPDATE " + tableName + " SET " + setValues + " WHERE " + whereClause;
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println("Data updated successfully!");
    }

    public void delete(String tableName, String whereClause) throws SQLException {
        String query = "DELETE FROM " + tableName + " WHERE " + whereClause;
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println("Data deleted successfully!");
    }

    public ResultSet select(String tableName, String columnNames, String whereClause) throws SQLException {
        String query = "SELECT " + columnNames + " FROM " + tableName + " WHERE " + whereClause;
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
}
