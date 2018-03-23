package br.com.kluster.api.repository.filter;

import br.com.kluster.api.model.Dentista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DentistaRepositoryQuery {


    public Page<Dentista> filtrar(DentistaFilter dentistaFilter, Pageable pageable);
}
