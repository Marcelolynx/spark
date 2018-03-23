package br.com.kluster.api.service;

import br.com.kluster.api.Exceptions.PessoaInexistenteOuInativaException;
import br.com.kluster.api.model.Paciente;
import br.com.kluster.api.model.Lancamento;
import br.com.kluster.api.repository.LancamentoRepository;
import br.com.kluster.api.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MessageSource messageSource;



    public Lancamento salvar(Lancamento lancamento) {

        Paciente paciente = pacienteRepository.findOne(lancamento.getPaciente().getId());
        if(paciente == null || paciente.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }

        return lancamentoRepository.save(lancamento);
    }


    public Lancamento atualizar(Long id, Lancamento lancamento) {
        Lancamento lancamentoSave = lancamentoRepository.findOne(id);

        if(lancamentoSave == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(lancamento, lancamentoSave, "id");
        return lancamentoRepository.save(lancamentoSave);

    }


}
