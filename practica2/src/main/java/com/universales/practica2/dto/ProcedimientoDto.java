package com.universales.practica2.dto;

import java.io.Serializable;

public class ProcedimientoDto implements Serializable {

    private static final long serialVersionUID = -2745688463382500563L;

    private String nombreCl;
    private int numeroPoliza;
    private int dniCl;

    public String getNombreCl() {
        return nombreCl;
    }

    public void setNombreCl(String nombreCl) {
        this.nombreCl = nombreCl;
    }

    public int getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(int numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public int getDniCl() {
        return dniCl;
    }

    public void setDniCl(int dniCl) {
        this.dniCl = dniCl;
    }

}
