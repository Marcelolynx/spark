package br.com.kluster.api.resource;

import br.com.kluster.api.Event.ResourceCreatedEvent;
import br.com.kluster.api.Exceptions.ExceptionHandlerApi;
import br.com.kluster.api.Exceptions.PessoaInexistenteOuInativaException;
import br.com.kluster.api.model.Lancamento;
import br.com.kluster.api.repository.filter.LancamentoFilter;
import br.com.kluster.api.repository.LancamentoRepository;
import br.com.kluster.api.repository.projection.ResumoLancamento;
import br.com.kluster.api.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private MessageSource messageSource;



    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
    public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable) {
        return lancamentoRepository.filtrar(lancamentoFilter, pageable);
    }

    @GetMapping(params = "resumo")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
        return lancamentoRepository.resumir(lancamentoFilter, pageable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO')")
    public ResponseEntity<Lancamento> save(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSave = lancamentoService.salvar(lancamento);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, lancamentoSave.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSave);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
    public ResponseEntity<Lancamento> findById(@PathVariable Long id) {
        Lancamento lancamento = lancamentoRepository.findOne(id);
        return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO')")
    public void remover(@PathVariable Long codigo) {
        lancamentoRepository.delete(codigo);
    }


    //Update Total do Recurso
    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> update(@PathVariable Long id, @Valid @RequestBody Lancamento lancamento) {
        Lancamento lancamentoSave = lancamentoService.atualizar(id, lancamento);
        return  ResponseEntity.ok(lancamentoSave);
    }

    @ExceptionHandler({PessoaInexistenteOuInativaException.class})
    public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex) {
        String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.toString();
        List<ExceptionHandlerApi.Erro> erros = Arrays.asList(new ExceptionHandlerApi.Erro(mensagemUsuario, mensagemDesenvolvedor));
        return ResponseEntity.badRequest().body(erros);
    }
}
