package br.com.kluster.api.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ItemAtendimentoPK implements Serializable {

    private static final long serialVersionUID=1L;

    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    private Atendimento atendimento;
    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemAtendimentoPK that = (ItemAtendimentoPK) o;

        if (atendimento != null ? !atendimento.equals(that.atendimento) : that.atendimento != null) return false;
        return procedimento != null ? procedimento.equals(that.procedimento) : that.procedimento == null;
    }

    @Override
    public int hashCode() {
        int result = atendimento != null ? atendimento.hashCode() : 0;
        result = 31 * result + (procedimento != null ? procedimento.hashCode() : 0);
        return result;
    }
}
