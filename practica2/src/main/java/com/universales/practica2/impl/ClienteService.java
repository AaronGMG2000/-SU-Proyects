package com.universales.practica2.impl;

import com.universales.practica2.repository.ClienteRepository;
import com.universales.practica2.repository.SeguroRepository;
import com.library.dt.TestDto.ClienteDto;
import com.library.dt.TestDto.SeguroDto;
import com.universales.practica2.entity.Cliente;
import com.universales.practica2.entity.Seguro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping(path = "/buscar")
    public List<Cliente> buscar() {
        return clienteRepository.findAll();
    }

    @PostMapping(path = "/guardar")
    public Cliente guardar(@RequestBody ClienteDto newCliente) {
        Cliente cliente = this.nuevoCliente(newCliente);
        List<Seguro> seguros = cliente.getSegurosList();
        cliente.setSegurosList(null);
        clienteRepository.save(cliente);

        for (Seguro seguro : seguros) {
            seguro.setDniCl(cliente.getDniCl());
        }
        seguroRepository.saveAll(seguros);
        cliente.setSegurosList(seguros);
        return cliente;
    }

    @PutMapping(path = "/actualizar")
    public Cliente actualizar(@RequestBody ClienteDto cliente) {
        return this.guardar(cliente);
    }

    @DeleteMapping(path = "/eliminar/{idusuario}")
    public void eliminar(@PathVariable("idusuario") int idusuario) {
        Optional<Cliente> cliente = clienteRepository.findById(idusuario);
        if (cliente.isPresent()) {
            seguroRepository.deleteAll(cliente.get().getSegurosList());
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
        Cliente cliente = new Cliente();
        cliente.setDniCl(newCliente.getDniCl());
        cliente.setNombreCl(newCliente.getNombreCl());
        cliente.setApellido1(newCliente.getApellido1());
        cliente.setApellido2(newCliente.getApellido2());
        cliente.setCiudad(newCliente.getCiudad());
        cliente.setNumeroVia(newCliente.getNumeroVia());
        cliente.setTelefono(newCliente.getTelefono());
        cliente.setClaseVia(newCliente.getClaseVia());
        cliente.setNombreVia(newCliente.getNombreVia());
        cliente.setCodPostal(newCliente.getCodPostal());
        cliente.setObservaciones(newCliente.getObservaciones());
        List<Seguro> seguros = new ArrayList<>();
        for (SeguroDto seguro : newCliente.getSegurosList()) {
			seguros.add(this.nuevoSeguro(seguro));
		}
        cliente.setSegurosList(seguros);
        return cliente;
    }
    
    public Seguro nuevoSeguro(SeguroDto newSeguro) {
        Seguro seguro = new Seguro();
        seguro.setNumeroPoliza(newSeguro.getNumeroPoliza());
        seguro.setFechaInicio(newSeguro.getFechaInicio());
        seguro.setFechaVencimiento(newSeguro.getFechaVencimiento());
        seguro.setObservaciones(newSeguro.getObservaciones());
        seguro.setCondicionesParticulares(newSeguro.getCondicionesParticulares());
        seguro.setDniCl(newSeguro.getDniCl());
        seguro.setRamo(newSeguro.getRamo());
        return seguro;
    }
    
    
}
