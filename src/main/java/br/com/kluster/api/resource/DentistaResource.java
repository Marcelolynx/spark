package br.com.kluster.api.resource;

import br.com.kluster.api.Event.ResourceCreatedEvent;
import br.com.kluster.api.model.Dentista;
import br.com.kluster.api.repository.ContatoRepository;
import br.com.kluster.api.repository.DentistaRepository;
import br.com.kluster.api.repository.filter.DentistaFilter;
import br.com.kluster.api.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/dentista")
public class DentistaResource {



    @Autowired
    private DentistaRepository dentistaRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private DentistaService dentistaService;


    @GetMapping
    public Page<Dentista> pesquisar(DentistaFilter dentistaFilter, Pageable pageable) {

        return dentistaRepository.filtrar(dentistaFilter, pageable);
    }

    @PostMapping
    public ResponseEntity<Dentista> save(@Valid @RequestBody Dentista dentista, HttpServletResponse response) {
        Dentista dentistaSave = dentistaRepository.save(dentista);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, dentistaSave.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(dentistaSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> findById(@PathVariable Long id) {
        Dentista dentista = dentistaRepository.findOne(id);
        return dentista != null ? ResponseEntity.ok(dentista) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
   // @PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO')")
    public  void remove(@PathVariable long id) {
        dentistaRepository.delete(id);
    }

    @GetMapping("/{id}/contato")
    public List<Dentista> findContato(@PathVariable Long id) {
        List<Dentista> dentista = dentistaService.buscaContatos();
        return dentista;
    }


    //Update Total do Recurso
    @PutMapping("/{id}")
    public ResponseEntity<Dentista> update(@PathVariable Long id, @Valid @RequestBody Dentista dentista) {


        Dentista dentistaSave = dentistaService.atualizar(id, dentista);
        return  ResponseEntity.ok(dentistaSave);
    }

    @PutMapping("/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Long id, @RequestBody Boolean ativo) {
        dentistaService.updateStatus(id, ativo);
    }
}

