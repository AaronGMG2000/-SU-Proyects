package com.library.dto.test;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompaniaSeguroDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8591543249040883237L;

    private Integer id;

    private String nombreCompania;

    private Integer numeroPoliza;

    

}
