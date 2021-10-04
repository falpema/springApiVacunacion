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

import com.falpema.entities.TEmpleado;
import com.falpema.service.TEmpleadoService;
import com.falpema.utils.GenericResponse;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/empleado")
public class TEmpleadoController {
	
	@Autowired
	private TEmpleadoService empleadoService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/guardarEmpleado")
	public ResponseEntity<GenericResponse> guardarEmpleado(@RequestBody TEmpleado empleado) {
		return new ResponseEntity<GenericResponse>(empleadoService.saveEmpleado(empleado), HttpStatus.OK);
	}
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{findbyCedula}")
	@ApiOperation(value = "Obtener empleado por cedula", response = TEmpleado.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Consulta realizada con exito"),
			@ApiResponse(code = 204, message = "Consulta not realizada")})
	public ResponseEntity<GenericResponse> getEmpleadoByCedula(@PathVariable("cedula") String cedula) {
		return new ResponseEntity<GenericResponse>(empleadoService.getEmpleado(cedula), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping
	@Timed("get.empresaList") // usando metricas de prometheus. Se puede utilizar para escalar aplicaciones
	public ResponseEntity<GenericResponse> getEmpleadoList(
			@RequestParam(required = false, value = "page", defaultValue = "0") int page,
			@RequestParam(required = false, value = "size", defaultValue = "10") int size) {
		return new ResponseEntity<GenericResponse>(empleadoService.getListEmpleado(page, size), HttpStatus.OK);
	}

}
