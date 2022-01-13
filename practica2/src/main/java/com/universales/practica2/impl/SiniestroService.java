package com.universales.practica2.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.universales.practica2.dto.SiniestroDto;
import com.universales.practica2.entity.Siniestro;
import com.universales.practica2.repository.SiniestroRepository;
import com.universales.practica2.service.CatalogosService;
import com.universales.practica2.ws.SiniestroServiceInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class SiniestroService implements SiniestroServiceInt {
    @Autowired
    SiniestroRepository siniestroRepository;

    @Autowired
    CatalogosService catalogosService;

    @Override
    public List<Siniestro> buscar() {
        return siniestroRepository.findAll();
    }

    @Override
    public Siniestro guardar(@RequestBody SiniestroDto newSiniestro) {
        Siniestro siniestro = this.nuevoSiniestro(newSiniestro);
        return siniestroRepository.save(siniestro);
    }

    @Override
    public Siniestro actualizar(@RequestBody SiniestroDto newSiniestro) {
        return this.guardar(newSiniestro);
    }

    @Override
    public void eliminar(@PathVariable("id") int id) {
        Optional<Siniestro> siniestro = siniestroRepository.findById(id);
        if (siniestro.isPresent()) {
            siniestroRepository.delete(siniestro.get());
        }
    }

    @Override
    public List<Siniestro> buscarPorPerito(@PathVariable("indermizacion") String indermizacion) {
        return siniestroRepository.findByIndermizacion(indermizacion);
    }

    @Override
    public List<Siniestro> buscarPorPoliza() {
        return siniestroRepository.findBySeguroNotNullOrderByFechaSiniestroAsc();
    }

    @Override
    public List<Siniestro> buscarPorPerito() {
        return siniestroRepository.findByPeritoNotNullOrderByFechaSiniestroDesc();
    }

    @Override
    public List<Siniestro> buscarPorFechaDespues(@RequestParam Date fechaSiniestro) {
        return siniestroRepository.findAllByFechaSiniestroAfter(fechaSiniestro);
    }

    @Override
    public List<Siniestro> buscarPorFechaAntes(@RequestParam Date fechaSiniestro) {
        return siniestroRepository.findAllByFechaSiniestroBefore(fechaSiniestro);
    }

    private Siniestro nuevoSiniestro(SiniestroDto newSiniestro) {
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

    @Override
    public List<Map<String, Object>> buscarPorQuery() {
        return catalogosService.innerJoinSiniestroCliente();
    }

    @Override
    public int postMethodName(@RequestBody SiniestroDto newSiniestro) {
        return catalogosService.insertarSiniestroinsertarSiniestro(newSiniestro.getIdSiniestro(),
                newSiniestro.getFechaSiniestro(), newSiniestro.getCausas(), newSiniestro.getAceptado(),
                newSiniestro.getIndermizacion(), newSiniestro.getPerito().getDniPerito(),
                newSiniestro.getSeguro().getNumeroPoliza());
    }

    @Override
    public void putMethodName(@RequestBody SiniestroDto newSiniestro) {
        catalogosService.actualizarSiniestro(newSiniestro.getIdSiniestro(), newSiniestro.getCausas());
    }

    @Override
    public int deleteMethodName(@PathVariable("idSiniestro") int idSiniestro) {
        return catalogosService.eliminarSiniestro(idSiniestro);
    }
}
