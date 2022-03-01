package com.universales.practica2.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import com.universales.practica2.entity.Seguro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("seguroRepository")
public interface SeguroRepository extends JpaRepository<Seguro, Serializable> {

    public List<Seguro> findByCompaniasNotNull();

    public List<Seguro> findByFechaVencimiento(Date fechaVencimiento);

    public List<Seguro> findByFechaInicio(Date fecchaInicio);

    public List<Seguro> findByFechaInicioBetween(Date fechaInicio, Date fechaFin);

    public List<Seguro> findByFechaVencimientoBetween(Date fechaInicio, Date fechaFin);
    
    public List<Seguro> findByFechaVencimientoBefore(Date fechaVencimiento);
    
    
}
