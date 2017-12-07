/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.rest;

import com.jeanpandini.monstraoapp.model.Estabelecimento;
import com.jeanpandini.monstraoapp.service.EstabelecimentoService;
import com.jeanpandini.monstraoapp.util.AbstractCrudService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author carlo
 */
@Path("/estabelecimento")
@RequestScoped
public class EstabelecimentoResourceRESTService extends AbstractCrudResourceRESTService<Estabelecimento> {

    @Inject
    private EstabelecimentoService estabelecimentoService;

    @Override
    protected AbstractCrudService<Estabelecimento> getService() {
        return estabelecimentoService;
    }

}
