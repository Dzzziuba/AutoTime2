package com.auto.time.dao.impl;

import com.auto.time.Model.Model;
import com.auto.time.Model.Variant;
import com.auto.time.dao.VariantDao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

/**
 * Created by Romachka on 16.04.16.
 */
@Transactional
public class VariantDaoImpl implements VariantDao {
    //
    @PersistenceContext
    public EntityManager em;

    public List<Variant> getAllVariants() {
        TypedQuery<Variant> variantList = em.createQuery("select i from Variant i", Variant.class);
        List<Variant> result = variantList.getResultList();
        return result;
    }


    public void deleteVariant(Variant variant) {
        em.remove(em.getReference(Variant.class, variant.getId()));
    }

    public void addNewVariant(Variant variant, Model model) {
        em.merge(model);
    }

    public List<Variant> getVariantsByModelId(Model model) {
        Query query = em.createQuery("select v from Variant v where model =:model");
        query.setParameter("model", model);
        List<Variant> variantList = query.getResultList();
        return variantList;

    }

    public Variant getVariantById(long id) {
        Query query = em.createQuery("select v from Variant v where id =:id");
        query.setParameter("id", id);
        Variant variant = (Variant) query.getSingleResult();
        em.close();
        return variant;
    }

    public Map<String, String> getVariantInfo(long id) {
        Query query = em.createQuery("select i from Variant i where id=:id");
        query.setParameter("id", id);
        Variant variant = (Variant) query.getSingleResult();
        Map<String, String> map = variant.showVariant();
        return map;
    }

    public void editVariant(Variant variant) {
        em.merge(variant);
    }

}

