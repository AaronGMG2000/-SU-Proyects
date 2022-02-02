package com.universales.practica2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "companias_seguros")
public class CompaniaSeguro implements Serializable {

    private static final long serialVersionUID = -6433857068572607853L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "NOMBRE_COMPANIA")
    private String nombreCompania;

    @Column(name = "NUMERO_POLIZA")
    private Integer numeroPoliza;

}
