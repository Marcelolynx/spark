package br.com.kluster.api.model;

import br.com.kluster.api.enuns.EstadoPagamento;
import br.com.kluster.api.enuns.TipoPessoa;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoCheque extends Pagamento {

    private static final long serialVersionUID=1L;

    public PagamentoCheque() {
    }

    public PagamentoCheque(Long id, EstadoPagamento estadoPagamento, Atendimento atendimento, TipoPessoa tipoPessoa, String cnpjCpf, String nomeCheque, String banco, String agencia, String contaCorrente, Integer numeroCheque, double valor, Date dataVencimento, String portador) {
        super(id, estadoPagamento, atendimento);
        this.tipoPessoa = tipoPessoa;
        this.cnpjCpf = cnpjCpf;
        this.nomeCheque = nomeCheque;
        this.banco = banco;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.numeroCheque = numeroCheque;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.portador = portador;
    }

    private TipoPessoa tipoPessoa;
    private String cnpjCpf;
    private String nomeCheque;
    private String banco;
    private String agencia;
    private String contaCorrente;
    private Integer numeroCheque;
    private double valor;
    private Date dataVencimento;
    private String portador;

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getNomeCheque() {
        return nomeCheque;
    }

    public void setNomeCheque(String nomeCheque) {
        this.nomeCheque = nomeCheque;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Integer getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(Integer numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getPortador() {
        return portador;
    }

    public void setPortador(String portador) {
        this.portador = portador;
    }
}
