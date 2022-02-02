package com.universales.practica2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CLIENTES")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -626547837542948450L;

	@Id
	@GeneratedValue(generator = "sec_cliente")
	@SequenceGenerator(name = "sec_cliente", sequenceName = "sec_cliente", allocationSize = 1)
	@Column(name = "DNI_CL")
	private Integer dniCl;

	@Column(name = "NOMBRE_CL")
	private String nombreCl;

	@Column(name = "APELLIDO_1")
	private String apellido1;

	@Column(name = "APELLIDO_2")
	private String apellido2;

	@Column(name = "CLASE_VIA")
	private String claseVia;

	@Column(name = "NOMBRE_VIA")
	private String nombreVia;

	@Column(name = "NUMERO_VIA")
	private String numeroVia;

	@Column(name = "COD_POSTAL")
	private String codPostal;

	@Column(name = "CIUDAD")
	private String ciudad;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "OBSERVACIONES")
	private String observaciones;

	@OneToMany(mappedBy = "dniCl")
	private List<Seguro> segurosList;

}
