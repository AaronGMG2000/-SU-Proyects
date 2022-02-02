package com.universales.practica2.impl;

import java.util.List;
import java.util.Optional;

import com.library.dto.test.CompaniaSeguroDto;
import com.universales.practica2.entity.CompaniaSeguro;
import com.universales.practica2.repository.CompaniaSeguroRepository;

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
    public CompaniaSeguro guardar(@RequestBody CompaniaSeguroDto newCompaniaSeguro) {
        CompaniaSeguro companiaSeguro = this.nuevaCompaniaSeguro(newCompaniaSeguro);
        return companiaSeguroRepository.save(companiaSeguro);
    }

    @PutMapping("/actualizar")
    public CompaniaSeguro actualizar(@RequestBody CompaniaSeguroDto newCompaniaSeguro) {
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
        CompaniaSeguro companiaSeguro = mp.map(newCompaniaSeguroDto, CompaniaSeguro.class);
        return companiaSeguro;
    }

}
