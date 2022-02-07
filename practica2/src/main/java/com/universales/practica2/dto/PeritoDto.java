package com.universales.practica2.dto;

import java.io.Serializable;

import lombok.Data;


@Data
public class PeritoDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2115552264225579404L;

    private Integer dniPerito;

    private String nombrePerito;

    private String apellidoPerito1;

    private String apellidoPerito2;

    private String telefonoContacto;

    private String telefonoOficina;

    private String claseVia;

    private String nombreVia;

    private String numeroVia;

    private String codPostal;

    private String ciudad;


}
