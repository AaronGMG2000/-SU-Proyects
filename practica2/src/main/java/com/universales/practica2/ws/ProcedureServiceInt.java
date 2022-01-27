package com.universales.practica2.ws;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.test.ProcedimientoDto;
import com.library.dto.test.SeguroDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/procedure")
@CrossOrigin
public interface ProcedureServiceInt {

    @PostMapping(value = "guardar/seguro")
    public ProcedimientoDto guardarSeguro(@RequestBody SeguroDto newSeguro);

    @GetMapping(value = "eliminar/seguro/{id}")
    public void eliminarSeguro(@PathVariable int id);

    @PostMapping(value = "guardar/seguro/package")
    public int guardarSeguroPackage(@RequestBody SeguroDto newSeguro);
}
