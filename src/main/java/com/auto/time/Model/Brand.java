package com.auto.time.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Romachka dzzziuba@gmail.com
 * @version v.0.0.1
 *          Created by Romachka on 07.04.16.
 *          Class for entity Brand
 */
@Entity
@Table(name = "Brand")
public class Brand {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "brandName")
    private String brandName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Model> modelList = new ArrayList<Model>();


    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }


    @Override
    public String toString() {
        return "id= " + id + " Brand name= " + brandName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    //@Override
    public boolean equals(Brand brand) {

        if (brand == null || brand.getClass() != this.getClass()) return false;


        if (this.getId() != 0 && brand.getId() != 0 && this.getId() == brand.getId() && this.getBrandName() != null && brand.getBrandName() != null && this.getBrandName().equals(brand.getBrandName()))
            return true;

        else return false;
    }

    public boolean isUnique(Brand brand) {

        if (this.getBrandName().equals(brand.getBrandName())) return true;

        else return false;
    }
}
