package com.nz.pedidos.services;

import java.time.LocalDate;
import java.util.List;

import com.nz.pedidos.dto.PedidoDto;
import com.nz.pedidos.query.PedidoQuery;

public interface IPedidoService {
	
	PedidoDto crearPedido(PedidoQuery pedidoQuery);
	List<PedidoDto> listarPedidoPorFecha(LocalDate fecha);
}
