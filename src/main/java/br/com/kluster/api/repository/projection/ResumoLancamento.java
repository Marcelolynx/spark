package br.com.kluster.api.repository.projection;

import br.com.kluster.api.enuns.CondicaoPagamento;


import br.com.kluster.api.model.NumeroParcela;


import java.time.LocalDate;

public class ResumoLancamento {

    public ResumoLancamento(Long id, String descricao, LocalDate dataVencimento,
                            CondicaoPagamento condicaoPagamento, NumeroParcela numeroParcela, String formaRecebimento, double valor, String paciente, String dentista) {
        this.id = id;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.condicaoPagamento = condicaoPagamento;
        this.numeroParcela = numeroParcela;
        this.formaRecebimento = formaRecebimento;
        this.valor = valor;
        this.paciente = paciente;
        this.dentista = dentista;

    }

    private Long id;
    private String descricao;
    private LocalDate dataVencimento;
    private CondicaoPagamento condicaoPagamento;
    private NumeroParcela numeroParcela;
    private String formaRecebimento;
    private double valor;
    private String paciente;
    private String dentista;



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

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
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

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getDentista() {
        return dentista;
    }

    public void setDentista(String dentista) {
        this.dentista = dentista;
    }


}
