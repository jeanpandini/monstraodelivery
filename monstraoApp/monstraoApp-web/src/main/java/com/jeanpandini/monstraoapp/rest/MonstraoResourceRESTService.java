/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.rest;

import com.jeanpandini.monstraoapp.model.Monstrao;
import com.jeanpandini.monstraoapp.service.MonstraoService;
import com.jeanpandini.monstraoapp.util.AbstractCrudService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author carlo
 */
@Path("/monstrao")
@RequestScoped
public class MonstraoResourceRESTService extends AbstractCrudResourceRESTService<Monstrao> {

    @Inject
    private MonstraoService monstraoService;

    @Override
    protected AbstractCrudService<Monstrao> getService() {
        return monstraoService;
    }

}
