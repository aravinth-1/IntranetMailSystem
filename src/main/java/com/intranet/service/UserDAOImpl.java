package com.intranet.service;
import com.intranet.dao.UserDAO;
import com.intranet.model.User;
import com.intranet.util.DatabaseUtil;
import java.sql.*;

public class UserDAOImpl implements UserDAO {
    @Override
    public User validateUser(String collegeId, String password) {
        String sql = "SELECT college_id, name, email FROM users WHERE college_id=? AND password=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, collegeId);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setCollegeId(rs.getString("college_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email")); // This will work now
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean registerUser(User user) {
    String sql = "INSERT INTO users (college_id, name, password, email) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, user.getCollegeId());
        stmt.setString(2, user.getName());
        stmt.setString(3, user.getPassword());
        stmt.setString(4, user.getEmail()); // Store hashed passwords in production
        
        
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    
    }
    
    public boolean userExists(String collegeId) {
        // Choose one of the methods above
        String sql = "SELECT 1 FROM users WHERE college_id = ? LIMIT 1";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, collegeId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
