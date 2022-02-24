package com.universales.practica2.impl;

import java.util.List;
import java.util.Optional;

import com.universales.practica2.dto.CompaniaSeguroDto;
import com.universales.practica2.entity.CompaniaSeguro;
import com.universales.practica2.repository.CompaniaSeguroRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companiaSeguro")
@CrossOrigin
public class CompaniaSeguroService {
    @Autowired
    private CompaniaSeguroRepository companiaSeguroRepository;

    private static final Log LOG = LogFactory.getLog(CompaniaSeguroService.class);
    
    @GetMapping("/buscar")
    public List<CompaniaSeguro> buscar() {
        return companiaSeguroRepository.findAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<CompaniaSeguro> guardar(@RequestBody CompaniaSeguroDto newCompaniaSeguro) {
        CompaniaSeguro companiaSeguro = this.nuevaCompaniaSeguro(newCompaniaSeguro);
        try {
            return ResponseEntity.ok().body(companiaSeguroRepository.save(companiaSeguro));
    	}catch (Exception e) {
    		LOG.error("ERROR EN LA PERSISTENCIA DE DATOS" + e);
    		return ResponseEntity.internalServerError().body(null);
		}
    }

    @PutMapping("/actualizar")
    public ResponseEntity<CompaniaSeguro> actualizar(@RequestBody CompaniaSeguroDto newCompaniaSeguro) {
        return this.guardar(newCompaniaSeguro);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id) {
        Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(id);
        if (companiaSeguro.isPresent()) {
            companiaSeguroRepository.delete(companiaSeguro.get());
        }
    }

    public CompaniaSeguro nuevaCompaniaSeguro(CompaniaSeguroDto newCompaniaSeguroDto) {
    	ModelMapper mp = new ModelMapper();
        return mp.map(newCompaniaSeguroDto, CompaniaSeguro.class);
    }

}
