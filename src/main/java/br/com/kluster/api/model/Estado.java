package br.com.kluster.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Estado")
public class Estado implements Serializable {

    private static final long serialVersionUID=1L;

    public Estado() {
    }

    public Estado(String estadoCod, String estadoNome, String estadoUf, Regiao regiao) {
        this.estadoCod = estadoCod;
        this.estadoNome = estadoNome;
        this.estadoUf = estadoUf;
        this.regiao = regiao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long id;

    @Column(name = "estado_codigo_Uf")
    private String estadoCod;

    @Column(name = "estado_nome")
    private String estadoNome;

    @Column(name = "estado_uf")
    private String estadoUf;

    @ManyToOne
    @JoinColumn(name="id_regiao", referencedColumnName = "id_regiao", nullable=false)
    private Regiao regiao;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstadoCod() {
        return estadoCod;
    }

    public void setEstadoCod(String estadoCod) {
        this.estadoCod = estadoCod;
    }

    public String getEstadoNome() {
        return estadoNome;
    }

    public void setEstadoNome(String estadoNome) {
        this.estadoNome = estadoNome;
    }

    public String getEstadoUf() {
        return estadoUf;
    }

    public void setEstadoUf(String estadoUf) {
        this.estadoUf = estadoUf;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        return id != null ? id.equals(estado.id) : estado.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
