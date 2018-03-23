package br.com.kluster.api.repository;


import br.com.kluster.api.model.Lancamento;
import br.com.kluster.api.repository.filter.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
