package com.auto.time.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Romachka dzzziuba@gmail.com
 * @version v.0.0.1
 *          Created by Romachka on 07.04.16.
 *          Class for entity Model
 */
@Entity
@Table(name = "Model")
public class Model {
    @Id
    @GeneratedValue
    private long id;
    private String modelName;
    @ManyToOne(optional = false)
    private Brand brand;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private List<Variant> variantList = new ArrayList<Variant>();

    public Model() {
    }

    public Model(String modelName, Brand brand) {
        this.modelName = modelName;
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Variant> getVariantList() {
        return variantList;
    }

    public void setVariantList(List<Variant> variantList) {
        this.variantList = variantList;
    }


    @Override
    public String toString() {
        return "model id: "+this.getId()+" brand id: "+this.getBrand()+" name model: "+this.getModelName();
    }
}

