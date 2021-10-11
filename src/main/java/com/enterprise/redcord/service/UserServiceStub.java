package com.enterprise.redcord.service;

import com.enterprise.redcord.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
