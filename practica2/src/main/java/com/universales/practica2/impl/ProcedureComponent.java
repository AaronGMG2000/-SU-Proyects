package com.universales.practica2.impl;

import com.universales.practica2.dto.ProcedimientoDto;
import com.universales.practica2.dto.SeguroDto;
import com.universales.practica2.service.ProcedureService;
import com.universales.practica2.ws.ProcedureServiceInt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ProcedureComponent implements ProcedureServiceInt {

    @Autowired
    ProcedureService procedureService;

    private static final Log LOG = LogFactory.getLog(ProcedureComponent.class);
    
    @Override
    public ResponseEntity<ProcedimientoDto> guardarSeguro(@RequestBody SeguroDto newSeguro) {
        try {
            return ResponseEntity.ok().body(procedureService.guardarSeguro(newSeguro));
    	}catch (Exception e) {
    		LOG.error("ERROR EN LA PERSISTENCIA DE DATOS" + e);
    		return ResponseEntity.internalServerError().body(null);
		}
    }

    @Override
    public void eliminarSeguro(@PathVariable int id) {
        procedureService.eliminarSeguro(id);
    }

    @Override
    public ResponseEntity<Integer> guardarSeguroPackage(SeguroDto newSeguro) {
    	try {
            return ResponseEntity.ok().body(procedureService.guardarSeguroPackage(newSeguro));
    	}catch (Exception e) {
    		LOG.error("ERROR EN LA PERSISTENCIA DE DATOS" + e);
    		return ResponseEntity.internalServerError().body(null);
		}
    }

}
