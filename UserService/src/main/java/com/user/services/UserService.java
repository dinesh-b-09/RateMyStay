package com.user.services;

import com.user.enitity.User;

import java.util.List;

public interface UserService
{
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
