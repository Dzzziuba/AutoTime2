package com.auto.time.dao;

import com.auto.time.Model.Model;
import com.auto.time.Model.Variant;

import java.util.List;
import java.util.Map;

/**
 * Created by Romachka on 16.04.16.
 */
public interface VariantDao {
    List<Variant> getAllVariants();
    List<Variant> getVariantsByModelId(Model model);
    Variant getVariantById(long id);
    void addNewVariant(Variant variant, Model model);
    void deleteVariant(Variant variant);
    public void editVariant(Variant variant);
    //LinkedHashMap<String, String> getVariantInfo(Variant variant);
    Map<String, String> getVariantInfo(long id);
}
