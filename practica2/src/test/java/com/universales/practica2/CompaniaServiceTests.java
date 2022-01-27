package com.universales.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.dto.test.CompaniaDto;
import com.library.dto.test.SeguroDto;
import com.universales.practica2.entity.Compania;
import com.universales.practica2.impl.CompaniaService;

@SpringBootTest
class CompaniaServiceTests {
	
	@Autowired
	CompaniaService companiaService;
	
	@Test
	void buscar() {
		List<Compania> companias = companiaService.buscar();
		assertNotNull(companias, "Validado Buscar Compania");
	}
	
	@Test
	void guardar() {
		CompaniaDto newCompania = new CompaniaDto();
		newCompania.setClaseVia("clase 1");
		newCompania.setCodPostal("4003");
		newCompania.setNombreCompania("COMPANIA P");
		newCompania.setNombreVia("via 1");
		newCompania.setNotas("ninguna");
		newCompania.setNumeroVia(1);
		newCompania.setSeguros(new ArrayList<SeguroDto>());
		newCompania.setTelefonoContratacion("45454545");
		newCompania.setTelefonoSiniestros("50505050");
		List<Compania> companias = companiaService.buscar();
		companiaService.guardar(newCompania);
		List<Compania> companiasG = companiaService.buscar();
		companiaService.eliminar(newCompania.getNombreCompania());
		assertNotEquals(companias.size(), companiasG.size(), "Validado guardar Compania");
	}
	
	@Test
	void eliminar() {
		CompaniaDto newCompania = new CompaniaDto();
		newCompania.setClaseVia("clase 1");
		newCompania.setCodPostal("4003");
		newCompania.setNombreCompania("COMPANIA P2");
		newCompania.setNombreVia("via 1");
		newCompania.setNotas("ninguna");
		newCompania.setNumeroVia(1);
		newCompania.setSeguros(new ArrayList<SeguroDto>());
		newCompania.setTelefonoContratacion("45454545");
		newCompania.setTelefonoSiniestros("50505050");
		Compania compania = companiaService.guardar(newCompania);
		List<Compania> companias = companiaService.buscar();
		companiaService.eliminar(compania.getNombreCompania());
		List<Compania> companiasG = companiaService.buscar();
		assertNotEquals(companias.size(), companiasG.size(), "Validado guardar Compania");
	}
	
	@Test
	void buscarCompania() {
		List<Compania> companias = companiaService.buscar("COMPANIA2");
		assertEquals(1, companias.size());
	}
	
	@Test
	void buscarSeguro() {
		List<Compania> companias = companiaService.buscarSeguros();
		assertNotEquals(0, companias.size());
	}
	
	@Test
	void buscarSeguroNombre() {
		List<Compania> companias = companiaService.buscarSeguros("COMPANIA2");
		assertEquals(0, companias.size());
	}
}
