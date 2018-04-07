package br.com.kluster.api.enuns;

public enum EstadoPagamento {

    ABERTO("Aberto"),PAGO("Quitado"),VENCIDO("Vencido");


    private String descricao;

    EstadoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
