/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.data;

import java.util.List;

/**
 *
 * @author carlo
 * @param <T>
 */
public interface RepositoryOperations<T> {

    T get(Long id);

    List<T> get(String query) throws MonstraoException;

    T persist(T entity);

    T upDate(T entity);

    void remove(Long id);
}
