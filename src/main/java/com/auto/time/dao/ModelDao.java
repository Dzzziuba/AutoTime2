package com.auto.time.dao;

import com.auto.time.Model.Brand;
import com.auto.time.Model.Model;

import java.util.List;

/**
 * Created by Romachka on 16.04.16.
 */
public interface ModelDao {
    List<Model> getModelsByBrandId(Brand brand);
    List<Model> getAllModels();
    Model getModelById(long id);
    void addNewModel(Model model, Brand brand);
    void deleteModel(Model model);
}
