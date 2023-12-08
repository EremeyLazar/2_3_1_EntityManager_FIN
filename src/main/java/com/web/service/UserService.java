package com.web.service;


import com.web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void createUser(User user);

    void deleteUser(long id);

    void update(User updatedUser, Long id);

    User getOne (Long id);
}
