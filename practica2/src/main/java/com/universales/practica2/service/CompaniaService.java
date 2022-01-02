package com.universales.practica2.service;

import java.util.List;
import java.util.Optional;

import com.universales.practica2.entity.Compania;
import com.universales.practica2.entity.Seguro;
import com.universales.practica2.repository.CompaniaRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/compania")
@CrossOrigin
public class CompaniaService {

    @Autowired
    CompaniaRepository companiaRepository;

    @GetMapping("/buscar")
    public List<Compania> buscar() {
        return companiaRepository.findAll();
    }

    @PostMapping("/guardar")
    public Compania guardar(@RequestBody Compania compania) {
        List<Seguro> seguros = compania.getSeguros();
        for (Seguro seguro : seguros) {
            seguro.getCompanias().add(compania);
        }
        return companiaRepository.save(compania);
    }

    @PutMapping("/actualizar")
    public Compania actualizar(@RequestBody Compania compania) {
        return this.guardar(compania);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id) {
        Optional<Compania> compania = companiaRepository.findById(id);
        if (compania.isPresent()) {
            companiaRepository.delete(compania.get());
        }
    }

    @GetMapping("/buscar/{id}")
    public List<Compania> buscar(@PathVariable("id") String id) {
        return companiaRepository.findByNombreCompania(id);
    }

    @GetMapping("/buscar/seguros")
    public List<Compania> buscarSeguros() {
        return companiaRepository.findDistinctBySegurosNotNull();
    }

    @GetMapping("/buscar/seguros/{id}")
    public List<Compania> buscarSeguros(@PathVariable("id") String id) {
        return companiaRepository.findDistinctByNombreCompaniaContainingAndSegurosNotNull(id);
    }

    @GetMapping("/buscar/numeroVia/{numeroVia}")
    public List<Compania> buscarNumeroVia(@PathVariable("numeroVia") int numeroVia) {
        return companiaRepository.findByNumeroViaIs(numeroVia);
    }

}
