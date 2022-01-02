package com.universales.practica2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companias_seguros")
public class CompaniaSeguro implements Serializable {

    private static final long serialVersionUID = -6433857068572607853L;

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE_COMPANIA")
    private String nombreCompania;

    @Column(name = "NUMERO_POLIZA")
    private Integer numeroPoliza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

}
