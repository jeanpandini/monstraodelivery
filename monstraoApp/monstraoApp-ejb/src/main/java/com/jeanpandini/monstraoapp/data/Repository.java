/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.data;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.validator.internal.util.logging.Log;

/**
 *
 * @author carlo
 * @param <T>
 */
public abstract class Repository<T> implements RepositoryOperations<T> {

    @Inject
    private EntityManager em;

    private Class<T> type;

    protected Repository() {
    }

    protected Repository(Class<T> type) {
        this.type = type;
    }

    @Override
    public List<T> get(String query) throws MonstraoException {
        try {
            return em.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new MonstraoException("Birlll");
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public T get(Long id) {
        return (T) em.find(type, id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T persist(T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Long id) {
        T entitiselct = em.getReference(type, id);
        if (entitiselct == null) {
            return;
        }
        em.remove(entitiselct);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T upDate(T entity) {
        em.merge(entity);
        return entity;
    }

}
