package com.falpema.utils;

import java.io.Serializable;

import org.springframework.stereotype.Component;



/**
 * Objeto de respuesta para servicios Rest
 * 
 * @author falpema
 * @param <T> Objeto de respuesta
 *
 */
@Component
public class GenericResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer status;
	private String message;
	private T object;

	public Integer getStatus() {
		if (status == null) {
			status = ParametersApp.SUCCESSFUL.value();
		}
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		if (message == null) {
			if (status != null) {
				message = ParametersApp.resolve(status).getReasonPhrase();
			}
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

}
