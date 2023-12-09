package com.userDao;

import com.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();

    public User getOne(int id);

    public void createUser(User user);

    public void deleteUser(int id);

    public void update(User updatedUser, int id);
}
