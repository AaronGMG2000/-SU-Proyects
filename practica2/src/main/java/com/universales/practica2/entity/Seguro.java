package com.universales.practica2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "seguros")
public class Seguro implements Serializable {

    private static final long serialVersionUID = 5953778832493010843L;

    @Id
    @Column(name = "NUMERO_POLIZA")
    private Integer numeroPoliza;

    @Column(name = "RAMO")
    private String ramo;

    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;

    @Column(name = "FECHA_VENCIMIENTO")
    private Date fechaVencimiento;

    @Column(name = "CONDICIONES_PARTICULARES")
    private String condicionesParticulares;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Column(name = "DNI_CL")
    private Integer dniCl;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "companias_seguros", joinColumns = @JoinColumn(name = "NUMERO_POLIZA"), inverseJoinColumns = @JoinColumn(name = "NOMBRE_COMPANIA"))
    @JsonIgnore
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
