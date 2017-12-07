/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraoapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 *
 * @author carlo
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
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

    public static SituacaoPedido getEnum(String value) {
        for (SituacaoPedido v : values()) {
            if (v.getValor().equalsIgnoreCase(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Situação do pedido inválida.");
    }

}
