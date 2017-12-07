/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.service;

import com.jeanpandini.monstraoapp.model.Estabelecimento;
import com.jeanpandini.monstraoapp.util.AbstractCrudService;
import com.jeanpandini.monstraoapp.util.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 *
 * @author carlo
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EstabelecimentoService extends AbstractCrudService<Estabelecimento> {

    @Inject
    private GenericDao<Estabelecimento> estabelecimentoDao;

    @Override
    protected GenericDao<Estabelecimento> getDao() {
        return estabelecimentoDao;
    }

}
