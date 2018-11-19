package com.maomao2.databasesharding.service;

import com.maomao2.databasesharding.model.User;

public interface UserService {
    User getUserById(long userId);

    boolean addUser(User record);
}
