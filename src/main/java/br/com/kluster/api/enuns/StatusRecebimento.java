package br.com.kluster.api.enuns;

public enum  StatusRecebimento {

    EM_ABERTO("Aberto"),RECEBIDO_PARCIAL("Recebido Parcial"),ATRASADO("Atrasado"),RECEBIDO_TOTAL("Recebido Total");


    private String descricao;


    StatusRecebimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
