package com.universales.practica2.impl;

import java.util.List;
import java.util.Optional;

import com.universales.practica2.dto.PeritoDto;
import com.universales.practica2.entity.Perito;
import com.universales.practica2.repository.PeritoRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/perito")
@CrossOrigin
public class PeritoService {
    @Autowired
    PeritoRepository peritoRepository;
    
    private static final Log LOG = LogFactory.getLog(PeritoService.class);

    @GetMapping(value = "/buscar")
    public List<Perito> buscar() {
        return peritoRepository.findAll();
    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<Perito> guardar(@RequestBody PeritoDto newPerito) {
        Perito perito = this.nuevoPerito(newPerito);
        try {
            return ResponseEntity.ok().body(peritoRepository.save(perito));
    	}catch (Exception e) {
    		LOG.error("ERROR EN LA PERSISTENCIA DE DATOS" + e);
    		return ResponseEntity.internalServerError().body(null);
		}
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Perito> actualizar(@RequestBody PeritoDto newPerito) {
        return this.guardar(newPerito);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id) {
        Optional<Perito> perito = peritoRepository.findById(id);
        if (perito.isPresent()) {
            peritoRepository.delete(perito.get());
        }
    }

    @GetMapping(value = "/buscar/Nombre/{apellido}")
    public List<Perito> buscarPorApellido(@PathVariable("apellido") String apellido) {
        return peritoRepository.findByNombrePeritoStartingWith(apellido);
    }

    @GetMapping(value = "/buscar/Apellido/No/{apellido}")
    public List<Perito> buscarPorApellidoNo(@PathVariable("apellido") String apellido) {
        return peritoRepository.findByApellidoPerito1NotContaining(apellido);
    }

    public Perito nuevoPerito(PeritoDto newPerito) {
        ModelMapper mp = new ModelMapper();
        return mp.map(newPerito, Perito.class);
    }

}
