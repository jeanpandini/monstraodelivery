/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.model;

import java.io.Serializable;

/**
 *
 * @author carlo
 */
public enum SituacaoPedido implements Serializable {
    SOLICITADO("S", "Solicitado"),
    AGENDADO("A", "Agendado"),
    PREPARANDO("P", "Preparando"),
    REALIZANDO_ENTREGA("R", "Realizando entrega"),
    ENTREGUE("E", "Entregue");

    private final String valor;
    private final String descricao;

    private SituacaoPedido(String valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

}
