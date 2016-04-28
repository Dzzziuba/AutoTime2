package com.auto.time.Model;

import javax.persistence.*;
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
    @Column(name = "id")
    private long id;

    @Column(name = "modelName")
    private String modelName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Variant> variantList;

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

