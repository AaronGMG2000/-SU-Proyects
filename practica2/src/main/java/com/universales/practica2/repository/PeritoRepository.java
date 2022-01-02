package com.universales.practica2.repository;

import java.io.Serializable;
import java.util.List;

import com.universales.practica2.entity.Perito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("peritoRepository")
public interface PeritoRepository extends JpaRepository<Perito, Serializable> {

    public List<Perito> findByNombrePeritoStartingWith(String nombrePerito);

    public List<Perito> findByApellidoPerito1NotContaining(String apellidoPerito);
}
