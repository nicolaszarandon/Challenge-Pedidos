package com.nz.pedidos.dto.converter;

import org.springframework.stereotype.Component;

import com.nz.pedidos.dto.ProductoDto;
import com.nz.pedidos.entity.Producto;

@Component
public class ProductoDtoConverter {
	
	public ProductoDto toDto(Producto producto) {
		ProductoDto productoDto= new ProductoDto();
		productoDto.setId(producto.getId());
		productoDto.setNombre(producto.getNombre());
		productoDto.setDescripcionCorta(producto.getDescripcionCorta());
		productoDto.setDescripcionLarga(producto.getDescripcionLarga());
		productoDto.setPrecioUnitario(producto.getPrecioUnitario());
		return productoDto;
	}

}
