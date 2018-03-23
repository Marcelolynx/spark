package br.com.kluster.api.service;

import br.com.kluster.api.model.Lancamento;
import br.com.kluster.api.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CalculaParcelamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;



    private double parcelamento(Long id) {

        Lancamento lancamento = lancamentoRepository.getOne(id);
        lancamento.setValor(12000);

        return 0;
    }
}
