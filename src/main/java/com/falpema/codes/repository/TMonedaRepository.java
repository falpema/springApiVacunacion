package com.falpema.codes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falpema.codes.entities.TMoneda;

@Repository
public interface TMonedaRepository extends JpaRepository<TMoneda, String>{
	
}
