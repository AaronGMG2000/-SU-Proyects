package com.universales.practica2.repository;

import java.io.Serializable;
import java.util.List;

import com.universales.practica2.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {
    public List<Cliente> findByNombreCl(String nombreCl);

    public List<Cliente> findDistinctBySegurosListNotNull();

    public List<Cliente> findDistinctByNombreClContainingAndApellido1ContainingAndSegurosListNotNull(String nombreCl,
            String apellido1);

    public List<Cliente> findByCiudadOrCiudad(String ciudad1, String ciudad2);
}
