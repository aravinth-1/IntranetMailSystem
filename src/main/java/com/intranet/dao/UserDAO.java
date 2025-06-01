package com.intranet.dao;
import com.intranet.model.User;
public interface UserDAO {
    User validateUser(String collegeId, String password);
    boolean registerUser(User user);
    public boolean userExists(String recipient);
}