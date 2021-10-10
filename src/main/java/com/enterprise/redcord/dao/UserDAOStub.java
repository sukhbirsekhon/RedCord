package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.User;

import java.util.List;

public class UserDAOStub implements IUserDAO{
    @Override
    public User saveUser(User user) throws Exception {
        return null;
    }

    @Override
    public List<User> fetchAllUsers() {
        return null;
    }
}
