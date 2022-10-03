package com.nz.pedidos.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nz.pedidos.dto.ProductoDto;
import com.nz.pedidos.dto.converter.IProductoMapper;
import com.nz.pedidos.entity.Producto;
import com.nz.pedidos.exception.ProductoNotFoundException;
import com.nz.pedidos.repository.IProductoRepository;
import com.nz.pedidos.services.IProductoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService{
	
	private final IProductoRepository productoRepository;	
	private final IProductoMapper productoMapper;

	@Override
	public List<ProductoDto> findAll() {
		List<Producto> producto = productoRepository.findAll();
		return producto.stream().map(productoMapper::toDto)
						.collect(Collectors.toList());
				
	}

	@Override
	public ProductoDto findById(UUID id) {
		return productoRepository.findById(id)
				.map(productoMapper::toDto)				
				.orElseThrow(()->new ProductoNotFoundException(id));
		
	}

	@Override
	public ProductoDto save(Producto producto) {
		return productoMapper.toDto(productoRepository.save(producto));		
	}

	@Override
	public ProductoDto update(Producto producto, UUID id) {
		Producto update= productoRepository.findById(id).orElseThrow(()->new ProductoNotFoundException(id));
		update.setNombre(producto.getNombre());
		update.setDescripcionCorta(producto.getDescripcionCorta());
		update.setDescripcionLarga(producto.getDescripcionLarga());
		update.setPrecioUnitario(producto.getPrecioUnitario());
		return this.save(update);
	}

	@Override
	public void deleteById(UUID id) {
		 productoRepository.deleteById(id);
		
	}

}
