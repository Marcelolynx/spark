package br.com.kluster.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Parcela")
public class NumeroParcela implements Serializable {

    private static final long serialVersionUID=1L;

    public NumeroParcela() {
    }

    public NumeroParcela(Integer numeroParcela, String descricaoParcela) {
        this.numeroParcela = numeroParcela;
        this.descricaoParcela = descricaoParcela;
    }

    @Id
    @Column(name = "id_parcela")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parcela_numero")
    private Integer numeroParcela;

    @Column(name = "parcela_descricao")
    private String descricaoParcela;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public String getDescricaoParcela() {
        return descricaoParcela;
    }

    public void setDescricaoParcela(String descricaoParcela) {
        this.descricaoParcela = descricaoParcela;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumeroParcela that = (NumeroParcela) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
