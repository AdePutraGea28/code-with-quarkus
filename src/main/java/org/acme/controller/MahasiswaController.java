package org.acme.controller;

import java.util.List;

import org.acme.model.Mahasiswa;
import org.acme.service.MahasiswaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/mahasiswa")
public class MahasiswaController {
    
    private final static Logger log = LoggerFactory.getLogger(MahasiswaController.class);
    
    @Inject
    MahasiswaService mahasiswaService;

    @GET
    public Response findAll() {
        
        List<Mahasiswa> mahasiswaList = mahasiswaService.findAll();
        log.info("findAll method : {}", mahasiswaList);

        return Response.ok().entity(mahasiswaList).build();
    }

    @POST
    public Response save(Mahasiswa request) {

        Mahasiswa newMahasiswa = mahasiswaService.save(request);

        return Response.status(Response.Status.CREATED).entity(newMahasiswa).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") String id) {

        boolean isMahasiswaDeleted = mahasiswaService.deleteById(id);

        String message;
        Integer status;
        if(isMahasiswaDeleted){
            message = "Mahasiswa data with id: " + id + " is success to delete from table Mahasiswa";
            status = 200;
        } else {
            message = "Mahasiswa data with id: " + id + " is failed to delete from table Mahasiswa";
            status = 400;
        }


        return Response.status(status).entity(message).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, Mahasiswa requestBody) {

        Boolean isUpdated = mahasiswaService.updateById(id, requestBody);

        Integer status;
        String messgae;
        if(isUpdated){
            messgae = "Success";
            status = 200;
        } else {
            messgae = "Failed";
            status = 400;
        }

        return Response.status(status).entity(messgae).build();
    }
}
