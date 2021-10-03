package com.falpema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.falpema.service.TMonedaService;
import com.falpema.utils.GenericResponse;

@RestController
@RequestMapping("/moneda")
public class DataSourceCoral {
	@Autowired
	private TMonedaService modenaService;

	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity<GenericResponse> getMoneda(
			@RequestParam(required = false, value = "page", defaultValue = "0") int page,
			@RequestParam(required = false, value = "size", defaultValue = "10") int size) {
		return new ResponseEntity<GenericResponse>(modenaService.getListMoneda(page, size), HttpStatus.OK);
	}
}
