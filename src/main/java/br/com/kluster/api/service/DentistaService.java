package br.com.kluster.api.service;

import br.com.kluster.api.model.Dentista;
import br.com.kluster.api.repository.DentistaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository dentistaRepository;



    public List<Dentista> buscaContatos() {
        //TODO
        return null;
    }


    public void updateStatus(Long id, Boolean ativo) {
        Dentista dentistaSave = dentistaRepository.findOne(id);
        dentistaSave.setAtivo(ativo);
        dentistaRepository.save(dentistaSave);
    }


    public Dentista atualizar(Long id, Dentista dentista) {


        Dentista dentistaSave = dentistaRepository.findOne(id);

        if(dentistaSave == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(dentista, dentistaSave, "id");
        return dentistaRepository.save(dentistaSave);

    }
}
