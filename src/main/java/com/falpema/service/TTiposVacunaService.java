package com.falpema.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falpema.entities.TTipoVacuna;
import com.falpema.repository.TTipoVacunaRepository;
import com.falpema.utils.GenericResponse;
import com.falpema.utils.ParametersApp;

@Service
public class TTiposVacunaService  {
	private static final Logger log = LoggerFactory.getLogger(TTiposVacunaService.class);
	
	@Autowired
	private TTipoVacunaRepository tipVacRepo;
	
	public GenericResponse<TTipoVacuna> saveTipoVacuna(TTipoVacuna tipVac){
		GenericResponse<TTipoVacuna> respt = new GenericResponse<>();
		
		try {
			tipVacRepo.save(tipVac);
			respt.setStatus(ParametersApp.SUCCESSFUL.value());
			respt.setObject(tipVac);
			return respt	;
		} catch (Exception e) {
			respt.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			respt.setMessage(String.format("Error en proceso: %s", e.getCause()));
		}
		return respt;
	}
	
	public GenericResponse<TTipoVacuna> getTipoVacuna(String codigo) {
		GenericResponse<TTipoVacuna> respt = new GenericResponse<>();

		Optional<TTipoVacuna> tipVacuna;
		try {
			tipVacuna = tipVacRepo.findById(codigo);
			respt.setStatus(1);
			respt.setObject(tipVacuna.get());
		} catch (NoSuchElementException e) {
			respt.setStatus(0);
			return respt;
		}
		return respt;
	}
}
