package com.falpema.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.falpema.entities.TEmpleado;
import com.falpema.repository.TEmpleadoRepository;
import com.falpema.utils.GenericResponse;
import com.falpema.utils.ParametersApp;


@Service
public class TEmpleadoService {
	
	private static final Logger log = LoggerFactory.getLogger(TEmpleadoService.class);
	
	@Autowired
	private TEmpleadoRepository repoEmpleado;
	
	public GenericResponse<TEmpleado> saveEmpleado(TEmpleado empleado){
		GenericResponse<TEmpleado> respt = new GenericResponse<>();
		
		try {
			repoEmpleado.save(empleado);
			respt.setStatus(ParametersApp.SUCCESSFUL.value());
			respt.setObject(empleado);
			return respt	;
		} catch (Exception e) {
			respt.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			respt.setMessage(String.format("Error en proceso: %s", e.getCause()));
		}
		return respt;
	}
	
	public GenericResponse<Page<TEmpleado>> getListEmpleado(int page, int size) {
		GenericResponse<Page<TEmpleado>> respt = new GenericResponse<>();
		respt.setStatus(2);
		respt.setMessage("ENVIADO");

		log.info(String.valueOf(ParametersApp.SUCCESSFUL));
		repoEmpleado.findAll(PageRequest.of(page, size));
		respt.setObject(repoEmpleado.findAll(PageRequest.of(page, size)));
		return respt;
	}
	
	public GenericResponse<TEmpleado> getEmpleado(String cedulaEmpleado) {
		GenericResponse<TEmpleado> respt = new GenericResponse<>();

		Optional<TEmpleado> empresa;
		try {
			empresa = repoEmpleado.findById(cedulaEmpleado);
			respt.setStatus(1);
			respt.setObject(empresa.get());
		} catch (NoSuchElementException e) {
			respt.setStatus(0);
			return respt;
		}
		return respt;
	}
}
