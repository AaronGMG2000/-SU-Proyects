package com.universales.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.universales.practica2.dto.ClienteDto;
import com.universales.practica2.entity.Cliente;
import com.universales.practica2.impl.ClienteService;

@SpringBootTest
class ClienteServiceTests {
		
	@Autowired
	ClienteService clienteService;
	
	@Test
	void buscar() {
		List<Cliente> clientes = clienteService.buscar();
		
		assertNotNull(clientes, "No hay Clientes Registrados");
	}
	
	@Test
	void guardar() {
		ClienteDto newCliente = new ClienteDto();
		newCliente.setApellido1("Marroquin");
		newCliente.setApellido2("Garcia");
		newCliente.setNombreCl("Rudy");
		newCliente.setClaseVia("clase 1");
		newCliente.setCodPostal("4003");
		newCliente.setNombreVia("via 1");
		newCliente.setNumeroVia("1");
		newCliente.setObservaciones("ninguna");
		newCliente.setTelefono("454545");
		newCliente.setSegurosList(new ArrayList<>());
		List<Cliente> clientes = clienteService.buscar();
		clienteService.guardar(newCliente);
		List<Cliente> clientesRegistro = clienteService.buscar();
		assertEquals(clientes.size()+1, clientesRegistro.size(), "Validado registro Cliente");
	}
	
	@Test
	void eliminar() {
		ClienteDto newCliente = new ClienteDto();
		newCliente.setApellido1("Marroquin");
		newCliente.setApellido2("Garcia");
		newCliente.setNombreCl("Rudy");
		newCliente.setClaseVia("clase 1");
		newCliente.setCodPostal("4003");
		newCliente.setNombreVia("via 1");
		newCliente.setNumeroVia("1");
		newCliente.setObservaciones("ninguna");
		newCliente.setTelefono("454545");
		newCliente.setSegurosList(new ArrayList<>());
		Cliente cliente = clienteService.guardar(newCliente);
		List<Cliente> clientes = clienteService.buscar();
		clienteService.eliminar(cliente.getDniCl());	
		List<Cliente> clientesE = clienteService.buscar();
		assertEquals(clientesE.size()+1, clientes.size(), "Validado eliminar Cliente");
	}
	
	@Test
	void buscarPorNombre() {
		List<Cliente> clientes = clienteService.buscarPorNombre("Rosy");
		assertEquals(0, clientes.size(), "Validado Busqueda por nombre");
	}
	
	@Test
	void buscarPorCiudad() {
		List<Cliente> clientes = clienteService.buscarPorCiudad("Totonicapan", "Peten");
		assertEquals(0, clientes.size(), "Validado busqueda por Ciudad");
	}
	
	@Test
	void buscarPorNombreApellido() {
		List<Cliente> clientes = clienteService.buscarPorNombreApellido("Rudy", "Marroquin");
		assertNotNull(clientes, "Validado busqueda por Nombre y Apellido");
	}
	
	@Test
	void buscarPorSeguros() {
		List<Cliente> clientes = clienteService.buscarPorSeguros();
		assertEquals(4, clientes.size(), "Validado busqueda por Seguros");;
	}
	
}
