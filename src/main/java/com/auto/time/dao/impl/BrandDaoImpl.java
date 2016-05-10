package com.auto.time.dao.impl;

import com.auto.time.Model.Brand;
import com.auto.time.dao.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Romachka on 16.04.16.
 */

public class BrandDaoImpl implements BrandDao {
    @Autowired
    public EntityManagerFactory emf;


    public List<Brand> getAllBrands() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Brand> brandList = em.createQuery("select i from Brand i order by brandName", Brand.class);
        List<Brand> result = brandList.getResultList();
        return result;
    }

    public List<Brand> getBrandByName(String brandName) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select b from Brand b where brandName=:brandName");
        query.setParameter("brandName", brandName);
        List<Brand> result = query.getResultList();
        return result;
    }

    public void addNewBrand(Brand brand) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(brand);
        em.getTransaction().commit();
    }


    public void deleteBrand(Brand brand) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(brand));
        em.getTransaction().commit();
    }

    public void deleteBrand(long brandId) {

    }

    public Brand getById(long id){
        EntityManager em = emf.createEntityManager();
                Query query = em.createQuery("select b from Brand b where id=:id");
        query.setParameter("id", id);
        Brand brand= (Brand) query.getSingleResult();
        return brand;
    }


}
