package com.auto.time.Model;


import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Romachka dzzziuba@gmail.com
 * @version v.0.0.1
 * Created by Romachka on 07.04.16.
 * Class for entity Variant
 */
@Entity
@Table(name = "Variant")
public class Variant {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "variantName")
    private String variantName;

    @ManyToOne(optional = false)
    private Brand brand;

    @ManyToOne(optional = false)
    private Model model;

    @Column(name = "engine")
    private String engine;
    @Column(name = "expertRating")
    private String expertRating;
    @Column(name = "fuelEconomy")
    private String fuelEconomy;
    @Column(name = "horsePower")
    private String horsePower;
    @Column(name = "driveTrain")
    private String driveTrain;
    @Column(name = "fuelType")
    private String fuelType;

    public Variant() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getDriveTrain() {
        return driveTrain;
    }

    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public String getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(String fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public String getExpertRating() {
        return expertRating;
    }

    public void setExpertRating(String expertRating) {
        this.expertRating = expertRating;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }


    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Variant{" +
                "id=" + id +
                ", variantName='" + variantName + '\'' +
                ", brand_id=" + brand.getBrandName()+
                ", modelVar=" + model.getModelName() +
                ", engine='" + engine + '\'' +
                ", expertRating='" + expertRating + '\'' +
                ", fuelEconomy='" + fuelEconomy + '\'' +
                ", horsePower='" + horsePower + '\'' +
                ", driveTrain='" + driveTrain + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }

    public Map<String, String> showVariant(){
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("Variant name: ", this.variantName);
        map.put("Engine: ", this.engine);
        map.put("Expert rating: ", this.expertRating);
        map.put("Fuel economy: ", this.fuelEconomy);
        map.put("Horse power: ", this.horsePower);
        map.put("Drive train: ", this.driveTrain);
        map.put("Fuel type: ", this.fuelType);

        return map;
    }
}
