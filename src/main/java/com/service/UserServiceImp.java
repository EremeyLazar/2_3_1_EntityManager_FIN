package com.service;

import com.model.User;
import com.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAll() {
        List<User> resultList = userDao.getAll();
        return resultList;
    }

    public User getOne(int id) {
        User user = userDao.getOne(id);
        return user;
    }


    public void createUser(User user) {
        userDao.createUser(user);
    }


    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }


    public void update(User updatedUser, int id) {
        userDao.update(updatedUser, id);
    }
}
