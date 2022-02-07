package com.universales.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.universales.practica2.dto.PeritoDto;
import com.universales.practica2.entity.Perito;
import com.universales.practica2.impl.PeritoService;

@SpringBootTest
class PeritoServiceTests {

	@Autowired
	PeritoService peritoService;
	
	@Test
	void buscar() {
		List<Perito> peritos = peritoService.buscar();
		assertNotNull(peritos);
	}
	
	@Test
	void guardar() {
		PeritoDto newPerito = new PeritoDto();
		newPerito.setApellidoPerito1("Marroquin");
		newPerito.setApellidoPerito2("Garcia");
		newPerito.setCiudad("Guatemala");
		newPerito.setClaseVia("Clase 1");
		newPerito.setCodPostal("4003");
		newPerito.setDniPerito(4);
		newPerito.setNombrePerito("Rudy");
		newPerito.setNombreVia("via 1");
		newPerito.setNumeroVia("numero 1");
		newPerito.setTelefonoContacto("12121212");
		newPerito.setTelefonoOficina("13131313");
		List<Perito> peritos = peritoService.buscar();
		peritoService.guardar(newPerito);
		List<Perito> peritosG = peritoService.buscar();
		peritoService.eliminar(newPerito.getDniPerito());
		assertNotEquals(peritosG.size(), peritos.size(), "Validado guardar Perito");
	}
	
	@Test
	void Eliminar() {
		PeritoDto newPerito = new PeritoDto();
		newPerito.setApellidoPerito1("Marroquin");
		newPerito.setApellidoPerito2("Garcia");
		newPerito.setCiudad("Guatemala");
		newPerito.setClaseVia("Clase 1");
		newPerito.setCodPostal("4003");
		newPerito.setDniPerito(4);
		newPerito.setNombrePerito("Rudy");
		newPerito.setNombreVia("via 1");
		newPerito.setNumeroVia("numero 1");
		newPerito.setTelefonoContacto("12121212");
		newPerito.setTelefonoOficina("13131313");
		peritoService.guardar(newPerito);
		List<Perito> peritos = peritoService.buscar();
		peritoService.eliminar(newPerito.getDniPerito());
		List<Perito> peritosG = peritoService.buscar();
		assertNotEquals(peritosG.size(), peritos.size(), "Validado eliminar Perito");
	}
	
	@Test
	void buscarPorApellido() {
		List<Perito> peritos = peritoService.buscarPorApellido("Rudy");
		assertEquals(1, peritos.size());
	}
	
	@Test
	void buscarPorApellidoNo() {
		List<Perito> peritos = peritoService.buscarPorApellidoNo("Marroquin");
		assertEquals(0, peritos.size());
	}
}
