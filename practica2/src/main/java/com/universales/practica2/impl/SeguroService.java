package com.universales.practica2.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.library.dto.test.SeguroDto;
import com.universales.practica2.entity.Seguro;
import com.universales.practica2.repository.SeguroRepository;

import org.modelmapper.ModelMapper;
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
    	ModelMapper mp = new ModelMapper();
        Seguro seguro = mp.map(newSeguro, Seguro.class);
        return seguro;
    }
    

}
