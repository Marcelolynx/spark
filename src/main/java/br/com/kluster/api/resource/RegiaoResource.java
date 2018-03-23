package br.com.kluster.api.resource;

import br.com.kluster.api.Event.ResourceCreatedEvent;
import br.com.kluster.api.model.Regiao;
import br.com.kluster.api.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/regiao")
@RestController
public class RegiaoResource {

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping
    public List<Regiao> findAll() {
        return regiaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Regiao> save(@Valid @RequestBody Regiao regiao, HttpServletResponse response) {
       Regiao regiaoSave = regiaoRepository.save(regiao);

      publisher.publishEvent(new ResourceCreatedEvent(this, response, regiaoSave.getId()));

                return ResponseEntity.status(HttpStatus.CREATED).body(regiaoSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regiao> findById(@PathVariable Long id) {
        Regiao regiao = regiaoRepository.findOne(id);
        return regiao != null ? ResponseEntity.ok(regiao) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void remove(@PathVariable long id) {
        regiaoRepository.delete(id);
    }
}
