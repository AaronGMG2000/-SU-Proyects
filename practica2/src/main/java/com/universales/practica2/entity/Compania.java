package com.universales.practica2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COMPANIAS")
public class Compania implements Serializable {

    private static final long serialVersionUID = 1175445907733610202L;

    @Id
    @Column(name = "NOMBRE_COMPANIA")
    private String nombreCompania;

    @Column(name = "CLASE_VIA")
    private String claseVia;

    @Column(name = "NOMBRE_VIA")
    private String nombreVia;

    @Column(name = "NUMERO_VIA")
    private Integer numeroVia;

    @Column(name = "COD_POSTAL")
    private String codPostal;

    @Column(name = "TELEFONO_CONTRATACION")
    private String telefonoContratacion;

    @Column(name = "TELEFONO_SINIESTROS")
    private String telefonoSiniestros;

    @Column(name = "NOTAS")
    private String notas;

    @ManyToMany(mappedBy = "companias", cascade = CascadeType.ALL)
    private List<Seguro> seguros;


}
