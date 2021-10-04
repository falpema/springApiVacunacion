package com.falpema.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.falpema.entities.TEmpleadoVacuna;
import com.falpema.entities.TEmpleadoVacunaPK;
import com.falpema.repository.TEmpleadoVacunaRepository;
import com.falpema.utils.GenericResponse;
import com.falpema.utils.ParametersApp;

@Service
public class TEmpleadoVacunaService {
	private static final Logger log = LoggerFactory.getLogger(TEmpleadoVacunaService.class);

  @Autowired
  private TEmpleadoVacunaRepository empleadoRep ;
  
	public GenericResponse<TEmpleadoVacuna> saveEmpleadoVacuna(TEmpleadoVacuna empleadoVacuna){
		GenericResponse<TEmpleadoVacuna> respt = new GenericResponse<>();
		
		try {
			empleadoRep.save(empleadoVacuna);
			respt.setStatus(ParametersApp.SUCCESSFUL.value());
			respt.setObject(empleadoVacuna);
			return respt	;
		} catch (Exception e) {
			respt.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			respt.setMessage(String.format("Error en proceso: %s", e.getCause()));
		}
		return respt;
	}
	
	public GenericResponse<TEmpleadoVacuna> getEmpleadoVacuna(TEmpleadoVacunaPK empleVacunaPK) {
		GenericResponse<TEmpleadoVacuna> respt = new GenericResponse<>();

		Optional<TEmpleadoVacuna> empleVacuna;
		try {
			empleVacuna = empleadoRep.findById(empleVacunaPK);
			respt.setStatus(1);
			respt.setObject(empleVacuna.get());
		} catch (NoSuchElementException e) {
			respt.setStatus(0);
			return respt;
		}
		return respt;
	}
	
	public GenericResponse<List<TEmpleadoVacuna>> getLsEmpleadoVacuna(String cedEmpleado) {
		GenericResponse<List<TEmpleadoVacuna>> respt = new GenericResponse<>();

		Optional<List<TEmpleadoVacuna>> lsEmpleVacuna;
		try {
			lsEmpleVacuna = empleadoRep.findAllByempleado(cedEmpleado) ;
			respt.setStatus(1);
			respt.setObject(lsEmpleVacuna.get());
		} catch (NoSuchElementException e) {
			respt.setStatus(0);
			return respt;
		}
		return respt;
	}
	
}
