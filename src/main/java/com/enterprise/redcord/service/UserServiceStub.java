package com.enterprise.redcord.service;

import com.enterprise.redcord.dto.User;

import java.util.List;

//implements IMessageService
public class UserServiceStub implements IUserService{
    @Override
    public User saveUser(User user) throws Exception {
        return null;
    }

    @Override
    public List<User> fetchAllUsers() {
        return null;
    }
}
