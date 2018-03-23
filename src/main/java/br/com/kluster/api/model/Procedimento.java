package br.com.kluster.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Procedimento")
public class Procedimento implements Serializable {

    private static final long serialVersionUID=1L;

    public Procedimento() {
    }

    public Procedimento(String codigoProcedimento, String procedimentoDescricao) {
        this.codigoProcedimento = codigoProcedimento;
        this.procedimentoDescricao = procedimentoDescricao;
    }

    @Id
    @Column(name = "id_procedimento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "procedimento_codigo")
    private String codigoProcedimento;

    @Column(name = "procedimento_descricao")
    private String procedimentoDescricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoProcedimento() {
        return codigoProcedimento;
    }

    public void setCodigoProcedimento(String codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
    }

    public String getProcedimentoDescricao() {
        return procedimentoDescricao;
    }

    public void setProcedimentoDescricao(String procedimentoDescricao) {
        this.procedimentoDescricao = procedimentoDescricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Procedimento that = (Procedimento) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
