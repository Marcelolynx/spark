package br.com.kluster.api.service;

import br.com.kluster.api.model.Contato;
import br.com.kluster.api.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;



    public Contato atualizar(Long id, Contato contato) {


        Contato contatoSave = contatoRepository.findOne(id);

        if(contatoSave == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(contato, contatoSave, "id");
        return contatoRepository.save(contatoSave);

    }


    private Contato findById(Long id) {
        Contato contatoSave = contatoRepository.findOne(id);
        if(contatoSave == null) {
            throw new EmptyResultDataAccessException(1);
        }

        return contatoSave;
    }
}
