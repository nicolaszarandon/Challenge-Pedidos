package com.nz.pedidos.query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.nz.pedidos.dto.PedidoDetalleDto;
import com.nz.pedidos.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoQuery {

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String direccion;
	
	private String email;
	
	private String telefono;
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm")
	private LocalTime horario;
	
	List<PedidoDetalleDto> detalle;
	
	private Double total;
	
	private boolean descuento;
	
	private Estado estado;
}
