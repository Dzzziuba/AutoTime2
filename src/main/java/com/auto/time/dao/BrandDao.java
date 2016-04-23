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
    void deleteBrand(String brandName);
    void deleteBrand(long brandId);


}
