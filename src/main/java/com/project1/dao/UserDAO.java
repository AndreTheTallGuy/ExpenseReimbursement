package com.project1.dao;


import com.project1.models.User;

import java.util.List;

public interface UserDAO {
    
    User getUserByUserName(String username);
    User getUserByID(int id);
    boolean addUser(User user);
    List<User> getAllEmployees();
    boolean deleteUser(String username);
    
}
