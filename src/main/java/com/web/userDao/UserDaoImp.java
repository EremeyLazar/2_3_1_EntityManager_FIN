package com.web.userDao;

import com.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        List<User> resultList = entityManager.createQuery("select u from User u", User.class).getResultList();
        return resultList;
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void update(User updatedUser, Long id) {
        User needsUpdate = entityManager.find(User.class, id);
        needsUpdate.setName(updatedUser.getName());
        needsUpdate.setCell(updatedUser.getCell());
        needsUpdate.setCountry(updatedUser.getCountry());
        needsUpdate.setSalary(updatedUser.getSalary());
        needsUpdate.setDl(updatedUser.getDl());
        entityManager.persist(needsUpdate);
    }

    @Override
    public User getOne(Long id) {
        return entityManager.find(User.class, id);
    }
}