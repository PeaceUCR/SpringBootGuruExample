package com.example.securedemo.services;

import com.example.securedemo.domain.User;

public interface UserService extends CRUDService<User> {
    User findByUsername(String username);

}
