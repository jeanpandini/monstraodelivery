package com.jeanpandini.monstraoapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import java.sql.Date;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author carlo
 */
@Entity
@XmlRootElement(name = "monstrao")
@Table(name = "Monstrao", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Monstrao extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 5, max = 100)
    @Pattern(regexp = "[^0-9]*", message = "Nome não pode conter números")
    private String name;

    @NotNull
    @NotEmpty
    @Email
    @Pattern(regexp = "^([\\w\\-]+\\.)*[\\w\\- ]+@([\\w\\- ]+\\.)+([\\w\\-]{2,3})$", message = "Email inválido")
    private String email;

    @NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12)
    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @OneToMany(mappedBy = "monstrao", fetch = FetchType.EAGER)
    private List<Enderecos> enderecos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Enderecos> getEnderecos() {
        return this.enderecos;
    }

    @Override
    public String toString() {
        return "Monstrao{" + "name=" + name + ", email=" + email + ", telefone=" + telefone + ", dataNascimento=" + dataNascimento + '}';
    }

}
