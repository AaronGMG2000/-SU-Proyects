package com.universales.practica2.service;

import java.util.List;
import java.util.Optional;

import com.universales.practica2.entity.Perito;
import com.universales.practica2.repository.PeritoRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/buscar")
    public List<Perito> buscar() {
        return peritoRepository.findAll();
    }

    @PostMapping(value = "/guardar")
    public Perito guardar(@RequestBody Perito perito) {
        return peritoRepository.save(perito);
    }

    @PutMapping(value = "/actualizar")
    public Perito actualizar(@RequestBody Perito perito) {
        return peritoRepository.save(perito);
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
}
