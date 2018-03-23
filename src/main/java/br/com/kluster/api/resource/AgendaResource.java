package br.com.kluster.api.resource;

import br.com.kluster.api.model.Agenda;
import br.com.kluster.api.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaResource {


    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Agenda> save(@Valid @RequestBody Agenda agenda, HttpServletResponse response) {

        Agenda agendaSave = agendaRepository.save(agenda);

        return ResponseEntity.status(HttpStatus.CREATED).body(agendaSave);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable long id) {
        agendaRepository.delete(id);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Agenda> findById(@PathVariable Long id) {
        Agenda agenda = agendaRepository.findOne(id);
        return agenda != null ? ResponseEntity.ok(agenda) : ResponseEntity.notFound().build();
    }
}