package com.service;

import com.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public interface UserService {
    public List<User> getAll();

    public User getOne(int id);
    @Transactional
    public void createUser(User user);
    @Transactional
    public void deleteUser(int id);
    @Transactional
    public void update(User updatedUser, int id);
}
