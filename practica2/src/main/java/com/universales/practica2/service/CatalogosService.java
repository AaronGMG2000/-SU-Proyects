package com.universales.practica2.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class CatalogosService {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> buscarSiniestros() {
        String query = "SELECT ID_SINIESTRO, FECHA_SINIESTRO, INDERMIZACION, DNI_PERITO, NUMERO_POLIZA FROM siniestro";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        return jdbcTemplate.queryForList(query, sqlParameterSource);
    }

    public List<Map<String, Object>> innerJoinSiniestroCliente() {
        String query = "select ID_SINIESTRO, C2.DNI_CL, NOMBRE_CL, concat(APELLIDO_1, concat(' ', APELLIDO_2)),"
                + " FECHA_SINIESTRO, CAUSAS, INDERMIZACION, S.NUMERO_POLIZA"
                + " from SINIESTROS"
                + " inner join SEGUROS S on SINIESTROS.NUMERO_POLIZA = S.NUMERO_POLIZA"
                + " inner join CLIENTES C2 on S.DNI_CL = C2.DNI_CL";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        return jdbcTemplate.queryForList(query, sqlParameterSource);
    }

    public void actualizarSiniestro(Integer idSiniestro, String causa) {
        String query = "UPDATE SINIESTROS SET CAUSAS = :causa WHERE ID_SINIESTRO = :idSiniestro1";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("idSiniestro1", idSiniestro)
                .addValue("causa", causa);
        jdbcTemplate.update(query, sqlParameterSource);
    }

    public int insertarSiniestroinsertarSiniestro(Integer idSiniestro, Date fechaSiniestro, String causas,
            String aceptado, String indermizacion, Integer dniPerito, Integer numeroPoliza) {
        String query = "INSERT INTO SINIESTROS (ID_SINIESTRO, FECHA_SINIESTRO, CAUSAS, ACEPTADO, INDERMIZACION, DNI_PERITO, NUMERO_POLIZA) "
                + "VALUES (:idSiniestro, :fechaSiniestro, :causas, :aceptado, :indermizacion, :dniPerito, :numeroPoliza)";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("idSiniestro", idSiniestro)
                .addValue("fechaSiniestro", fechaSiniestro)
                .addValue("causas", causas)
                .addValue("aceptado", aceptado)
                .addValue("indermizacion", indermizacion)
                .addValue("dniPerito", dniPerito)
                .addValue("numeroPoliza", numeroPoliza);
        return jdbcTemplate.update(query, sqlParameterSource);
    }

    public int eliminarSiniestro(Integer idSiniestro) {
        String query = "DELETE FROM SINIESTROS WHERE ID_SINIESTRO = :idSiniestro";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("idSiniestro", idSiniestro);
        return jdbcTemplate.update(query, sqlParameterSource);
    }

}
