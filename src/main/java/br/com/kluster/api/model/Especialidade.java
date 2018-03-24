package br.com.kluster.api.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Especialidade")
public class Especialidade implements Serializable {

    public Especialidade(String codigoEspecialidade, String nomeEspecialidade) {
        this.codigoEspecialidade = codigoEspecialidade;
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public Especialidade() {
    }

    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "id_especialidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "especialidade_cod")
    private String codigoEspecialidade;

    @Column(name = "especialidade_nome")
    private String nomeEspecialidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoEspecialidade() {
        return codigoEspecialidade;
    }

    public void setCodigoEspecialidade(String codigoEspecialidade) {
        this.codigoEspecialidade = codigoEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Especialidade that = (Especialidade) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
