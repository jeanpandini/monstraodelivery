/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.data;

/**
 *
 * @author carlo
 */
public class MonstraoException extends Exception {

    public MonstraoException(String msg) {
        super(msg);
    }

    public MonstraoException(String msg, Throwable ex) {
        super(msg, ex);
    }

}
