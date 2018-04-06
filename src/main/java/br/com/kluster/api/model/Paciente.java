package br.com.kluster.api.model;

import br.com.kluster.api.enuns.Sexo;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Paciente")
public class Paciente implements Serializable {


    private static final long serialVersionUID=1L;

    public Paciente() {
    }

    public Paciente(String nome, String origem, String indicado, Sexo sexo, Date dataNascimento, Date dataCadastro,
                    String profissao, String empresaTrabalho, String email, String observacao, Endereco endereco, Convenio convenio, String numeroConvenio, boolean ativo) {
        this.nome = nome;
        this.origem = origem;
        this.indicado = indicado;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.profissao = profissao;
        this.empresaTrabalho = empresaTrabalho;
        this.email = email;
        this.observacao = observacao;
        this.endereco = endereco;
        this.convenio = convenio;
        this.numeroConvenio = numeroConvenio;
        this.ativo = ativo;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;

    @Size(min = 5 )
    @Column(name = "paciente_nome")
    private String nome;

    @Column(name = "paciente_origem")
    private String origem;

    @Column(name = "paciente_dr_indicacao")
    private String indicado;

    @Enumerated(EnumType.STRING)
    @Column(name = "paciente_sexo")
    private Sexo sexo;

    @Temporal(TemporalType.DATE)
    @Column(name = "paciente_dt_nascimento")
    private Date dataNascimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "paciente_dt_cadastro")
    private Date dataCadastro;

    @Column(name = "paciente_profissao")
    private String profissao;

    @Column(name = "paciente_empresa")
    private String empresaTrabalho;

    @Email
    @Column(name = "paciente_email")
    private String email;

    @Column(name = "paciente_observacao")
    private String observacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ElementCollection
    @CollectionTable(name = "telefone")
    private Set<String> telefones = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "id_convenio")
    private Convenio convenio;

    @Column(name = "paciente_numero_convenio")
    private String numeroConvenio;

    @Column(name = "paciente_status")
    private boolean ativo;

    private List<Atendimento> atendimentos = new ArrayList<>();

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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getIndicado() {
        return indicado;
    }

    public void setIndicado(String indicado) {
        this.indicado = indicado;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmpresaTrabalho() {
        return empresaTrabalho;
    }

    public void setEmpresaTrabalho(String empresaTrabalho) {
        this.empresaTrabalho = empresaTrabalho;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente paciente = (Paciente) o;

        return id != null ? id.equals(paciente.id) : paciente.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
