package com.universales.practica2.impl;

import com.universales.practica2.repository.ClienteRepository;
import com.universales.practica2.repository.SeguroRepository;
import com.universales.practica2.dto.ClienteDto;
import com.universales.practica2.entity.Cliente;
import com.universales.practica2.entity.Seguro;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    SeguroRepository seguroRepository;	
    
    private static final Log LOG = LogFactory.getLog(ClienteService.class);

    @GetMapping(path = "/buscar")
    public List<Cliente> buscar() {
        return clienteRepository.findAll();
    }

    @PostMapping(path = "/guardar")
    public ResponseEntity<Cliente> guardar(@RequestBody ClienteDto newCliente) {
    	
    	try {
    		Cliente cliente = this.nuevoCliente(newCliente);
            List<Seguro> seguros = cliente.getSegurosList();
            cliente.setSegurosList(null);
            cliente = clienteRepository.save(cliente);
            for (Seguro seguro : seguros) {
                seguro.setDniCl(cliente.getDniCl());
            }
            seguroRepository.saveAll(seguros);
            cliente.setSegurosList(seguros);
            return ResponseEntity.ok().body(cliente);
    	}catch (Exception e) {
    		LOG.error("ERROR EN LA PERSISTENCIA DE DATOS" + e);
    		return ResponseEntity.internalServerError().body(null);
		}
    	
    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<Cliente> actualizar(@RequestBody ClienteDto cliente) {
        return this.guardar(cliente);
    }

    @DeleteMapping(path = "/eliminar/{idusuario}")
    public void eliminar(@PathVariable("idusuario") int idusuario) {
        Optional<Cliente> cliente = clienteRepository.findById(idusuario);
        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
        }
    }

    @GetMapping(value = "buscar/nombre/{nombre}")
    public List<Cliente> buscarPorNombre(@PathVariable("nombre") String nombre) {
        return clienteRepository.findByNombreCl(nombre);
    }

    @GetMapping(value = "buscar/seguros")
    public List<Cliente> buscarPorSeguros() {
        return clienteRepository.findDistinctBySegurosListNotNull();
    }

    @GetMapping(value = "buscar/nombre/apellido/{nombre}/{apellido}")
    public List<Cliente> buscarPorNombreApellido(@PathVariable("nombre") String nombre,
            @PathVariable("apellido") String apellido) {
        return clienteRepository.findDistinctByNombreClContainingAndApellido1ContainingAndSegurosListNotNull(nombre,
                apellido);
    }

    @GetMapping(value = "buscar/ciudad/{ciudad1}/{ciudad2}")
    public List<Cliente> buscarPorCiudad(@PathVariable("ciudad1") String ciudad1,
            @PathVariable("ciudad2") String ciudad2) {
        return clienteRepository.findByCiudadOrCiudad(ciudad1, ciudad2);
    }

    public Cliente nuevoCliente(ClienteDto newCliente) {
        ModelMapper mp = new ModelMapper();
        return mp.map(newCliente, Cliente.class);
    }
    
    @GetMapping(value = "buscar/{apellido1}/{pagina}/{cantidad}")
    public Page<Cliente> buscarApellido1(@PathVariable("apellido1") String apellido1, @PathVariable("pagina") Integer pagina, @PathVariable("cantidad") Integer cantidad){
    	Pageable paginador = PageRequest.of(pagina, cantidad);
    	return clienteRepository.findByApellido1(paginador, apellido1);
    }
    
    @GetMapping(value = "buscar/jpql/ciudad/{ciudad}/{pagina}/{cantidad}")
    public Page<Cliente> buscarPorCiudadJpql(@PathVariable("ciudad") String ciudad, @PathVariable("pagina") int pagina, @PathVariable("cantidad") int cantidad){
    	Pageable paginacion = PageRequest.of(pagina, cantidad);
    	return clienteRepository.findByCiudad(paginacion, ciudad);
    }

}
