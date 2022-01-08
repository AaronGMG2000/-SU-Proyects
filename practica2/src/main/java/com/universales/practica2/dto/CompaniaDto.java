package com.universales.practica2.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.universales.practica2.entity.Seguro;

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

    private List<Seguro> seguros = new ArrayList<>();

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
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

    public Integer getNumeroVia() {
        return numeroVia;
    }

    public void setNumeroVia(Integer numeroVia) {
        this.numeroVia = numeroVia;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getTelefonoContratacion() {
        return telefonoContratacion;
    }

    public void setTelefonoContratacion(String telefonoContratacion) {
        this.telefonoContratacion = telefonoContratacion;
    }

    public String getTelefonoSiniestros() {
        return telefonoSiniestros;
    }

    public void setTelefonoSiniestros(String telefonoSiniestros) {
        this.telefonoSiniestros = telefonoSiniestros;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

}
