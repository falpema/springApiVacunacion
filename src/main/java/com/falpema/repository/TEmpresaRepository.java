package com.falpema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.falpema.entities.TEmpresa;

@Repository
public interface TEmpresaRepository extends JpaRepository<TEmpresa, Integer>{

	public Optional<List<TEmpresa>> findAllByempDescripcion(String empDescripcion);
	
	@Query("Select u.empDescripcion FROM TEmpresa u")
	public Page<String> findTEmpresaempDescripcion(Pageable page);
	
}
