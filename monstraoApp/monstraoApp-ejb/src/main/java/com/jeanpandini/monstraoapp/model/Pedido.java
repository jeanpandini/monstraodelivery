package com.jeanpandini.monstraoapp.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "pedidos")
public class Pedido extends AbstractEntity {

    @NotNull
    @Column(name = "dh_solicitacao")
    private Timestamp dhSolicitacao;

    @NotNull
    @Column(name = "dh_entrega")
    private Timestamp dhEntrega;

    @NotNull
    @Column(name = "situacao", length = 1)
    //@Enumerated(EnumType.STRING)
    private String situacao;

    @Column(length = 500)
    private String observacao;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "monstrao_id", foreignKey = @ForeignKey(name = "fk_pedidos_mosntroes"))
    private Monstrao monstrao;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "endereco_id", foreignKey = @ForeignKey(name = "fk_pedidos_enderecos"))
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "estabelecimento_id", foreignKey = @ForeignKey(name = "fk_pedidos_estabelecimento"))
    private Estabelecimento estabelecimento;

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
        return SituacaoPedido.getEnum(situacao);
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao.getValor();
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Monstrao getMonstrao() {
        return monstrao;
    }

    public void setMonstrao(Monstrao monstrao) {
        this.monstrao = monstrao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "dhSolicitacao=" + dhSolicitacao + ", dhEntrega=" + dhEntrega + ", situacao=" + situacao + ", observacao=" + observacao + ", monstrao=" + monstrao.getName() + " endereco=" + endereco.toString() + " estabelecimento" + estabelecimento.getNome() + '}';
    }

}
