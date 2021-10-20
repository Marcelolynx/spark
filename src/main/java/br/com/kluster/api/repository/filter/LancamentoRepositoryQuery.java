package br.com.kluster.api.repository.filter;

import br.com.kluster.api.model.Lancamento;
import br.com.kluster.api.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LancamentoRepositoryQuery {

   public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
   //public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
}
