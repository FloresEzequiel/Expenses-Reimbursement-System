package com.revature.services;

import com.revature.models.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User login(User user);
    List<User>getAll();

}
