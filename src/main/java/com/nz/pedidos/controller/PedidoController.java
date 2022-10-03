package com.nz.pedidos.controller;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nz.pedidos.dto.PedidoDto;
import com.nz.pedidos.query.PedidoQuery;
import com.nz.pedidos.services.IPedidoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {
	
	private final IPedidoService pedidoService;

	@PostMapping
	public ResponseEntity<?> crearPedido(@Valid @RequestBody PedidoQuery pedidoQuery) {
		
		PedidoDto nuevo = pedidoService.crearPedido(pedidoQuery);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
		
	}
	
	@GetMapping
	public ResponseEntity<?> listarPedidoPorFecha(@RequestParam(value = "fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate fecha) {
		
		List<PedidoDto> listDto = pedidoService.listarPedidoPorFecha(fecha);
		
		return ResponseEntity.status(HttpStatus.OK).body(listDto);
	}
}
