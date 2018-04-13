package br.com.kluster.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "id.procedimento")
    private Set<ItemAtendimento> itens =  new HashSet<>();

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


    public Set<ItemAtendimento> getItens() {
        return itens;
    }

    public void setItens(Set<ItemAtendimento> itens) {
        this.itens = itens;
    }


    public List<Atendimento> getAtendimento() {
        List<Atendimento> lista = new ArrayList<>();
        for (ItemAtendimento x : itens) {
            lista.add(x.getAtendimento());
        }

        return lista;
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
