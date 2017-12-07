/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.util;

import com.jeanpandini.monstraoapp.model.AbstractEntity;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.validation.Valid;

/**
 *
 * @author carlo
 * @param <T>
 */
public abstract class AbstractCrudService<T extends AbstractEntity> {

    public List<T> findAll() {
        return getDao().findAll();
    }

    public T findById(Long id) {
        return getDao().find(id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T insert(@Valid T bean) {
        return getDao().insert(bean);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T update(@Valid T bean) {
        return getDao().update(bean);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Long id) {
        getDao().delete(id);
    }

    protected abstract GenericDao<T> getDao();

}
