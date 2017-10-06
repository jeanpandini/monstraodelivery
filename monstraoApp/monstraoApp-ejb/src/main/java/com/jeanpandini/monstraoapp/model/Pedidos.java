package com.jeanpandini.monstraoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlo
 */
@Entity
@XmlRootElement
@Table
public class Pedidos extends AbstractEntity {

    @NotNull
    @Column(name = "dh_solicitacao")
    private Timestamp dhSolicitacao;

    @NotNull
    @Column(name = "dh_entrega")
    private Timestamp dhEntrega;

    @NotNull
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private SituacaoPedido situacao;

    @Column(length = 300)
    private String observacao;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "monstrao_id", foreignKey = @ForeignKey(name = "fk_pedidos_mosntroes"))
    @JsonIgnore
    private Monstroes monstrao;

    public Timestamp getDhSolicitacao() {
        return dhSolicitacao;
    }

    public void setDhSolicitacao(Timestamp dhSolicitacao) {
        this.dhSolicitacao = dhSolicitacao;
    }

    public Timestamp getDhEntrega() {
        return dhEntrega;
    }

    public void setDhEntrega(Timestamp dhEntrega) {
        this.dhEntrega = dhEntrega;
    }

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Monstroes getMonstrao() {
        return monstrao;
    }

    public void setMonstrao(Monstroes monstrao) {
        this.monstrao = monstrao;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "dhSolicitacao=" + dhSolicitacao + ", dhEntrega=" + dhEntrega + ", situacao=" + situacao + ", observacao=" + observacao + ", monstrao=" + monstrao + '}';
    }

}
