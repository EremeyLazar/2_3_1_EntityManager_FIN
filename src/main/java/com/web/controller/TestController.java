package com.web.controller;



import com.model.User;
import com.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private EntityManager entityManager;

//    @Autowired
    private UserDao userDao = new UserDao();


    @GetMapping(value = "/")
    public String getTest (Model model) {

//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
//        Root<User> root = query.from(User.class);
//        query.select(root)
//                .where(criteriaBuilder.equal(root.get("name"), "Asha"));
//        List<User> resultList = entityManager.createQuery(query).getResultList();

        List <User> resultList = entityManager.createQuery("select u from User u", User.class).getResultList();
        model.addAttribute("userlist", resultList );

        return "users";
    }

    @GetMapping (value = "/showuser")
    public String getOne (Model model) {
        Long id = 1L;
//        TypedQuery <User> typedQuery = (TypedQuery<User>) entityManager.createQuery("select u from User u where u.id = :id");
//        typedQuery.setParameter("id", id);
//        User user = typedQuery.getSingleResult();
//        model.addAttribute("user", user);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root)
                .where(criteriaBuilder.equal(root.get("id"), id));
        User user = entityManager.createQuery(query).getSingleResult();

        model.addAttribute("user", user);

        return "showuser";
    }


    @GetMapping(value = "/usercreation")
    public String newUser (Model model) {
        model.addAttribute("newuser", new User());
        return "usercreation";
    }


    @PostMapping(value = "/usercreation")
    public String createUser (@ModelAttribute("newuser") @Valid User user, BindingResult br) {
        if (br.hasErrors()) {return "/usercreation";}
        entityManager.persist(user);
        return "redirect:/";
    }

    @GetMapping(value = "/deleteuser")
    public String deleteUser (@RequestParam("id") long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

        return "redirect:deleted";
    }

    @GetMapping(value = "/deleted")
    public String deleted (ModelMap model) {

        List<String> messages = new ArrayList<>();
        messages.add("User " + " has been removed!!!");
        model.addAttribute("messages", messages);

        return "deleted";
    }





}
