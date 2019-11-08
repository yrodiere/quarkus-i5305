package io.quarkus.bugs;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.bugs.model.MyEntity;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class TestResource {

    @PUT
    @Path( "/" )
    public Long create(String text) {
        MyEntity entity = new MyEntity();
        entity.text = text;
        entity.persist();
        return entity.id;
    }

    @GET
    @Path( "/{id}" )
    public String retrieve(@PathParam( "id" ) Long id) {
        MyEntity entity = MyEntity.findById( id );
        return entity.text;
    }

    @POST
    @Path( "/{id}" )
    public void update(@PathParam( "id" ) Long id, String text) {
        MyEntity entity = MyEntity.findById( id );
        entity.text = text;
    }

    @DELETE
    @Path( "/{id}" )
    public void delete(@PathParam( "id" ) Long id) {
        MyEntity entity = MyEntity.findById( id );
        entity.delete();
    }
}