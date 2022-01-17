package com.universales.practica2.service;

import java.sql.Types;
import java.util.Map;

import com.universales.practica2.dto.ProcedimientoDto;
import com.universales.practica2.dto.SeguroDto;

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

@Service
public class ProcedureService {

    private static String poliza = "poliza";
    private static String dniCln = "dni_clN";
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
                        new SqlParameter("ramoN", Types.VARCHAR),
                        new SqlParameter("fecha_inicioN", Types.DATE),
                        new SqlParameter("fecha_vencimientoN", Types.DATE),
                        new SqlParameter("condiciones_particularesN", Types.VARCHAR),
                        new SqlParameter("observacionesN", Types.VARCHAR),
                        new SqlInOutParameter(dniCln, Types.NUMERIC),
                        new SqlOutParameter("nombre_cliente", Types.VARCHAR));
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue(poliza, newSeguro.getNumeroPoliza())
                .addValue("ramoN", newSeguro.getRamo())
                .addValue("fecha_inicioN", newSeguro.getFechaInicio())
                .addValue("fecha_vencimientoN", newSeguro.getFechaVencimiento())
                .addValue("condiciones_particularesN", newSeguro.getCondicionesParticulares())
                .addValue("observacionesN", newSeguro.getObservaciones())
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
}
