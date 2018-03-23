package br.com.kluster.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Contato")
public class Contato implements Serializable {


    private static final long serialVersionUID=1L;

    public Contato() {
    }

    public Contato(String numero, Dentista dentista, Paciente paciente) {
        this.numero = numero;
        this.dentista = dentista;
        this.paciente = paciente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato")
    private Long id;

    @Column(name = "contato_numero")
    private String numero;

    @ManyToOne
    @JoinColumn(name="id_dentista", referencedColumnName="id_dentista")
    private Dentista dentista;


    @ManyToOne
    @JoinColumn(name="id_paciente", referencedColumnName="id_paciente")
    private Paciente paciente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contato contato = (Contato) o;

        return id != null ? id.equals(contato.id) : contato.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
