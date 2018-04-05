package br.com.kluster.api.enuns;

public enum TipoFornecedor {

    PESSOA_FISICA("Pessoa Física"),
    PESSOA_JURIDICA("Pessoa Jurídica");


    private String descricao;

    TipoFornecedor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
