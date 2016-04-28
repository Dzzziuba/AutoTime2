package com.auto.time.dao;

import com.auto.time.Model.Brand;

import java.util.List;

/**
 * Created by Romachka on 16.04.16.
 */
public interface BrandDao {
    List<Brand> getAllBrands();
    List<Brand> getBrandByName(String brandName);
    void addNewBrand(Brand brand);
    void deleteBrand(Brand brand);
    void deleteBrand(long brandId);
    Brand getById(long id);


}
