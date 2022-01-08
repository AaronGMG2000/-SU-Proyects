package com.universales.practica2.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.universales.practica2.entity.Compania;

public class SeguroDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6957430226005629106L;

    private Integer numeroPoliza;

    private String ramo;

    private Date fechaInicio;

    private Date fechaVencimiento;

    private String condicionesParticulares;

    private String observaciones;

    private Integer dniCl;

    private List<Compania> companias = new ArrayList<>();

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCondicionesParticulares() {
        return condicionesParticulares;
    }

    public void setCondicionesParticulares(String condicionesParticulares) {
        this.condicionesParticulares = condicionesParticulares;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getDniCl() {
        return dniCl;
    }

    public void setDniCl(Integer dniCl) {
        this.dniCl = dniCl;
    }

    public List<Compania> getCompanias() {
        return companias;
    }

    public void setCompanias(List<Compania> companias) {
        this.companias = companias;
    }

}
