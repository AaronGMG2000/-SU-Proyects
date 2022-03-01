package com.universales.practica2.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.universales.practica2.dto.SiniestroCantidadCiudadDto;
import com.universales.practica2.dto.SiniestroCantidadDto;
import com.universales.practica2.entity.Siniestro;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("siniestroRepository")
public interface SiniestroRepository extends JpaRepository<Siniestro, Serializable> {

    public List<Siniestro> findByIndermizacion(String indermizacion);

    public List<Siniestro> findBySeguroNotNullOrderByFechaSiniestroAsc();

    public List<Siniestro> findByPeritoNotNullOrderByFechaSiniestroDesc();

    public List<Siniestro> findAllByFechaSiniestroAfter(Date fechaSiniestro);

    public List<Siniestro> findAllByFechaSiniestroBefore(Date fechaSiniestro);
    
    @Query(value = "SELECT new com.universales.practica2.dto.SiniestroCantidadDto(C2.nombreCl, C2.apellido1, C2.dniCl,"
    		+ " P.nombrePerito, P.apellidoPerito1, P.dniPerito, S2.numeroPoliza, S.indermizacion, count(1) as cantidad) FROM Siniestro S"
			+ " INNER JOIN Perito P on P.dniPerito = S.perito.dniPerito\r\n"
			+ " INNER JOIN Seguro S2 on S.seguro.numeroPoliza = S2.numeroPoliza\r\n"
			+ " INNER JOIN Cliente C2 on S2.dniCl = C2.dniCl\r\n"
			+ " GROUP BY C2.nombreCl, C2.apellido1, C2.dniCl, P.nombrePerito, P.apellidoPerito1, P.dniPerito, S2.numeroPoliza, S.indermizacion"
			+ " ORDER BY C2.nombreCl DESC")
    public List<SiniestroCantidadDto> findCountSiniestro();
    
    @Query(value = "SELECT new com.universales.practica2.dto.SiniestroCantidadCiudadDto(C2.nombreCl, C2.apellido1, C2.dniCl, C2.ciudad,"
    		+ " P.nombrePerito, P.apellidoPerito1, P.dniPerito, S2.numeroPoliza, S.indermizacion, count(1) as cantidad) FROM Siniestro S"
			+ " INNER JOIN Perito P on P.dniPerito = S.perito.dniPerito\r\n"
			+ " INNER JOIN Seguro S2 on S.seguro.numeroPoliza = S2.numeroPoliza\r\n"
			+ " INNER JOIN Cliente C2 on S2.dniCl = C2.dniCl\r\n"
			+ " where C2.ciudad LIKE %:ciudad%"
			+ " GROUP BY C2.nombreCl, C2.apellido1, C2.dniCl, C2.ciudad, P.nombrePerito, P.apellidoPerito1, P.dniPerito, S2.numeroPoliza, S.indermizacion"
			+ " ORDER BY C2.ciudad DESC")
    public List<SiniestroCantidadCiudadDto> findCountSiniestroCiudad(String ciudad);
}
