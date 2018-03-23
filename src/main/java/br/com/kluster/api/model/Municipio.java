package br.com.kluster.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Municipio")
public class Municipio implements Serializable {

    private static final long serialVersionUID=1L;

    public Municipio() {
    }

    public Municipio(String municipioIbge, String municipioNome, Estado estado) {
        this.municipioIbge = municipioIbge;
        this.municipioNome = municipioNome;
        this.estado = estado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio")
    private Long id;

    @Column(name = "municipio_ibge")
    private String municipioIbge;

    @Column(name = "municipio_nome")
    private String municipioNome;

    @ManyToOne
    @JoinColumn(name="id_estado", referencedColumnName = "id_estado", nullable=false)
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMunicipioIbge() {
        return municipioIbge;
    }

    public void setMunicipioIbge(String municipioIbge) {
        this.municipioIbge = municipioIbge;
    }

    public String getMunicipioNome() {
        return municipioNome;
    }

    public void setMunicipioNome(String municipioNome) {
        this.municipioNome = municipioNome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Municipio municipio = (Municipio) o;

        return id != null ? id.equals(municipio.id) : municipio.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
