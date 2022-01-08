package com.universales.practica2.dto;

import java.io.Serializable;

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

    public Integer getDniPerito() {
        return dniPerito;
    }

    public void setDniPerito(Integer dniPerito) {
        this.dniPerito = dniPerito;
    }

    public String getNombrePerito() {
        return nombrePerito;
    }

    public void setNombrePerito(String nombrePerito) {
        this.nombrePerito = nombrePerito;
    }

    public String getApellidoPerito1() {
        return apellidoPerito1;
    }

    public void setApellidoPerito1(String apellidoPerito1) {
        this.apellidoPerito1 = apellidoPerito1;
    }

    public String getApellidoPerito2() {
        return apellidoPerito2;
    }

    public void setApellidoPerito2(String apellidoPerito2) {
        this.apellidoPerito2 = apellidoPerito2;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    public String getClaseVia() {
        return claseVia;
    }

    public void setClaseVia(String claseVia) {
        this.claseVia = claseVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public String getNumeroVia() {
        return numeroVia;
    }

    public void setNumeroVia(String numeroVia) {
        this.numeroVia = numeroVia;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
