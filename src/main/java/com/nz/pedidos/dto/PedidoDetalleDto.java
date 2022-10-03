package com.nz.pedidos.dto;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalleDto {
	
	@NotNull(message = "Falta ingresar el producto")
	private UUID producto;
	
	private String nombre;
	@NotNull(message = "Falta ingresar la cantidad")
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
	private Integer cantidad;
	
	private Double importe;

}
