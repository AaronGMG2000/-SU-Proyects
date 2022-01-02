package com.universales.practica2.repository;

import java.io.Serializable;

import com.universales.practica2.entity.CompaniaSeguro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("companiaSeguroRepository")
public interface CompaniaSeguroRepository extends JpaRepository<CompaniaSeguro, Serializable> {

}
