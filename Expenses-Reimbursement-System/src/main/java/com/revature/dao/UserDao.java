package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.User;

import java.util.List;

public interface UserDao {

    void insertUser(User user);
    User findUser(String username);
    List<User> getAllUser();


}
