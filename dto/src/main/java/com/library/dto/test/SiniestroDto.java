package com.library.dto.test;

import java.io.Serializable;
import java.util.Date;



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

    private PeritoDto perito;

    private SeguroDto seguro;

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

    public PeritoDto getPerito() {
        return perito;
    }

    public void setPerito(PeritoDto perito) {
        this.perito = perito;
    }

    public SeguroDto getSeguro() {
        return seguro;
    }

    public void setSeguro(SeguroDto seguro) {
        this.seguro = seguro;
    }

}
