package com.web.service;

import com.web.model.User;
import com.web.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        List<User> resultList = userDao.getAll();
        return resultList;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void update(User updatedUser, Long id) {
        userDao.update(updatedUser, id);
    }

    @Override
    public User getOne(Long id) {
        return userDao.getOne(id);
    }
}
