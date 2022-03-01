package com.universales.practica2.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SiniestroCantidadDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3956231846474860205L;
	private String nombreCl;
	private String apellido1;
	private Integer dniCl;
	private String nombrePerito;
	private String apellidoPerito1;
	private Integer dniPerito;
	private Integer numeroPoliza;
	private String indermizacion;
	private Long cantidad;
}
