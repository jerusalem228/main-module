package com.sagroup.userservice.service;

import com.sagroup.userservice.entity.User;

import java.util.List;

public interface UserService {

    List<User> viewAll();
    void update(long id, User avatar);
    void save(User avatar);
    void removeById(long id);
}
