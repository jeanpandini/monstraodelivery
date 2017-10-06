/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.rest;

import com.jeanpandini.monstraoapp.data.MonstraoException;
import com.jeanpandini.monstraoapp.data.MonstraoRepository;
import com.jeanpandini.monstraoapp.model.Monstroes;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author carlo
 */
@Path("/monstrao")
@RequestScoped
public class MonstraoResourceRESTService {

    @Inject
    private MonstraoRepository monstraoRepository;

    @Inject
    private Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Monstroes> buscaTodos() {
        try {
            return monstraoRepository.getAll();
        } catch (MonstraoException ex) {
           
        }
        return Collections.EMPTY_LIST;
    }

    @GET
    @Path("{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Monstroes buscaPorId(@PathParam("id") Long id) {
        return monstraoRepository.get(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarMonstrao(Monstroes monstrao) {
        return Response.status(Response.Status.CREATED).entity(monstraoRepository.persist(monstrao)).build();
    }

    @POST
    @Path("{id:[0-9][0-9]*}")
    public Response deleteMosntrao(@PathParam("id") Long id) {
        monstraoRepository.remove(id);
        if (monstraoRepository.get(id) == null) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
