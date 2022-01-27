package com.library.dto.test;

import java.io.Serializable;

public class CompaniaSeguroDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8591543249040883237L;

    private Integer id;

    private String nombreCompania;

    private Integer numeroPoliza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

}
