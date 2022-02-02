package com.library.dto.test;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import lombok.Data;

@Data
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

    private List<CompaniaDto> companias = new LinkedList<CompaniaDto>();

    
}
