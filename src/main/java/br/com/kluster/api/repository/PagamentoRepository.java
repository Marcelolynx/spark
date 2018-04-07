package br.com.kluster.api.repository;


import br.com.kluster.api.model.Agenda;
import br.com.kluster.api.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
