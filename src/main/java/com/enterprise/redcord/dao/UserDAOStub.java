package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDAOStub implements IUserDAO{


    @Override
    public User saveUser(User userEntry) throws Exception {
        return null;
    }

    @Override
    public List<User> fetchAllUsers() {
        return null;
    }
}
