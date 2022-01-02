package com.universales.practica2.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    public Integer getIdSiniestro() {
        return idSiniestro;
    }

    public Perito getPerito() {
        return perito;
    }

    public void setPerito(Perito perito) {
        this.perito = perito;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public void setIdSiniestro(Integer idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public Date getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(Date fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public String getCausas() {
        return causas;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

    public String getAceptado() {
        return aceptado;
    }

    public void setAceptado(String aceptado) {
        this.aceptado = aceptado;
    }

    public String getIndermizacion() {
        return indermizacion;
    }

    public void setIndermizacion(String indermizacion) {
        this.indermizacion = indermizacion;
    }

}
