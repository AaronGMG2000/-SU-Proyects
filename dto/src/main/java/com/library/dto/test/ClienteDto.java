package com.library.dto.test;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ClienteDto implements Serializable {

    private static final long serialVersionUID = -8728137424181813238L;

    private Integer dniCl;

    private String nombreCl;

    private String apellido1;

    private String apellido2;

    private String claseVia;

    private String nombreVia;

    private String numeroVia;

    private String codPostal;

    private String ciudad;

    private String telefono;

    private String observaciones;

    private List<SeguroDto> segurosList;
}
