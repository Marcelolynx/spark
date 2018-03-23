package br.com.kluster.api.model;

import br.com.kluster.api.enuns.CondicaoPagamento;
import br.com.kluster.api.enuns.StatusRecebimento;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Lancamento")
public class Lancamento implements Serializable {


    private static final long serialVersionUID=1L;

    public Lancamento() {
    }

    public Lancamento(String descricao, LocalDate dataLancamento, LocalDate dataVencimento, CondicaoPagamento condicaoPagamento, String formaRecebimento,
                      double valor, Paciente paciente, Dentista dentista, StatusRecebimento statusRecebimento) {
        this.descricao = descricao;
        this.dataLancamento = dataLancamento;
        this.dataVencimento = dataVencimento;
        this.condicaoPagamento = condicaoPagamento;
        this.formaRecebimento = formaRecebimento;
        this.valor = valor;
        this.paciente = paciente;
        this.dentista = dentista;
        this.statusRecebimento = statusRecebimento;
    }

    @Id
    @Column(name = "id_recebimento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5 )
    @Column(name = "recebimento_descricao")
    private String descricao;


    @NotNull
    @Column(name = "recebimento_dt_lancamento")
    private LocalDate dataLancamento;


    @NotNull
    @Column(name = "recebimento_dt_vencimento")
    private LocalDate dataVencimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CondicaoPagamento condicaoPagamento;


    @OneToOne
    @JoinColumn(name = "id_parcela")
    private NumeroParcela numeroParcela;


    @Column(name = "recebimento_forma")
    private String formaRecebimento;

    @NotNull
    @Column(name = "recebimento_valor")
    private double valor;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_dentista")
    private Dentista dentista;

    @Enumerated(EnumType.STRING)
    private StatusRecebimento statusRecebimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public StatusRecebimento getStatusRecebimento() {
        return statusRecebimento;
    }

    public void setStatusRecebimento(StatusRecebimento statusRecebimento) {
        this.statusRecebimento = statusRecebimento;
    }

    public String getFormaRecebimento() {
        return formaRecebimento;
    }

    public void setFormaRecebimento(String formaRecebimento) {
        this.formaRecebimento = formaRecebimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public NumeroParcela getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(NumeroParcela numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lancamento that = (Lancamento) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
