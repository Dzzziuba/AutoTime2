package com.auto.time.dao.impl;

import com.auto.time.Model.Brand;
import com.auto.time.Model.Model;
import com.auto.time.dao.ModelDao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Romachka on 16.04.16.
 */
@Transactional
public class ModelDaoImpl implements ModelDao {

    @PersistenceContext
    private EntityManager em;

    public List<Model> getModelsByBrandId(Brand brand) {
        //EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select v from Model v where brand =:brand");
        query.setParameter("brand", brand);
        List<Model> result = query.getResultList();
        return result;
    }

    public List<Model> getAllModels() {
        //EntityManager em = emf.createEntityManager();
        TypedQuery<Model> modelList = em.createQuery("select i from Model i", Model.class);
        List<Model> result = modelList.getResultList();
        return result;
    }

    public Model getModelByName(String modelName) {
        return null;
    }


    public void deleteModel(Model model) {

        //EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(model));
        em.getTransaction().commit();
    }

    public void addNewModel(Model model) {
        //EntityManager em = emf.createEntityManager();

        em.merge(model);


    }
}
