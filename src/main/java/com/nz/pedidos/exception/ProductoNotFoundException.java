package com.nz.pedidos.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8369001700139710612L;

	public ProductoNotFoundException(UUID id) {
		super("Producto no encontrado");
	}
}
