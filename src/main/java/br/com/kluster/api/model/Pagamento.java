package br.com.kluster.api.model;

import br.com.kluster.api.enuns.EstadoPagamento;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable {

    private static final long serialVersionUID=1L;

    public Pagamento() {
    }

    public Pagamento(Long id, EstadoPagamento estadoPagamento, Atendimento atendimento) {
        this.id = id;
        this.estadoPagamento = estadoPagamento;
        this.atendimento = atendimento;
    }

    @Id
    private Long id;

    private EstadoPagamento estadoPagamento;

    @OneToOne
    @JoinColumn(name = "atendimento_id")
    @MapsId
    private Atendimento atendimento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoPagamento getEstadoPagamento() {
        return estadoPagamento;
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pagamento pagamento = (Pagamento) o;

        return id != null ? id.equals(pagamento.id) : pagamento.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
