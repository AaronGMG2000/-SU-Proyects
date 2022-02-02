package com.universales.practica2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PERITOS")
public class Perito implements Serializable {

    private static final long serialVersionUID = -6265416431636172505L;

    @Id
    @Column(name = "DNI_PERITO")
    private Integer dniPerito;

    @Column(name = "NOMBRE_PERITO")
    private String nombrePerito;

    @Column(name = "APELLIDO_PERITO1")
    private String apellidoPerito1;

    @Column(name = "APELLIDO_PERITO2")
    private String apellidoPerito2;

    @Column(name = "TELEFONO_CONTACTO")
    private String telefonoContacto;

    @Column(name = "TELEFONO_OFICINA")
    private String telefonoOficina;

    @Column(name = "CLASE_VIA")
    private String claseVia;

    @Column(name = "NOMBRE_VIA")
    private String nombreVia;

    @Column(name = "NUMERO_VIA")
    private String numeroVia;

    @Column(name = "COD_POSTAL")
    private String codPostal;

    @Column(name = "CIUDAD")
    private String ciudad;

}
