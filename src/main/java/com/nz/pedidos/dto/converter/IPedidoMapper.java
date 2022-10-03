package com.nz.pedidos.dto.converter;

import org.mapstruct.Mapper;

import com.nz.pedidos.dto.PedidoDto;
import com.nz.pedidos.query.PedidoQuery;

@Mapper(componentModel = "spring" )
public interface IPedidoMapper {	
	
	PedidoDto toPedidoDto(PedidoQuery pedidoQuery);

}
