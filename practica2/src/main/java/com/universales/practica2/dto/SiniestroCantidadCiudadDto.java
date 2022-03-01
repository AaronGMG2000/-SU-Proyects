package com.universales.practica2.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SiniestroCantidadCiudadDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8576320148841622887L;
	private String nombreCl;
	private String apellido1;
	private Integer dniCl;
	private String ciudad;
	private String nombrePerito;
	private String apellidoPerito1;
	private Integer dniPerito;
	private Integer numeroPoliza;
	private String indermizacion;
	private Long cantidad;
}
