package com.nz.pedidos.dto.converter;



import org.springframework.stereotype.Component;

import com.nz.pedidos.dto.PedidoDto;
import com.nz.pedidos.entity.Pedido;

@Component
public class PedidoDtoConverter {

	public PedidoDto toDto(Pedido pedido) {
		PedidoDto pedidoDto = new PedidoDto();
		pedidoDto.setDireccion(pedido.getDireccion());
		pedidoDto.setFecha(pedido.getFechaAlta());
		pedidoDto.setEmail(pedido.getEmail());
		pedidoDto.setTelefono(pedido.getTelefono());
		pedidoDto.setHorario(pedido.getHorario());
		pedidoDto.setTotal(pedido.getMontoTotal());
		pedidoDto.setDescuento(pedido.isDescuento());
		pedidoDto.setEstado(pedido.getEstado());		
		return pedidoDto;
		
	}
	
	public Pedido dtoToPedido(PedidoDto pedidoDto) {
		Pedido pedido= new Pedido();
		pedido.setHorario(pedidoDto.getHorario());
		pedido.setDireccion( pedidoDto.getDireccion() );
        pedido.setEmail( pedidoDto.getEmail() );
        pedido.setTelefono( pedidoDto.getTelefono() );
        pedido.setDescuento(false);
        return pedido;
    }
	
}
