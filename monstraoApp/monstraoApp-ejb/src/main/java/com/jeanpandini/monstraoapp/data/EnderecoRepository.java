/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.data;

import com.jeanpandini.monstraoapp.model.Enderecos;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author carlo
 */
@Stateless
public class EnderecoRepository extends Repository<Enderecos> {

    public EnderecoRepository() {
        super(Enderecos.class);
    }

    public List<Enderecos> getAll() throws MonstraoException {
        return super.get(" SELECT m FROM Enderecos m ");
    }

}
