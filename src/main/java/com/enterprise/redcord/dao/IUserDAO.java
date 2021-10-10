package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.User;

import java.util.List;

public interface IUserDAO {

    User saveUser(User user) throws Exception;

    List<User> fetchAllUsers();
}
