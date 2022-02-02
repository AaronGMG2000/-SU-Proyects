package com.universales.practica2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "siniestros")
public class Siniestro implements Serializable {

    private static final long serialVersionUID = -4620202606439750149L;

    @Id
    @Column(name = "ID_SINIESTRO")
    private Integer idSiniestro;

    @Column(name = "FECHA_SINIESTRO")
    private Date fechaSiniestro;

    @Column(name = "CAUSAS")
    private String causas;

    @Column(name = "ACEPTADO")
    private String aceptado;

    @Column(name = "INDERMIZACION")
    private String indermizacion;

    @ManyToOne
    @JoinColumn(name = "DNI_PERITO")
    private Perito perito;

    @ManyToOne
    @JoinColumn(name = "NUMERO_POLIZA")
    private Seguro seguro;

    

}
