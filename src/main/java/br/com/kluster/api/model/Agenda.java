package br.com.kluster.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Agenda")
public class Agenda implements Serializable {

    private static final long serialVersionUID=1L;

    public Agenda() {
    }

    public Agenda(Date dataAgenda, Date horaAgenda, Paciente paciente, Dentista dentista) {
        this.dataAgenda = dataAgenda;
        this.horaAgenda = horaAgenda;
        this.paciente = paciente;
        this.dentista = dentista;
    }

    @Id
    @Column(name = "id_agenda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "agenda_data")
    private Date dataAgenda;

    @Temporal(TemporalType.TIME)
    @Column(name = "agenda_hora")
    private Date horaAgenda;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_dentista")
    private Dentista dentista;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(Date dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public Date getHoraAgenda() {
        return horaAgenda;
    }

    public void setHoraAgenda(Date horaAgenda) {
        this.horaAgenda = horaAgenda;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }
}
