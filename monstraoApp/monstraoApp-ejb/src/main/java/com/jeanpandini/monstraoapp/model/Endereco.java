package com.jeanpandini.monstraoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlo
 */
@Entity
@XmlRootElement
@Table(name = "enderecos")
public class Endereco extends AbstractEntity {

    @NotNull
    @Size(min = 3, max = 125)
    @Pattern(regexp = "[^0-9]*", message = "Rua não pode conter números")
    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private Integer numero;

    @NotNull
    @Size(min = 3, max = 50)
    @Pattern(regexp = "[^0-9]*", message = "Bairro não pode conter números")
    @Column(name = "bairro")
    private String bairro;

    @NotNull
    @Size(min = 3, max = 50)
    @Pattern(regexp = "[^0-9]*", message = "Município não pode conter números")
    @Column(name = "municipio")
    private String municipio;

    @NotNull
    @Size(min = 2, max = 2)
    @Pattern(regexp = "[^0-9]*", message = "UF não pode conter números")
    @Column(name = "uf")
    private String uf;

    @NotNull
    @Size(min = 8, max = 8)
    @Digits(fraction = 0, integer = 9)
    @Pattern(regexp = "[^A-Z][^a-z]*", message = "UF não pode conter números")
    @Column(name = "cep")
    private Integer cep;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "monstrao_id", foreignKey = @ForeignKey(name = "fk_enderecos_monstroes"))
    @JsonIgnore
    private Monstrao monstrao;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Monstrao getMonstrao() {
        return monstrao;
    }

}
