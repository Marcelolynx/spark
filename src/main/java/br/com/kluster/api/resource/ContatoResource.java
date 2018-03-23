package br.com.kluster.api.resource;

import br.com.kluster.api.model.Contato;
import br.com.kluster.api.repository.ContatoRepository;
import br.com.kluster.api.service.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contato")
public class ContatoResource {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private ContatoService contatoService;


    @GetMapping
    public List<Contato> listAll() {
        return contatoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Contato> save(@Valid @RequestBody Contato contato, HttpServletResponse response) {

        Contato contatoSave = contatoRepository.save(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoSave);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable Long id) {
        Contato contato = contatoRepository.findOne(id);
        return contato != null ? ResponseEntity.ok(contato) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void remove(@PathVariable long id) {
        contatoRepository.delete(id);
    }


    //Update Total do Recurso
    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @Valid @RequestBody Contato contato) {


        Contato contatoSave = contatoService.atualizar(id, contato);
        return  ResponseEntity.ok(contatoSave);
    }

}
