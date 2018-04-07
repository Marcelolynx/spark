package br.com.kluster.api.model;

import java.io.Serializable;

public class ItemAtendimento implements Serializable {

    private static final long serialVersionUID=1L;

    public ItemAtendimento() {
    }

    public ItemAtendimento(Procedimento procedimento, Atendimento atendimento, double desconto, Integer quantidade, Double valor) {
        id.setAtendimento(atendimento);
        id.setProcedimento(procedimento);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    private ItemAtendimentoPK id = new ItemAtendimentoPK();

    private double desconto;
    private Integer quantidade;
    private Double valor;


    public ItemAtendimentoPK getId() {
        return id;
    }

    public void setId(ItemAtendimentoPK id) {
        this.id = id;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Procedimento getProcediemnto() {
        return id.getProcedimento();
    }

    public  Atendimento getAtendimento() {
        return id.getAtendimento();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemAtendimento that = (ItemAtendimento) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
