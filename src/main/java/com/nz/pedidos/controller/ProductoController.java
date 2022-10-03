package com.nz.pedidos.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nz.pedidos.dto.ProductoDto;
import com.nz.pedidos.entity.Producto;
import com.nz.pedidos.services.impl.ProductoServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductoController {
	
	private final ProductoServiceImpl productoService;	
	
	@GetMapping
	public List<ProductoDto> obtenerTodos() {
		return productoService.findAll();
	}
	
	@GetMapping("/{id}")
	public ProductoDto obtenerProducto(@PathVariable UUID id) {
		return productoService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<ProductoDto> crearProducto(@RequestBody Producto producto) {
		productoService.save(producto);		
		return ResponseEntity.status(HttpStatus.CREATED).build(); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductoDto> editar(@RequestBody Producto producto, @PathVariable UUID id) {
		productoService.update(producto, id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrar(@PathVariable UUID id) {
		productoService.deleteById(id);
		return ResponseEntity.notFound().build();
	}

}
