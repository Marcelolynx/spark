package br.com.kluster.api.model;

import br.com.kluster.api.enuns.CondicaoPagamento;
import br.com.kluster.api.enuns.FormaPagamento;
import br.com.kluster.api.enuns.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lancamento.class)
public abstract class Lancamento_ {

    public static volatile SingularAttribute<Lancamento, Long> codigo;
    public static volatile SingularAttribute<Lancamento, String> observacao;
    public static volatile SingularAttribute<Lancamento, TipoLancamento> tipo;
    public static volatile SingularAttribute<Lancamento, LocalDate> dataPagamento;
    public static volatile SingularAttribute<Lancamento, Paciente> paciente;
    public static volatile SingularAttribute<Lancamento, Paciente> dentista;
    public static volatile SingularAttribute<Lancamento, NumeroParcela> numeroParcela;
    public static volatile SingularAttribute<Lancamento, CondicaoPagamento> condicaoPagamento;
    public static volatile SingularAttribute<Lancamento, FormaPagamento> formaRecebimento;
    public static volatile SingularAttribute<Lancamento, LocalDate> dataVencimento;
    public static volatile SingularAttribute<Lancamento, BigDecimal> valor;
    public static volatile SingularAttribute<Lancamento, String> descricao;

}
