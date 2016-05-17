package com.auto.time.dao.impl;

import com.auto.time.Model.User;
import com.auto.time.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Romachka on 20.04.16.
 */
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    public EntityManager em;

    public User login(User user) {
        //EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select i from User i where userLogin=:login and userPassword=:password");
        query.setParameter("login", user.getUserLogin());
        query.setParameter("password", user.getUserPassword());

        User us;
        try {
            us = (User) query.getSingleResult();
        } catch (Exception e) {
            us = null;
        }

        return us;

    }
}
