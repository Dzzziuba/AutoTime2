package com.auto.time.Model;


import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
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
    private long id;
    @Size(min=3, max=30)
    private String variantName;

    @ManyToOne(optional = false)
    private Brand brand;

    @ManyToOne(optional = false)
    private Model model;

    @Size(min=3, max=30)
    private String engine;
    @Size(min=1, max=8)
    private String expertRating;
    @Size(min=3, max=30)
    private String fuelEconomy;
    @Size(min=3, max=10)
    private String horsePower;
    @Size(min=3, max=30)
    private String driveTrain;
    @Size(min=3, max=30)
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
