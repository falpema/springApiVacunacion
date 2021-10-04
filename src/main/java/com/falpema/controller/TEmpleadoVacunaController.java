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
import com.falpema.entities.TEmpleadoVacuna;
import com.falpema.entities.TEmpleadoVacunaPK;
import com.falpema.service.TEmpleadoVacunaService;
import com.falpema.utils.GenericResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/empleadoVacuna")
public class TEmpleadoVacunaController {
	
	@Autowired
	private TEmpleadoVacunaService empleadoVacService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/guardarEmpleadoVacuna")
	public ResponseEntity<GenericResponse> guardarEmpleadoVacuna(@RequestBody TEmpleadoVacuna empleadoVac) {
		return new ResponseEntity<GenericResponse>(empleadoVacService.saveEmpleadoVacuna(empleadoVac), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{findbyCedula}")
	@ApiOperation(value = "Obtener registro de las vacunas del empleado por cedula", response = TEmpleadoVacuna.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Consulta realizada con exito"),
			@ApiResponse(code = 204, message = "Consulta not realizada")})
	public ResponseEntity<GenericResponse> getLsEmpleadoVacunaByCedula(@PathVariable("cedula") String cedula) {
		return new ResponseEntity<GenericResponse>(empleadoVacService.getLsEmpleadoVacuna(cedula), HttpStatus.OK);
	}
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{findbyCedula}")
	@ApiOperation(value = "Obtener registro de las vacunas del empleado por cedula", response = TEmpleadoVacuna.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Consulta realizada con exito"),
			@ApiResponse(code = 204, message = "Consulta not realizada")})
	public ResponseEntity<GenericResponse> getEmpleadoVacunaByPk(@RequestBody TEmpleadoVacunaPK empleadoVacPK) {
		return new ResponseEntity<GenericResponse>(empleadoVacService.getEmpleadoVacuna(empleadoVacPK), HttpStatus.OK);
	}

}
