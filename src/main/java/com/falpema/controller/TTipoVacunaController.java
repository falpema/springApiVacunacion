package com.falpema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falpema.entities.TEmpleado;
import com.falpema.entities.TTipoVacuna;
import com.falpema.service.TTiposVacunaService;
import com.falpema.utils.GenericResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tipoVacuna")
public class TTipoVacunaController  {
	
	@Autowired
	private TTiposVacunaService tipVacunaService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/guardarTipoVacuna")
	public ResponseEntity<GenericResponse> guardarEmpleado(@RequestBody TTipoVacuna tipoVacuna) {
		return new ResponseEntity<GenericResponse>(tipVacunaService.saveTipoVacuna(tipoVacuna), HttpStatus.OK);
	}
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{findbyCodigo}")
	@ApiOperation(value = "Obtener tipo de vacuna por su codigo", response = TEmpleado.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Consulta realizada con exito"),
			@ApiResponse(code = 204, message = "Consulta not realizada")})
	public ResponseEntity<GenericResponse> getTipoVacunaByCodigo(@PathVariable("codigo") String codigo) {
		return new ResponseEntity<GenericResponse>(tipVacunaService.getTipoVacuna(codigo), HttpStatus.OK);
	}

}
