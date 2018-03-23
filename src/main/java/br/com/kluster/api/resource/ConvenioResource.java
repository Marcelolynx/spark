package br.com.kluster.api.resource;

;
import br.com.kluster.api.model.Convenio;
import br.com.kluster.api.repository.ConvenioRepository;
import br.com.kluster.api.service.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/convenio")
public class ConvenioResource {

    @Autowired
    private ConvenioRepository convenioRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private ConvenioService convenioService;


    @GetMapping
    public List<Convenio>listAll() {
        return convenioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Convenio> save(@Valid @RequestBody Convenio convenio, HttpServletResponse response) {

        Convenio convenioSave = convenioRepository.save(convenio);
        return ResponseEntity.status(HttpStatus.CREATED).body(convenioSave);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Convenio> findById(@PathVariable Long id) {
        Convenio convenio = convenioRepository.findOne(id);
        return convenio != null ? ResponseEntity.ok(convenio) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void remove(@PathVariable long id) {
        convenioRepository.delete(id);
    }


    //Update Total do Recurso
    @PutMapping("/{id}")
    public ResponseEntity<Convenio> update(@PathVariable Long id, @Valid @RequestBody Convenio convenio) {


        Convenio convenioSave = convenioService.atualizar(id, convenio);
        return  ResponseEntity.ok(convenioSave);
    }

    @PutMapping("/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Long id, @RequestBody Boolean convenioStatus) {
        convenioService.updateStatus(id, convenioStatus);
    }

}
