package br.com.kluster.api.resource;

import br.com.kluster.api.Event.ResourceCreatedEvent;
import br.com.kluster.api.model.Endereco;
import br.com.kluster.api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@Valid @RequestBody Endereco endereco, HttpServletResponse response) {
        Endereco enderecoSave = enderecoRepository.save(endereco);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, enderecoSave.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSave);
    }
}
