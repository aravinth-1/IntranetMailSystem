package com.intranet.util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionTester {
    public static void main(String[] args) {
        System.out.println("Testing database connection...");
        
        try (Connection conn = DatabaseUtil.getConnection()) {
            System.out.println("✅ Connection successful!");
            
            // Test query execution
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT 1");
            if (rs.next()) {
                System.out.println("✅ Test query executed successfully");
            }
            
            // Check users table exists
            rs = stmt.executeQuery("SHOW TABLES LIKE 'users'");
            System.out.println(rs.next() ? "✅ Users table exists" : "❌ Users table missing");
            
        } catch (Exception e) {
            System.err.println("❌ Connection failed:");
            e.printStackTrace();
        }
    }
}
