package com.auto.time.dao;

import com.auto.time.Model.Model;

import java.util.List;

/**
 * Created by Romachka on 16.04.16.
 */
public interface ModelDao {
    List<Model> getModelsByBrandId(long brandId);
    List<Model> getAllModels();
    Model getModelByName(String modelName);
    void addNewModel(Model model);
    void deleteModel(String modelName, long brandId);
    void deleteModel(long modelId);
}
