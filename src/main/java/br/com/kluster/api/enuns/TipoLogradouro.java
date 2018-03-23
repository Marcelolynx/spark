package br.com.kluster.api.enuns;

public enum TipoLogradouro {

    ALAMEDA("Alameda"),
    AVENIDA("Avenida"),
    CONDOMINIO("Condomínio"),
    CONJUNTO("Conjunto"),
    DISTRITO("Distrito"),
    ESPLANADA("Esplanada"),
    ESTACAO("Estação"),
    ESTRADA("Estrada"),
    LOTEAMENTO("Loteamento"),
    NUCLEO("Núcleo"),
    PARQUE("Parque"),
    PASSARELA("Passarela"),
    PATIO("Pátio"),
    PRACA("Praça"),
    QUADRA("Quadra"),
    RECANTO("Recanto"),
    RODOVIA("Rodovia"),
    RUA("Rua"),
    SETOR("Setor"),
    SITIO("Sítio"),
    TRAVESSA("Travessa"),
    VIA("Via");


    private String  descricao;


    TipoLogradouro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
