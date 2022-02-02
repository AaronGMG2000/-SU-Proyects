package com.library.dto.test;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProcedimientoDto implements Serializable {

    private static final long serialVersionUID = -2745688463382500563L;

    private String nombreCl;
    private int numeroPoliza;
    private int dniCl;

  
}
