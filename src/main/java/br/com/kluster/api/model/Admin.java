package br.com.kluster.api.model;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {

    private Long id;

    private Date datetime;

    private Usuario usuario;
}
