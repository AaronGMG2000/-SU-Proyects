package com.universales.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.universales.practica2.dto.CompaniaDto;
import com.universales.practica2.dto.ProcedimientoDto;
import com.universales.practica2.dto.SeguroDto;
import com.universales.practica2.service.ProcedureService;

@SpringBootTest
class ProcedureComponentTests {
	@Autowired
	ProcedureService procedureService;
	
	@Test
	void eliminarSeguro() {
		try {
			procedureService.eliminarSeguro(0);
			assertTrue(true);
		}catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	void guardarSeguro() {
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
			ProcedimientoDto procedure = procedureService.guardarSeguro(newSeguro);
			procedureService.eliminarSeguro(procedure.getNumeroPoliza());
			assertEquals(220100, procedure.getNumeroPoliza(), "Validado guardar Seguro");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	void guardarSeguroPackage() {
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
			int idSeguro = procedureService.guardarSeguroPackage(newSeguro);
			procedureService.eliminarSeguro(idSeguro);
			assertEquals(220100, idSeguro, "Validado guardar Seguro");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
}
