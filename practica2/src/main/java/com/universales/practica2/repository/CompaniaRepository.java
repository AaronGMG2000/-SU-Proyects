package com.universales.practica2.repository;

import java.io.Serializable;
import java.util.List;

import com.universales.practica2.entity.Compania;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("companiaRepository")
public interface CompaniaRepository extends JpaRepository<Compania, Serializable> {

    public List<Compania> findByNombreCompania(String nombreCompania);

    public List<Compania> findDistinctBySegurosNotNull();

    public List<Compania> findDistinctByNombreCompaniaContainingAndSegurosNotNull(String nombreCompania);

    public List<Compania> findByNumeroViaIs(int numeroVia);
}
