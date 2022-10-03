package com.nz.pedidos.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
	
	private UUID id;
	private String nombre;
	private String descripcionCorta;
	private String descripcionLarga;
	private Double precioUnitario;

}
