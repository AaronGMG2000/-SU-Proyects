package com.universales.practica2;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.universales.practica2.dto.CompaniaDto;
import com.universales.practica2.dto.PeritoDto;
import com.universales.practica2.dto.SeguroDto;
import com.universales.practica2.dto.SiniestroDto;
import com.universales.practica2.entity.Siniestro;
import com.universales.practica2.impl.SiniestroService;

@SpringBootTest
class SiniestroServiceTests {

	@Autowired
	SiniestroService siniestroService;
	
	@Test
	void buscar() {
		List<Siniestro> siniestros = siniestroService.buscar();
		assertNotNull(siniestros);
	}
	
	@Test
	void guardar() {
		try {
			SiniestroDto newSiniestro = new SiniestroDto();
			PeritoDto newPerito = new PeritoDto();
			SeguroDto newSeguro = new SeguroDto();
			
			newSiniestro.setAceptado("aceptado");
			newSiniestro.setCausas("causa");
			newSiniestro.setFechaSiniestro(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022"));
			newSiniestro.setIdSiniestro(2);
			newSiniestro.setIndermizacion("100");
			
			newSeguro.setCompanias(new ArrayList<CompaniaDto>());
			newSeguro.setCondicionesParticulares("ninguna");
			newSeguro.setDniCl(1);
			Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022");
			newSeguro.setFechaInicio(fechaInicio);
			Date fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2022");
			newSeguro.setFechaVencimiento(fechaVencimiento);
			newSeguro.setNumeroPoliza(35);
			newSeguro.setObservaciones("ninguna");
			newSeguro.setRamo("ramo 1");
			
			newPerito.setApellidoPerito1("Marroquin");
			newPerito.setApellidoPerito2("Garcia");
			newPerito.setCiudad("Guatemala");
			newPerito.setClaseVia("Clase 1");
			newPerito.setCodPostal("4003");
			newPerito.setDniPerito(12);
			newPerito.setNombrePerito("Rudy");
			newPerito.setNombreVia("via 1");
			newPerito.setNumeroVia("numero 1");
			newPerito.setTelefonoContacto("12121212");
			newPerito.setTelefonoOficina("13131313");
			
			newSiniestro.setPerito(newPerito);
			newSiniestro.setSeguro(newSeguro);
			List<Siniestro> siniestros = siniestroService.buscar();
			siniestroService.guardar(newSiniestro);
			List<Siniestro> siniestrosG = siniestroService.buscar();
			siniestroService.eliminar(newSiniestro.getIdSiniestro());
			assertNotEquals(siniestrosG.size(), siniestros.size(), "Evaluado guardar Siniestro");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	void eliminar() {
		try {
			SiniestroDto newSiniestro = new SiniestroDto();
			PeritoDto newPerito = new PeritoDto();
			SeguroDto newSeguro = new SeguroDto();
			
			newSiniestro.setAceptado("aceptado");
			newSiniestro.setCausas("causa");
			newSiniestro.setFechaSiniestro(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022"));
			newSiniestro.setIdSiniestro(2);
			newSiniestro.setIndermizacion("100");
			
			newSeguro.setCompanias(new ArrayList<CompaniaDto>());
			newSeguro.setCondicionesParticulares("ninguna");
			newSeguro.setDniCl(1);
			Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022");
			newSeguro.setFechaInicio(fechaInicio);
			Date fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2022");
			newSeguro.setFechaVencimiento(fechaVencimiento);
			newSeguro.setNumeroPoliza(35);
			newSeguro.setObservaciones("ninguna");
			newSeguro.setRamo("ramo 1");
			
			newPerito.setApellidoPerito1("Marroquin");
			newPerito.setApellidoPerito2("Garcia");
			newPerito.setCiudad("Guatemala");
			newPerito.setClaseVia("Clase 1");
			newPerito.setCodPostal("4003");
			newPerito.setDniPerito(12);
			newPerito.setNombrePerito("Rudy");
			newPerito.setNombreVia("via 1");
			newPerito.setNumeroVia("numero 1");
			newPerito.setTelefonoContacto("12121212");
			newPerito.setTelefonoOficina("13131313");
			
			newSiniestro.setPerito(newPerito);
			newSiniestro.setSeguro(newSeguro);
			siniestroService.guardar(newSiniestro);
			List<Siniestro> siniestros = siniestroService.buscar();
			siniestroService.eliminar(newSiniestro.getIdSiniestro());
			List<Siniestro> siniestrosG = siniestroService.buscar();
			assertNotEquals(siniestrosG.size(), siniestros.size(), "Evaluado guardar Siniestro");
		}catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	void buscarPorFechaAntes() {
		try {
			List<Siniestro> siniestros = siniestroService.buscarPorFechaAntes(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"));
			assertEquals(0, siniestros.size(), "validado buscar por fecha antes");
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	void buscarPorFechaDespues() {
		try {
			List<Siniestro> siniestros = siniestroService.buscarPorFechaDespues(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"));
			assertEquals(0, siniestros.size(), "validado buscar por fecha despues");
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	void buscarPorPerito() {
		List<Siniestro> siniestros = siniestroService.buscarPorPerito();
		assertNotNull(siniestros, "Validado buscar por perito");
	}
	
	void buscarPorIndermizacion() {
		List<Siniestro> siniestros = siniestroService.buscarPorPerito("100");
		assertEquals(0, siniestros.size(), "validado buscar por perito indermización");
	}
	
	void buscarPorPoliza() {
		List<Siniestro> siniestros = siniestroService.buscarPorPoliza();
		assertNotNull(siniestros, "validado buscar por poliza");
	}
	
	void buscarPorQuery() {
		List<Map<String, Object>> siniestros = siniestroService.buscarPorQuery();
		assertNotNull(siniestros, "validado buscar por query");
	}
}
