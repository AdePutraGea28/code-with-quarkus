package org.acme;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello Aplikasi Quarqusnya udah jalan";
    }

    @Path("/mahasiswa")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response showMahasiswa(){

        // Mahasiswa mhs = new Mahasiswa();
        // List<>
        // mhs.setName("Fajri Ilahi");
        // mhs.setIsMale(true);
        // mhs.setEmail("Fajri@gmail.com");
        // mhs.setJob("Software Engineer");

        Map<String, String> obj = new HashMap<>();
        obj.put("Name", "Ade Putra Gea");

        return Response.ok().entity(obj).build();
    }
}
