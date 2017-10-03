/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.data;

import com.jeanpandini.monstraoapp.model.Monstrao;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author carlo
 */
@Stateless
public class MonstraoRepository extends Repository<Monstrao>{

    public MonstraoRepository() {
        super(Monstrao.class);
    }
    public List<Monstrao> getAll() throws MonstraoException {
        return super.get(" SELECT m FROM Monstrao m ");
    }
    
}
