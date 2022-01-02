package com.universales.practica2.service;

import java.util.List;
import java.util.Optional;

import com.universales.practica2.entity.CompaniaSeguro;
import com.universales.practica2.repository.CompaniaSeguroRepository;

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
@RequestMapping("/companiaSeguro")
@CrossOrigin
public class CompaniaSeguroService {
    @Autowired
    private CompaniaSeguroRepository companiaSeguroRepository;

    @GetMapping("/buscar")
    public List<CompaniaSeguro> buscar() {
        return companiaSeguroRepository.findAll();
    }

    @PostMapping("/guardar")
    public CompaniaSeguro guardar(@RequestBody CompaniaSeguro companiaSeguro) {
        return companiaSeguroRepository.save(companiaSeguro);
    }

    @PutMapping("/actualizar")
    public CompaniaSeguro actualizar(@RequestBody CompaniaSeguro companiaSeguro) {
        return companiaSeguroRepository.save(companiaSeguro);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id) {
        Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(id);
        if (companiaSeguro.isPresent()) {
            companiaSeguroRepository.delete(companiaSeguro.get());
        }
    }

}
