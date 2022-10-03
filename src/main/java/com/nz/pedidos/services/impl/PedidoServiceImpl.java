package com.nz.pedidos.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nz.pedidos.component.ICalcularTotal;
import com.nz.pedidos.dto.PedidoDetalleDto;
import com.nz.pedidos.dto.PedidoDto;
import com.nz.pedidos.dto.converter.IPedidoMapper;
import com.nz.pedidos.dto.converter.PedidoDetalleDtoConverter;
import com.nz.pedidos.dto.converter.PedidoDtoConverter;
import com.nz.pedidos.entity.Pedido;
import com.nz.pedidos.entity.PedidoDetalle;
import com.nz.pedidos.entity.Producto;
import com.nz.pedidos.enums.Estado;
import com.nz.pedidos.exception.ProductoNotFoundException;
import com.nz.pedidos.query.PedidoQuery;
import com.nz.pedidos.repository.IPedidoRepository;
import com.nz.pedidos.repository.IProductoRepository;
import com.nz.pedidos.services.IPedidoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements IPedidoService {
	
	private final IPedidoRepository pedidoRepository;
	private final PedidoDtoConverter pedidoDtoConverter;
	private final IProductoRepository productoRepository;
	private final PedidoDetalleDtoConverter pedidoDetalleDtoConverter;
	private final ICalcularTotal calcularTotal;
	private final IPedidoMapper pedidoMapper;

	@Override
	@Transactional
	public PedidoDto crearPedido(PedidoQuery pedidoQuery) {
		PedidoDto pedidoDto = pedidoMapper.toPedidoDto(pedidoQuery);
		Pedido pedido = pedidoDtoConverter.dtoToPedido(pedidoDto);
        pedido.setEstado(Estado.PENDIENTE);
        pedido.setFechaAlta( LocalDate.now() );

		List<PedidoDetalle> pedidoDetalle = armarPedidoDetalle(pedidoDto.getDetalle(), pedido);
		pedido.setPedidosDetalle(pedidoDetalle);

		calcularTotal.calcularTotal(pedido);
		pedidoRepository.save(pedido);

		PedidoDto respuesta = pedidoDtoConverter.toDto(pedido);
		List<PedidoDetalleDto> detalles = pedido.getPedidosDetalle().stream().map(pedidoDetalleDtoConverter::toDto)
				.collect(Collectors.toList());
		respuesta.setDetalle(detalles);
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PedidoDto> listarPedidoPorFecha(LocalDate fecha) {
		List<Pedido> pedidos = pedidoRepository.findByFechaAlta(fecha);
		if (pedidos.isEmpty()) {
			return new ArrayList<>();
		}

		return pedidos.stream().map(pedido -> {
			PedidoDto pedidoDto = pedidoDtoConverter.toDto(pedido);
			pedidoDto.setDetalle(pedido.getPedidosDetalle().stream().map(pedidoDetalleDtoConverter::toDto)
					.collect(Collectors.toList()));
			return pedidoDto;
		}).collect(Collectors.toList());

	}

	public List<PedidoDetalle> armarPedidoDetalle(List<PedidoDetalleDto> detalleDto, Pedido pedido) {
		List<PedidoDetalle> pedidoDetalle = new ArrayList<>();

		for (PedidoDetalleDto dto : detalleDto) {
			Producto producto = productoRepository.findById(dto.getProducto())
					.orElseThrow(() -> new ProductoNotFoundException(dto.getProducto()));
			pedidoDetalle.add(pedidoDetalleDtoConverter.toPedidoDetalle(dto, producto, pedido));

		}
		return pedidoDetalle;
	}
}
