package com.nz.pedidos.services;

import java.util.List;
import java.util.UUID;

import com.nz.pedidos.dto.ProductoDto;
import com.nz.pedidos.entity.Producto;

public interface IProductoService {
	
	List<ProductoDto> findAll();
	ProductoDto findById(UUID id);
	ProductoDto save(Producto producto);
	ProductoDto update(Producto producto, UUID id);
	void deleteById(UUID id);

}
