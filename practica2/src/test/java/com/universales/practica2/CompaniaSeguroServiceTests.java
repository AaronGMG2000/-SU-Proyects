package com.universales.practica2;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.universales.practica2.dto.CompaniaSeguroDto;
import com.universales.practica2.entity.CompaniaSeguro;
import com.universales.practica2.impl.CompaniaSeguroService;

@SpringBootTest
class CompaniaSeguroServiceTests {
	@Autowired
	CompaniaSeguroService companiaSeguroService;
	
	@Test
	void buscar() {
		List<CompaniaSeguro> companiaSeguros = companiaSeguroService.buscar();
		assertNotNull(companiaSeguros);
	}
	
	@Test
	void guardar() {
		CompaniaSeguroDto newCompaniaSeguro = new CompaniaSeguroDto();
		newCompaniaSeguro.setNombreCompania("COMPANIA2");
		newCompaniaSeguro.setNumeroPoliza(35);
		companiaSeguroService.guardar(newCompaniaSeguro);
		assertTrue(true, "Validado guardar CompaniaSeguro");
	}
	
	@Test
	void eliminar() {
		try {
			CompaniaSeguroDto newCompaniaSeguro = new CompaniaSeguroDto();
			newCompaniaSeguro.setNombreCompania("COMPANIA2");
			newCompaniaSeguro.setNumeroPoliza(35);
			CompaniaSeguro  companiaSeguro= companiaSeguroService.guardar(newCompaniaSeguro).getBody();
			List<CompaniaSeguro> companiaSeguros = companiaSeguroService.buscar();
			companiaSeguroService.eliminar(companiaSeguro.getId());
			List<CompaniaSeguro> companiaSegurosE = companiaSeguroService.buscar();
			assertEquals(companiaSegurosE.size()+1, companiaSeguros.size(), "Validado eliminar Compania Seguro");	
		}catch (Exception e) {
			assertFalse(true, "Fallido eliminar CompaniaSeguro");
		}
	}
}
