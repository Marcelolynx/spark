package br.com.kluster.api.model;

import br.com.kluster.api.enuns.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoBoleto extends Pagamento {

    private static final long serialVersionUID=1L;

    public PagamentoBoleto() {
    }

    public PagamentoBoleto(Long id, EstadoPagamento estadoPagamento, Atendimento atendimento, Date dataVencimento, Date dataPagamento) {
        super(id, estadoPagamento, atendimento);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    private Date dataVencimento;
    private Date dataPagamento;


    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
