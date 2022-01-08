package com.universales.practica2.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.universales.practica2.dto.SiniestroDto;
import com.universales.practica2.entity.Siniestro;
import com.universales.practica2.repository.SiniestroRepository;

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
@RequestMapping("/siniestro")
@CrossOrigin
public class SiniestroService {
    @Autowired
    SiniestroRepository siniestroRepository;

    @GetMapping(value = "/buscar")
    public List<Siniestro> buscar() {
        return siniestroRepository.findAll();
    }

    @PostMapping(value = "/guardar")
    public Siniestro guardar(@RequestBody SiniestroDto newSiniestro) {
        Siniestro siniestro = this.nuevoSiniestro(newSiniestro);
        return siniestroRepository.save(siniestro);
    }

    @PutMapping(value = "/actualizar")
    public Siniestro actualizar(@RequestBody SiniestroDto newSiniestro) {
        return this.guardar(newSiniestro);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id) {
        Optional<Siniestro> siniestro = siniestroRepository.findById(id);
        if (siniestro.isPresent()) {
            siniestroRepository.delete(siniestro.get());
        }
    }

    @GetMapping(value = "/buscar/indermizacion/{indermizacion}")
    public List<Siniestro> buscarPorPerito(@PathVariable("indermizacion") String indermizacion) {
        return siniestroRepository.findByIndermizacion(indermizacion);
    }

    @GetMapping(value = "/buscar/seguro")
    public List<Siniestro> buscarPorPoliza() {
        return siniestroRepository.findBySeguroNotNullOrderByFechaSiniestroAsc();
    }

    @GetMapping(value = "/buscar/perito")
    public List<Siniestro> buscarPorPerito() {
        return siniestroRepository.findByPeritoNotNullOrderByFechaSiniestroDesc();
    }

    @GetMapping(value = "/buscar/fecha/despues")
    public List<Siniestro> buscarPorFechaDespues(@RequestParam Date fechaSiniestro) {
        return siniestroRepository.findAllByFechaSiniestroAfter(fechaSiniestro);
    }

    @GetMapping(value = "/buscar/fecha/antes")
    public List<Siniestro> buscarPorFechaAntes(@RequestParam Date fechaSiniestro) {
        return siniestroRepository.findAllByFechaSiniestroBefore(fechaSiniestro);
    }

    public Siniestro nuevoSiniestro(SiniestroDto newSiniestro) {
        Siniestro siniestro = new Siniestro();
        siniestro.setFechaSiniestro(newSiniestro.getFechaSiniestro());
        siniestro.setIndermizacion(newSiniestro.getIndermizacion());
        siniestro.setPerito(newSiniestro.getPerito());
        siniestro.setSeguro(newSiniestro.getSeguro());
        siniestro.setIdSiniestro(newSiniestro.getIdSiniestro());
        siniestro.setCausas(newSiniestro.getCausas());
        siniestro.setAceptado(newSiniestro.getAceptado());
        return siniestro;
    }
}
