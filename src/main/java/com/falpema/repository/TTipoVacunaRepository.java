package com.falpema.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.falpema.entities.TTipoVacuna;

public interface TTipoVacunaRepository extends JpaRepository<TTipoVacuna, String> {
	
	@Query("Select u.descripcion FROM TTipoVacuna u")
	public Page<String> findTEmpleadoApellidos(Pageable page);

}
