package com.universales.practica2.impl;

import com.library.dto.test.ProcedimientoDto;
import com.library.dto.test.SeguroDto;
import com.universales.practica2.service.ProcedureService;
import com.universales.practica2.ws.ProcedureServiceInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ProcedureComponent implements ProcedureServiceInt {

    @Autowired
    ProcedureService procedureService;

    @Override
    public ProcedimientoDto guardarSeguro(@RequestBody SeguroDto newSeguro) {
        return procedureService.guardarSeguro(newSeguro);
    }

    @Override
    public void eliminarSeguro(@PathVariable int id) {
        procedureService.eliminarSeguro(id);
    }

    @Override
    public int guardarSeguroPackage(SeguroDto newSeguro) {
        return procedureService.guardarSeguroPackage(newSeguro);
    }

}
