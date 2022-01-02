package com.universales.practica2.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.universales.practica2.entity.Siniestro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("siniestroRepository")
public interface SiniestroRepository extends JpaRepository<Siniestro, Serializable> {

    public List<Siniestro> findByIndermizacion(String indermizacion);

    public List<Siniestro> findBySeguroNotNullOrderByFechaSiniestroAsc();

    public List<Siniestro> findByPeritoNotNullOrderByFechaSiniestroDesc();

    public List<Siniestro> findAllByFechaSiniestroAfter(Date fechaSiniestro);

    public List<Siniestro> findAllByFechaSiniestroBefore(Date fechaSiniestro);

}
