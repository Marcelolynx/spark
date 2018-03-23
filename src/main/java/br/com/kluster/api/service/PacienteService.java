package br.com.kluster.api.service;

import br.com.kluster.api.Exceptions.PessoaInexistenteOuInativaException;
import br.com.kluster.api.model.Paciente;
import br.com.kluster.api.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MessageSource messageSource;

    public List<Paciente> buscaContatos() {
        return null;
    }

    public void updateStatus(Long id, Boolean ativo) {
        Paciente pacienteSave = pacienteRepository.findOne(id);
        pacienteSave.setAtivo(ativo);
        pacienteRepository.save(pacienteSave);
    }

    public Paciente atualizar(Long id, Paciente paciente) {
        Paciente pacienteSave = pacienteRepository.findOne(id);

        if(pacienteSave == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(paciente, pacienteSave, "id");
        return pacienteRepository.save(pacienteSave);

    }

    public Paciente buscarPorId(Long id) {
        Paciente pacienteSalvo = pacienteRepository.findOne(id);
        if(pacienteSalvo == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return pacienteSalvo;
    }

    public Paciente salvar(Paciente paciente) {

        if(paciente == null || paciente.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return pacienteRepository.save(paciente);

    }

}
