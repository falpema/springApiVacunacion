package com.falpema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.falpema.entities.TEmpleadoVacuna;
import com.falpema.entities.TEmpleadoVacunaPK;



@Repository
public interface TEmpleadoVacunaRepository extends JpaRepository <TEmpleadoVacuna,TEmpleadoVacunaPK>{
	
	@Query("Select u FROM TEmpleadoVacuna u where u.tEmpleadoVacunaPK.cedula= :cedula ")
	public Optional<List<TEmpleadoVacuna>> findAllByempleado(@Param("cedula") String cedula);
	
}
