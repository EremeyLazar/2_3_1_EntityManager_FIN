package com.userDao;

import com.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAll() {
        List<User> resultList = entityManager.createQuery("select u from User u", User.class).getResultList();
        return resultList;
    }

    public User getOne(int id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root)
                .where(criteriaBuilder.equal(root.get("id"), id));
        User user = entityManager.createQuery(query).getSingleResult();
        return user;
    }

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public void update(User updatedUser, int id) {
        User needsUpdate = getOne(id);
        needsUpdate.setName(updatedUser.getName());
        needsUpdate.setCell(updatedUser.getCell());
        needsUpdate.setCountry(updatedUser.getCountry());
        needsUpdate.setSalary(updatedUser.getSalary());
        needsUpdate.setDl(updatedUser.getDl());
        entityManager.persist(needsUpdate);
    }
}