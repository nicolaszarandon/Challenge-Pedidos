package com.nz.pedidos.dto.converter;

import org.mapstruct.Mapper;
import com.nz.pedidos.dto.ProductoDto;
import com.nz.pedidos.entity.Producto;

@Mapper(componentModel = "spring")
public interface IProductoMapper {
	
	ProductoDto toDto(Producto producto);

}
