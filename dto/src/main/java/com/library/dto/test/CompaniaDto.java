package com.library.dto.test;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import lombok.Data;


@Data
public class CompaniaDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8392649417983294941L;

    private String nombreCompania;

    private String claseVia;

    private String nombreVia;

    private Integer numeroVia;

    private String codPostal;

    private String telefonoContratacion;

    private String telefonoSiniestros;

    private String notas;

    private List<SeguroDto> seguros = new LinkedList<SeguroDto>();

 

}
