package com.falpema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.falpema.entities.TEmpresa;
import com.falpema.service.TEmpresaService;
import com.falpema.utils.GenericResponse;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/empresa")
public class TEmpresaCotroller {

	@Autowired
	private TEmpresaService empresaService;

	@SuppressWarnings("rawtypes")
	@GetMapping
	@Timed("get.empresaList") // usando metricas de prometheus. Se puede utilizar para escalar aplicaciones
	public ResponseEntity<GenericResponse> getEmpresaList(
			@RequestParam(required = false, value = "page", defaultValue = "0") int page,
			@RequestParam(required = false, value = "size", defaultValue = "10") int size) {
		return new ResponseEntity<GenericResponse>(empresaService.getListEmpresa(page, size), HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{codigo}")
	@ApiOperation(value = "Obtener empresa por codigo", response = TEmpresa.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Consulta realizada con exito"),
			@ApiResponse(code = 204, message = "Consulta not realizada")})
	public ResponseEntity<GenericResponse> getUserByCodigo(@PathVariable("codigo") int codigo) {
		return new ResponseEntity<GenericResponse>(empresaService.getEmpresa(codigo), HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity<GenericResponse> guardarEmpresa(@RequestBody TEmpresa empresa) {
		return new ResponseEntity<GenericResponse>(empresaService.saveEmpresa(empresa), HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/lista")
	public ResponseEntity<GenericResponse> getUsarios(
			@RequestParam(value = "descripcion", required = false) String descripcion) {
		return new ResponseEntity<GenericResponse>(empresaService.findEmpresaDescripcion(descripcion), HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/descripciones")
	public ResponseEntity<GenericResponse> getEmpresaDescripcion(
			@RequestParam(required = false, value = "page", defaultValue = "0") int page,
			@RequestParam(required = false, value = "size", defaultValue = "10") int size) {
		return new ResponseEntity<GenericResponse>(empresaService.getListDescripcion(page, size), HttpStatus.OK);
	}

}
