package br.com.kluster.api.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Dentista")
public class Dentista implements Serializable {


    private static final long serialVersionUID=1L;

    public Dentista() {
    }

    public Dentista(String nome, String cro, String email, Endereco endereco) {
        this.nome = nome;
        this.cro = cro;
        this.email = email;
        this.endereco = endereco;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentista")
    private Long id;

    @Column(name = "dentista_nome")
    private String nome;

    @Column(name = "dentista_cro")
    private String cro;

    @Column(name = "dentista_email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column(name = "status")
    private boolean ativo;

    @Transient
    @JsonIgnore
    public boolean isInativo() {
        return  !this.ativo;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dentista dentista = (Dentista) o;

        return id != null ? id.equals(dentista.id) : dentista.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
