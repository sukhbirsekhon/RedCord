package com.enterprise.redcord.service;

import com.enterprise.redcord.dto.User;
import java.util.List;


public interface IUserService {

    User saveUser(User user) throws Exception;

    List<User> fetchAllUsers();
}
