package com.universales.practica2.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
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

import lombok.Data;

@Data
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
    private List<Compania> companias = new LinkedList<Compania>();

    
}
