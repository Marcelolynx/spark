package br.com.kluster.api.model;

import br.com.kluster.api.enuns.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento {

    private static final long serialVersionUID=1L;

    public PagamentoCartao() {
    }

    public PagamentoCartao(Long id, EstadoPagamento estadoPagamento, Atendimento atendimento, Long numeroDeParcelas) {
        super(id, estadoPagamento, atendimento);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    private Long numeroDeParcelas;

    public Long getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Long numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
