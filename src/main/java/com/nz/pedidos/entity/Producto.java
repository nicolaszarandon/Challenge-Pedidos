package com.nz.pedidos.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	@Id
	private UUID id;
	
	@Column(name = "nombre")
	private String nombre;
	@Column(name="descripcion_corta")
	private String descripcionCorta;
	@Column(name="descripcion_larga")
	private String descripcionLarga;
	@Column(name="precio_unitario")
	private Double precioUnitario;
}
