package com.auto.time.servlets;

import com.auto.time.Model.Brand;
import com.auto.time.dao.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Get")
public class WebService {

    @Autowired
    public BrandDao bdi;

    @GET
    @Path("/{param}")
    public Response getBrands(@PathParam("param") String msg) {

        System.out.println(bdi+"1");
        List<Brand> res = bdi.getAllBrands();
        System.out.println(res);
        String output = "Jersey say : " + msg;

        return Response.status(200).entity(res).build();

    }

}
