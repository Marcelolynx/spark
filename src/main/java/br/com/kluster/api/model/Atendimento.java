package br.com.kluster.api.model;

import br.com.kluster.api.enuns.StatusAtendimento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Atendimento")
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

    private Date instante;

    private Pagamento pagamento;

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
