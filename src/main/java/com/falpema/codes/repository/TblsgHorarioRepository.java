package com.falpema.codes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falpema.codes.entities.TblsgHorario;
import com.falpema.codes.entities.TblsgHorarioPK;

@Repository
public interface TblsgHorarioRepository extends JpaRepository<TblsgHorario, TblsgHorarioPK>{
}

