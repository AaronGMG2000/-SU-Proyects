package com.universales.practica2.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.universales.practica2.dto.SiniestroCantidadCiudadDto;
import com.universales.practica2.dto.SiniestroCantidadDto;
import com.universales.practica2.dto.SiniestroDto;
import com.universales.practica2.entity.Siniestro;
import com.universales.practica2.repository.SiniestroRepository;
import com.universales.practica2.service.CatalogosService;
import com.universales.practica2.ws.SiniestroServiceInt;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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
    
    private static final Log LOG = LogFactory.getLog(SiniestroService.class);

    @Override
    public ResponseEntity<Siniestro> guardar(SiniestroDto newSiniestro) {
    	Siniestro siniestro = this.nuevoSiniestro(newSiniestro);
        try {
        	return ResponseEntity.ok().body(siniestroRepository.save(siniestro));
        }catch (Exception e) {
        	LOG.error("HUBO UN ERROR EN PERSISTENCIA DE DATOS: "+ e);
        	return ResponseEntity.internalServerError().body(null);
        }
    }

    @Override
    public ResponseEntity<Siniestro> actualizar(SiniestroDto newSiniestro) {
        return this.guardar(newSiniestro);
    }

    @Override
    public void eliminar(int id) {
        Optional<Siniestro> siniestro = siniestroRepository.findById(id);
        if (siniestro.isPresent()) {
            siniestroRepository.delete(siniestro.get());
        }
    }

    @Override
    public List<Siniestro> buscarPorPerito(String indermizacion) {
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
    public List<Siniestro> buscarPorFechaDespues(Date fechaSiniestro) {
        return siniestroRepository.findAllByFechaSiniestroAfter(fechaSiniestro);
    }

    @Override
    public List<Siniestro> buscarPorFechaAntes(Date fechaSiniestro) {
        return siniestroRepository.findAllByFechaSiniestroBefore(fechaSiniestro);
    }

    private Siniestro nuevoSiniestro(SiniestroDto newSiniestro) {
        ModelMapper mp = new ModelMapper();
        return mp.map(newSiniestro, Siniestro.class);
    }
    

    @Override
    public List<Map<String, Object>> buscarPorQuery() {
        return catalogosService.innerJoinSiniestroCliente();
    }

    @Override
    public ResponseEntity<Integer> postMethodName(SiniestroDto newSiniestro) {
    	try {
        	return ResponseEntity.ok().body(
        			catalogosService.insertarSiniestroinsertarSiniestro(newSiniestro.getIdSiniestro(),
        	                newSiniestro.getFechaSiniestro(), newSiniestro.getCausas(), newSiniestro.getAceptado(),
        	                newSiniestro.getIndermizacion(), newSiniestro.getPerito().getDniPerito(),
        	                newSiniestro.getSeguro().getNumeroPoliza())
        			);
        }catch (Exception e) {
        	LOG.error("HUBO UN ERROR EN PERSISTENCIA DE DATOS: "+ e);
        	return ResponseEntity.internalServerError().body(null);
        }
    }

    @Override
    public void putMethodName(SiniestroDto newSiniestro) {
        catalogosService.actualizarSiniestro(newSiniestro.getIdSiniestro(), newSiniestro.getCausas());
    }

    @Override
    public int deleteMethodName(int idSiniestro) {
        return catalogosService.eliminarSiniestro(idSiniestro);
    }

	@Override
	public List<SiniestroCantidadDto> findSiniestroCantidad() {
		return siniestroRepository.findCountSiniestro();
	}

	@Override
	public List<SiniestroCantidadCiudadDto> findSiniestroCantidad(String ciudad) {
		return siniestroRepository.findCountSiniestroCiudad(ciudad);
	}
}
