package com.auto.time.dao.impl;

import com.auto.time.Model.User;
import com.auto.time.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Romachka on 20.04.16.
 */
public class UserDaoImpl implements UserDao {
    @Autowired
    private EntityManagerFactory emf;

    public boolean login(User user) {
        EntityManager em = emf.createEntityManager();

        List<User> userList = em.createQuery("select i from User i where userLogin='" + user.getUserLogin() + "' and userPassword='" + user.getUserPassword()+"'").getResultList();

        return userList.isEmpty() ? false : true;
    }
}
