package com.falpema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.falpema.codes.entities.TMoneda;
import com.falpema.codes.repository.TMonedaRepository;
import com.falpema.utils.GenericResponse;
import com.falpema.utils.ParametersApp;

@Repository
public class TMonedaService {
	@Autowired
	private TMonedaRepository repoMoneda;

	public GenericResponse<Page<TMoneda>> getListMoneda(int page, int size) {
		GenericResponse<Page<TMoneda>> respt = new GenericResponse<>();
		respt.setStatus(2);
		respt.setMessage("ENVIADO");

		System.out.println(ParametersApp.SUCCESSFUL);
		repoMoneda.findAll(PageRequest.of(page, size));
		respt.setObject(repoMoneda.findAll(PageRequest.of(page, size)));
		return respt;
	}


}
