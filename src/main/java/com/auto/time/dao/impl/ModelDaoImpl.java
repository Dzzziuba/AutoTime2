package com.auto.time.dao.impl;

import com.auto.time.Model.Model;
import com.auto.time.dao.ModelDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Romachka on 16.04.16.
 */
public class ModelDaoImpl implements ModelDao {

    @Autowired
    public EntityManagerFactory emf;

    public List<Model> getModelsByBrandId(long brandId) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Model> modelList = em.createQuery("select i from Model i where brand=" + brandId, Model.class);
        List<Model> result = modelList.getResultList();
        return result;
    }

    public List<Model> getAllModels() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Model> modelList = em.createQuery("select i from Model i", Model.class);
        List<Model> result = modelList.getResultList();
        return result;
    }

    public Model getModelByName(String modelName) {
        return null;
    }

    public void deleteModel(long modelId) {

    }

    public void deleteModel(String modelName, long brandId) {
Boolean a;
    }

    public void addNewModel(Model model) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(model);
        em.getTransaction().commit();

    }
}
