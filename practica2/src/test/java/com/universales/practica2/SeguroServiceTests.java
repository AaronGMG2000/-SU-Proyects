package com.universales.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.universales.practica2.dto.CompaniaDto;
import com.universales.practica2.dto.SeguroDto;
import com.universales.practica2.entity.Seguro;
import com.universales.practica2.impl.SeguroService;

@SpringBootTest
class SeguroServiceTests {
	@Autowired
	SeguroService seguroService;
	
	@Test
	void buscar() {
		List<Seguro> seguros = seguroService.buscar();
		assertNotNull(seguros);
	}
	
	@Test
	void guardar() {
		try {
			SeguroDto newSeguro = new SeguroDto();
			newSeguro.setCompanias(new ArrayList<CompaniaDto>());
			newSeguro.setCondicionesParticulares("ninguna");
			newSeguro.setDniCl(1);
			
			Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022");
			newSeguro.setFechaInicio(fechaInicio);
			Date fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2022");
			newSeguro.setFechaVencimiento(fechaVencimiento);
			newSeguro.setNumeroPoliza(220100);
			newSeguro.setObservaciones("ninguna");
			newSeguro.setRamo("ramo 1");
			List<Seguro> seguros =  seguroService.buscar();
			seguroService.guardar(newSeguro);
			List<Seguro> segurosG =  seguroService.buscar();
			seguroService.eliminar(newSeguro.getNumeroPoliza());
			assertNotEquals(seguros.size(), segurosG.size(), "Validado Guardar Seguro");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	void eliminar() {
		try {
			SeguroDto newSeguro = new SeguroDto();
			newSeguro.setCompanias(new ArrayList<CompaniaDto>());
			newSeguro.setCondicionesParticulares("ninguna");
			newSeguro.setDniCl(1);
			
			Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022");
			newSeguro.setFechaInicio(fechaInicio);
			Date fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2022");
			newSeguro.setFechaVencimiento(fechaVencimiento);
			newSeguro.setNumeroPoliza(20000122);
			newSeguro.setObservaciones("ninguna");
			newSeguro.setRamo("ramo 1");
			seguroService.guardar(newSeguro);
			List<Seguro> seguros =  seguroService.buscar();
			seguroService.eliminar(newSeguro.getNumeroPoliza());
			List<Seguro> segurosG =  seguroService.buscar();
			assertNotEquals(seguros.size(), segurosG.size(), "validado eliminar Seguro");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	void buscarPorCompania() {
		List<Seguro> seguros =  seguroService.buscarPorCompania();
		assertNotNull(seguros);
	}
	
	@Test
	void buscarPorInicio() {
		try {
			List<Seguro> seguros =  seguroService.buscarPorInicio(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022"));
			assertEquals(0, seguros.size(), "Validado buscar por inicio");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	void buscarPorVencimiento() {
		try {
			List<Seguro> seguros =  seguroService.buscarPorVencimiento(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022"));
			assertEquals(0, seguros.size(), "Validado buscar por vencimiento");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	void buscarPorInicioR() {
		try {
			List<Seguro> seguros =  seguroService.buscarPorInicio(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022"), new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2022"));
			assertEquals(0, seguros.size(), "Validado buscar por inicio rango");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	void buscarPorVencimientoR() {
		try {
			List<Seguro> seguros =  seguroService.buscarPorVencimiento(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022"), new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2022"));
			assertEquals(0, seguros.size(), "Validado buscar por vencimiento rango");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
}
