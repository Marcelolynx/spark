package br.com.kluster.api.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Convenio")
public class Convenio implements Serializable {

    private static final long serialVersionUID=1L;


    public Convenio() {
    }

    public Convenio(String convenioAns, String convenioNome, String convenioRazao, String convenioCnpj, boolean convenioStatus) {
        this.convenioAns = convenioAns;
        this.convenioNome = convenioNome;
        this.convenioRazao = convenioRazao;
        this.convenioCnpj = convenioCnpj;
        this.convenioStatus = convenioStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_convenio")
    private Long id;

    private String convenioAns;

    @NotNull
    @Column(name = "convenio_nome")
    @Size(min = 3, max = 50)
    private String convenioNome;

    @Column(name = "convenio_razao")
    private String convenioRazao;

    @Column(name = "convenio_cnpj")
    private String convenioCnpj;

    @Column(name = "convenio_status")
    private boolean convenioStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConvenioAns() {
        return convenioAns;
    }

    public void setConvenioAns(String convenioAns) {
        this.convenioAns = convenioAns;
    }

    public String getConvenioNome() {
        return convenioNome;
    }

    public void setConvenioNome(String convenioNome) {
        this.convenioNome = convenioNome;
    }

    public String getConvenioRazao() {
        return convenioRazao;
    }

    public void setConvenioRazao(String convenioRazao) {
        this.convenioRazao = convenioRazao;
    }

    public String getConvenioCnpj() {
        return convenioCnpj;
    }

    public void setConvenioCnpj(String convenioCnpj) {
        this.convenioCnpj = convenioCnpj;
    }

    public boolean isConvenioStatus() {
        return convenioStatus;
    }

    public void setConvenioStatus(boolean convenioStatus) {
        this.convenioStatus = convenioStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Convenio convenio = (Convenio) o;

        return id != null ? id.equals(convenio.id) : convenio.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
