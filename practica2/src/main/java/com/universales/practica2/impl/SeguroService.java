package com.universales.practica2.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.library.dto.test.CompaniaDto;
import com.library.dto.test.SeguroDto;
import com.universales.practica2.entity.Compania;
import com.universales.practica2.entity.Seguro;
import com.universales.practica2.repository.SeguroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seguro")
@CrossOrigin
public class SeguroService {
    @Autowired
    SeguroRepository seguroRepository;

    @GetMapping("/buscar")
    public List<Seguro> buscar() {
        return seguroRepository.findAll();
    }

    @GetMapping("/buscar/{numeroPoliza}")
    public Seguro buscar(@PathVariable("numeroPoliza") Integer numeroPoliza) {
        Optional<Seguro> compania = seguroRepository.findById(numeroPoliza);
        if (compania.isPresent()) {
            return compania.get();
        }
        return null;
    }

    @PostMapping("/guardar")
    public Seguro guardar(@RequestBody SeguroDto newSeguro) {
        Seguro seguro = this.nuevoSeguro(newSeguro);
        return seguroRepository.save(seguro);
    }

    @PutMapping("/actualizar")
    public Seguro actualizar(@RequestBody SeguroDto seguro) {
        return this.guardar(seguro);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id) {
        Optional<Seguro> seguro = seguroRepository.findById(id);
        if (seguro.isPresent()) {
            seguroRepository.delete(seguro.get());
        }
    }

    @GetMapping("/buscar/companias")
    public List<Seguro> buscarPorCompania() {
        return seguroRepository.findByCompaniasNotNull();
    }

    @GetMapping("/buscar/vencimiento")
    public List<Seguro> buscarPorVencimiento(@RequestParam Date fecha) {
        return seguroRepository.findByFechaVencimiento(fecha);
    }

    @GetMapping("/buscar/inicio")
    public List<Seguro> buscarPorInicio(@RequestParam Date fecha) {
        return seguroRepository.findByFechaInicio(fecha);
    }

    @GetMapping("/buscar/inicioRango")
    public List<Seguro> buscarPorInicio(@RequestParam Date fechaInicio,
            @RequestParam Date fechaFin) {
        return seguroRepository.findByFechaInicioBetween(fechaInicio, fechaFin);
    }

    @GetMapping("/buscar/vencimientoRango")
    public List<Seguro> buscarPorVencimiento(@RequestParam Date fechaInicio,
            @RequestParam Date fechaFin) {
        return seguroRepository.findByFechaVencimientoBetween(fechaInicio, fechaFin);
    }

    public Seguro nuevoSeguro(SeguroDto newSeguro) {
        Seguro seguro = new Seguro();
        seguro.setNumeroPoliza(newSeguro.getNumeroPoliza());
        seguro.setFechaInicio(newSeguro.getFechaInicio());
        seguro.setFechaVencimiento(newSeguro.getFechaVencimiento());
        List<Compania> companias = new ArrayList<>();
        for (CompaniaDto compania : newSeguro.getCompanias()) {
			companias.add(this.nuevoCompania(compania));
		}
        seguro.setCompanias(companias);
        seguro.setObservaciones(newSeguro.getObservaciones());
        seguro.setCondicionesParticulares(newSeguro.getCondicionesParticulares());
        seguro.setDniCl(newSeguro.getDniCl());
        seguro.setRamo(newSeguro.getRamo());
        return seguro;
    }
    
    public Compania nuevoCompania(CompaniaDto newCompania) {
        Compania compania = new Compania();
        compania.setNombreCompania(newCompania.getNombreCompania());
        compania.setNumeroVia(newCompania.getNumeroVia());
        compania.setClaseVia(newCompania.getClaseVia());
        compania.setCodPostal(newCompania.getCodPostal());
        compania.setNombreVia(newCompania.getNombreVia());
        compania.setNotas(newCompania.getNotas());
        compania.setNumeroVia(newCompania.getNumeroVia());
        compania.setTelefonoContratacion(newCompania.getTelefonoContratacion());
        compania.setTelefonoSiniestros(newCompania.getTelefonoSiniestros());
        return compania;
    }
}
