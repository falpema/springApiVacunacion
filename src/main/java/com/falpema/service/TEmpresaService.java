package com.falpema.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.falpema.go.entities.TEmpresa;
import com.falpema.go.repository.TEmpresaRepository;
import com.falpema.utils.GenericResponse;
import com.falpema.utils.ParametersApp;

@Service
public class TEmpresaService {

	@Autowired
	private TEmpresaRepository repoEmpresa;

	public GenericResponse<Page<TEmpresa>> getListEmpresa(int page, int size) {
		GenericResponse<Page<TEmpresa>> respt = new GenericResponse<>();
		respt.setStatus(2);
		respt.setMessage("ENVIADO");

		System.out.println(ParametersApp.SUCCESSFUL);
		repoEmpresa.findAll(PageRequest.of(page, size));
		respt.setObject(repoEmpresa.findAll(PageRequest.of(page, size)));
		return respt;
	}

	public GenericResponse<Page<String>> getListDescripcion(int page, int size) {
		GenericResponse<Page<String>> respt = new GenericResponse<>();
		respt.setStatus(2);
		respt.setMessage("ENVIADO");

		System.out.println(ParametersApp.SUCCESSFUL);
		repoEmpresa.findAll(PageRequest.of(page, size));
		respt.setObject(repoEmpresa.findTEmpresaempDescripcion(PageRequest.of(page, size)));
		return respt;
	}
	
	public GenericResponse<TEmpresa> getEmpresa(int codEmpresa) {
		GenericResponse<TEmpresa> respt = new GenericResponse<>();

		Optional<TEmpresa> empresa;
		try {
			empresa = repoEmpresa.findById(codEmpresa);
			respt.setStatus(1);
			respt.setObject(empresa.get());
		} catch (NoSuchElementException e) {
			respt.setStatus(0);
			return respt;
		}
		return respt;
	}
	
	public GenericResponse<TEmpresa> saveEmpresa(TEmpresa empresa){
		GenericResponse<TEmpresa> respt = new GenericResponse<>();
		
		try {
			repoEmpresa.save(empresa);
			respt.setStatus(ParametersApp.SUCCESSFUL.value());
			respt.setObject(empresa);
			return respt	;
		} catch (Exception e) {
			respt.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			respt.setMessage(String.format("Error en proceso: %s", e.getCause()));
		}
		return respt;
	}
	public GenericResponse<List<TEmpresa>> findEmpresaDescripcion(String descripcion){
		GenericResponse<List<TEmpresa>> respt = new GenericResponse<>();
		Optional<List<TEmpresa>> empresa = null;

		try {
			respt.setStatus(ParametersApp.SUCCESSFUL.value());
			empresa = repoEmpresa.findAllByempDescripcion(descripcion);
			respt.setObject(empresa.get());
			return respt;
		} catch (Exception e) {
			respt.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			respt.setMessage(String.format("Error en proceso: %s", e.getCause()));
		}
		return respt;
	}
	

}
