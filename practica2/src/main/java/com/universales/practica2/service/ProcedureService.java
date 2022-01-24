package com.universales.practica2.service;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.library.dt.TestDto.ProcedimientoDto;
import com.library.dt.TestDto.SeguroDto;

@Service
public class ProcedureService {

        private static String poliza = "poliza";
        private static String dniCln = "dni_clN";
        private static String ramoN = "ramoN";
        private static String fechaInicio = "fecha_inicioN";
        private static String condicionesParticulares = "condiciones_particularesN";
        private static String observaciones = "observacionesN";
        private static String nombreCliente = "nombre_cliente";
        private static String fechaVencimiento = "fecha_vencimientoN";

        @Autowired
        NamedParameterJdbcTemplate parameterJdbcTemplate;

        @Autowired
        JdbcTemplate jdbcTemplate;

        public ProcedimientoDto guardarSeguro(SeguroDto newSeguro) {
                SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
                simpleJdbcCall.withProcedureName("insertarSeguro")
                                // withCatalogName("catalogName").withSchemaName("schemaName")
                                .withoutProcedureColumnMetaDataAccess()
                                .declareParameters(
                                                new SqlInOutParameter(poliza, Types.NUMERIC),
                                                new SqlParameter(ramoN, Types.VARCHAR),
                                                new SqlParameter(fechaInicio, Types.DATE),
                                                new SqlParameter(fechaVencimiento, Types.DATE),
                                                new SqlParameter(condicionesParticulares, Types.VARCHAR),
                                                new SqlParameter(observaciones, Types.VARCHAR),
                                                new SqlInOutParameter(dniCln, Types.NUMERIC),
                                                new SqlOutParameter(nombreCliente, Types.VARCHAR));
                SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                                .addValue(poliza, newSeguro.getNumeroPoliza())
                                .addValue(ramoN, newSeguro.getRamo())
                                .addValue(fechaInicio, newSeguro.getFechaInicio())
                                .addValue(fechaVencimiento, newSeguro.getFechaVencimiento())
                                .addValue(condicionesParticulares, newSeguro.getCondicionesParticulares())
                                .addValue(observaciones, newSeguro.getObservaciones())
                                .addValue(dniCln, newSeguro.getDniCl());
                Map<String, Object> result = simpleJdbcCall.execute(sqlParameterSource);
                ProcedimientoDto procedimientoDto = new ProcedimientoDto();
                procedimientoDto.setDniCl(Integer.parseInt(result.get(dniCln).toString()));
                procedimientoDto.setNombreCl(result.get("nombre_cliente").toString());
                procedimientoDto.setNumeroPoliza(Integer.parseInt(result.get(poliza).toString()));
                return procedimientoDto;
        }

        public void eliminarSeguro(int idSeguro) {
                SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
                simpleJdbcCall.withProcedureName("eliminarSeguro").withoutProcedureColumnMetaDataAccess()
                                .declareParameters(new SqlParameter("id_seguro", Types.NUMERIC));
                SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                                .addValue("id_seguro", idSeguro);
                simpleJdbcCall.execute(sqlParameterSource);
        }

        public int guardarSeguroPackage(SeguroDto newSeguro) {
                SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
                simpleJdbcCall.withCatalogName("PAQUETE_POLIZA")// .withSchemaName("schemaName")
                                .withFunctionName("insertSeguroP");
                SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                                .addValue(poliza, newSeguro.getNumeroPoliza())
                                .addValue(ramoN, newSeguro.getRamo())
                                .addValue(fechaInicio, newSeguro.getFechaInicio())
                                .addValue(fechaVencimiento, newSeguro.getFechaVencimiento())
                                .addValue(condicionesParticulares, newSeguro.getCondicionesParticulares())
                                .addValue(observaciones, newSeguro.getObservaciones())
                                .addValue(dniCln, newSeguro.getDniCl());
                return simpleJdbcCall.executeFunction(BigDecimal.class, sqlParameterSource).intValue();
        }
}
