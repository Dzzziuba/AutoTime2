package com.auto.time.servlets;

import com.auto.time.Model.Brand;
import com.auto.time.dao.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Romachka on 24.05.16.
 */
@RestController
@RequestMapping("/rest")
public class WebService {
    @Autowired
    BrandDao brandDao;

    @RequestMapping(value = "/getbrands/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Brand getBrandsInJSON(@PathVariable long id){
        Brand result = brandDao.getBrandAndModel(id);
//        Brand res = new Brand();
//        res.setId(result.getId());
//        res.setBrandName(result.getBrandName());

        return result ;
    }
}
