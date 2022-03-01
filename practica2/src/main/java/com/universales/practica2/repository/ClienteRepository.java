package com.universales.practica2.repository;

import java.io.Serializable;
import java.util.List;

import com.universales.practica2.entity.Cliente;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {
    public List<Cliente> findByNombreCl(String nombreCl);

    public List<Cliente> findDistinctBySegurosListNotNull();

    public List<Cliente> findDistinctByNombreClContainingAndApellido1ContainingAndSegurosListNotNull(String nombreCl,
            String apellido1);

    public List<Cliente> findByCiudadOrCiudad(String ciudad1, String ciudad2);
    
    
    public Page<Cliente> findByApellido1(Pageable page, String apellido1);
    
    @Query(value = "SELECT * FROM CLIENTES WHERE ciudad LIKE %:ciudad% ORDER BY apellido_1 ASC", 
    		countQuery = "SELECT * FROM CLIENTES WHERE ciudad LIKE %:ciudad%", 
    		nativeQuery = true)
    public Page<Cliente> findByCiudad(Pageable paginacion ,String ciudad);
}
