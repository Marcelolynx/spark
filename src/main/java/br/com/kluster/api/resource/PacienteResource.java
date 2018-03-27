package br.com.kluster.api.resource;

import br.com.kluster.api.Event.ResourceCreatedEvent;
import br.com.kluster.api.model.Paciente;
import br.com.kluster.api.repository.PacienteRepository;
import br.com.kluster.api.repository.filter.PacienteFilter;
import br.com.kluster.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/paciente")
public class PacienteResource {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public Page<Paciente> pesquisar(PacienteFilter pacienteFilter, Pageable pageable) {
        return pacienteRepository.filtrar(pacienteFilter, pageable);
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@Valid @RequestBody Paciente paciente, HttpServletResponse response) {

        Paciente pacienteSave = pacienteRepository.save(paciente);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, pacienteSave.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPorId(id);
        return paciente != null ? ResponseEntity.ok(paciente) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO')")
    public  void remove(@PathVariable long id) {
        pacienteRepository.delete(id);
    }


    //Update Total do Recurso
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        Paciente pacienteSave = pacienteService.atualizar(id, paciente);
        return  ResponseEntity.ok(pacienteSave);
    }

    @PutMapping("/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Long id, @RequestBody Boolean ativo) {
        pacienteService.updateStatus(id, ativo);
    }

}
