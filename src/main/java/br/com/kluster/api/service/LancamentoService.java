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
        if (paciente == null || paciente.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }

        return lancamentoRepository.save(lancamento);
    }


    public Lancamento atualizar(Long id, Lancamento lancamento) {
        Lancamento lancamentoSave = buscarLancamentoExistente(id);

        if(!lancamento.getPaciente().equals(lancamentoSave.getPaciente())) {
            validarPaciente(lancamento);
        }
        BeanUtils.copyProperties(lancamento, lancamentoSave, "id");
        return lancamentoRepository.save(lancamentoSave);

    }

    private void validarPaciente(Lancamento lancamento) {
        Paciente paciente = null;
                if(lancamento.getPaciente().getId() !=null) {
            paciente = pacienteRepository.findOne(lancamento.getPaciente().getId());
        }
    }

    private Lancamento buscarLancamentoExistente(Long id) {
        Lancamento lancamentoSalvo = lancamentoRepository.findOne(id);
        if(lancamentoSalvo == null) {
            throw new IllegalArgumentException();
        }
        return lancamentoSalvo;
    }


}
