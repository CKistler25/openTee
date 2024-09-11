package com.opentee.dao;

import com.opentee.model.RegisterUserDto;
import com.opentee.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
