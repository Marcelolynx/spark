package br.com.kluster.api.enuns;

public enum CondicaoPagamento {


    AVISTA("A Vista"),
    PARCELADO("Parcelado");


    private String descricao;

    CondicaoPagamento(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }
}
