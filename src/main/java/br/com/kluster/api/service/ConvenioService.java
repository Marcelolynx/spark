package br.com.kluster.api.service;

import br.com.kluster.api.model.Convenio;
import br.com.kluster.api.repository.ConvenioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;



    public Convenio atualizar(Long id, Convenio convenio) {

        Convenio convenioSave = convenioRepository.findOne(id);
        if(convenioSave == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(convenio, convenioSave, "id");
        return convenioRepository.save(convenioSave);
    }

    public void updateStatus(Long id, Boolean convenioStatus) {
        Convenio convenioSalve = findById(id);
        convenioSalve.setConvenioStatus(convenioStatus);
        convenioRepository.save(convenioSalve);
    }

    private Convenio findById(Long id) {
        Convenio convenioSalve = convenioRepository.findOne(id);
        if(convenioSalve == null) {
            throw new EmptyResultDataAccessException(1);
        }

        return convenioSalve;
    }
}
