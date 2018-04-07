package br.com.kluster.api.model;

import br.com.kluster.api.enuns.StatusAtendimento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {

    private static final long serialVersionUID=1L;

    public Atendimento() {
    }

    public Atendimento(Date instante, Pagamento pagamento, Paciente paciente, StatusAtendimento statusAtendimento) {
        this.instante = instante;
        this.pagamento = pagamento;
        this.paciente = paciente;
        this.statusAtendimento = statusAtendimento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Set<ItemAtendimento> itens =  new HashSet<>();

    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "atendimento")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    private StatusAtendimento statusAtendimento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public StatusAtendimento getStatusAtendimento() {
        return statusAtendimento;
    }

    public void setStatusAtendimento(StatusAtendimento statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

    public Set<ItemAtendimento> getItens() {
        return itens;
    }

    public void setItens(Set<ItemAtendimento> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atendimento that = (Atendimento) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
