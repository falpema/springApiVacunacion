package com.falpema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.falpema.entities.TEmpleado;


@Repository
public interface TEmpleadoRepository extends JpaRepository <TEmpleado,String>{
	public Optional<List<TEmpleado>> findAllByempDescripcion(String empDescripcion);
	
	@Query("Select u.apellidos FROM TEmpleado u")
	public Page<String> findTEmpleadoApellidos(Pageable page);
}
