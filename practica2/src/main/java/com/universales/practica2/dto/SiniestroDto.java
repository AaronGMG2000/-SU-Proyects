package com.universales.practica2.dto;

import java.io.Serializable;
import java.util.Date;

import com.universales.practica2.entity.Perito;
import com.universales.practica2.entity.Seguro;

public class SiniestroDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1402294540229535945L;

    private Integer idSiniestro;

    private Date fechaSiniestro;

    private String causas;

    private String aceptado;

    private String indermizacion;

    private Perito perito;

    private Seguro seguro;

    public Integer getIdSiniestro() {
        return idSiniestro;
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

}
