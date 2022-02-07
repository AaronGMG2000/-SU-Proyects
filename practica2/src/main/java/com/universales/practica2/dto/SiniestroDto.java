package com.universales.practica2.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
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

    
}
