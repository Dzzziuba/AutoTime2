package com.auto.time.dao.impl;

import com.auto.time.Model.User;
import com.auto.time.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * Created by Romachka on 20.04.16.
 */
public class UserDaoImpl implements UserDao {
    @Autowired
    private EntityManagerFactory emf;

    public User login(User user) {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select i from User i where userLogin=:login and userPassword=:password");
        query.setParameter("login", user.getUserLogin());
        query.setParameter("password", user.getUserPassword());
        //List<User> userList=query.getResultList();
        User us;
        try {
            us = (User) query.getSingleResult();
        } catch (Exception e) {
            us = null;
        }

        return us;
        //return userList.isEmpty() ? false : true;
    }
}
