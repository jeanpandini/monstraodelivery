/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.data;

import com.jeanpandini.monstraoapp.model.Monstroes;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author carlo
 */
@Stateless
public class MonstraoRepository extends Repository<Monstroes> {

    public MonstraoRepository() {
        super(Monstroes.class);
    }

    public List<Monstroes> getAll() throws MonstraoException {
        return super.get(" SELECT m FROM Monstrao m ");
    }

}
