/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.rest;

import com.jeanpandini.monstraoapp.service.PedidoService;
import com.jeanpandini.monstraoapp.model.Pedido;
import com.jeanpandini.monstraoapp.util.AbstractCrudService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author carlo
 */
@Path("/pedido")
@RequestScoped
public class PedidosResourceRESTService extends AbstractCrudResourceRESTService<Pedido> {

    @Inject
    private PedidoService pedidoService;

    @Override
    protected AbstractCrudService<Pedido> getService() {
        return pedidoService;
    }

}
