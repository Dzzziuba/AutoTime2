package com.auto.time.dao.impl;

import com.auto.time.Model.Brand;
import com.auto.time.dao.BrandDao;
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
public class BrandDaoImpl implements BrandDao {
    @PersistenceContext
    public EntityManager em;


    public List<Brand> getAllBrands() {
        TypedQuery<Brand> brandList = em.createQuery("select i from Brand i order by brandName", Brand.class);
        List<Brand> result = brandList.getResultList();
        return result;
    }

    public List<Brand> getBrandByName(String brandName) {
        Query query = em.createQuery("select b from Brand b where brandName=:brandName");
        query.setParameter("brandName", brandName);
        List<Brand> result = query.getResultList();
        return result;
    }

    public void addNewBrand(Brand brand) {
        em.merge(brand);
    }


    public void deleteBrand(Brand brand) {
        brand.getModelList().size();
        em.remove(em.getReference(Brand.class, brand.getId()));
    }

    public void deleteBrand(long brandId) {

    }

    public Brand getById(long id) {
        Query query = em.createQuery("select b from Brand b where id=:id");
        query.setParameter("id", id);
        Brand brand = (Brand) query.getSingleResult();
        brand.getModelList().size();
        return brand;
    }

    public Brand getBrandAndModel(long id) {
        Query query = em.createQuery("select b from Brand b where id=:id");
        query.setParameter("id", id);
        Brand brand = (Brand) query.getSingleResult();
        brand.getModelList().size();
        return brand;
    }


}
