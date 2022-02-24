package com.universales.practica2.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universales.practica2.dto.ProcedimientoDto;
import com.universales.practica2.dto.SeguroDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/procedure")
@CrossOrigin
public interface ProcedureServiceInt {

    @PostMapping(value = "guardar/seguro")
    public ResponseEntity<ProcedimientoDto> guardarSeguro(@RequestBody SeguroDto newSeguro);

    @GetMapping(value = "eliminar/seguro/{id}")
    public void eliminarSeguro(@PathVariable int id);

    @PostMapping(value = "guardar/seguro/package")
    public ResponseEntity<Integer> guardarSeguroPackage(@RequestBody SeguroDto newSeguro);
}
