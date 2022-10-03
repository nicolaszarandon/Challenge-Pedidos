package com.nz.pedidos.dto.converter;


import org.springframework.stereotype.Component;

import com.nz.pedidos.dto.PedidoDetalleDto;
import com.nz.pedidos.entity.Pedido;
import com.nz.pedidos.entity.PedidoDetalle;
import com.nz.pedidos.entity.Producto;

@Component
public class PedidoDetalleDtoConverter {

    public PedidoDetalle toPedidoDetalle(PedidoDetalleDto pedidoDetalleDto, Producto producto, Pedido pedido ) {
        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setCantidad( pedidoDetalleDto.getCantidad() );
        pedidoDetalle.setProducto( producto );
        pedidoDetalle.setPedido( pedido );
        pedidoDetalle.setPrecioUnitario(
                producto.getPrecioUnitario().doubleValue() * pedidoDetalleDto.getCantidad().doubleValue() );
        return pedidoDetalle;
    }

    public PedidoDetalleDto toDto(PedidoDetalle pedidoDetalle) {
        PedidoDetalleDto pedidoDetalletDto = new PedidoDetalleDto();
        pedidoDetalletDto.setProducto( pedidoDetalle.getProducto().getId() );
        pedidoDetalletDto.setCantidad( pedidoDetalle.getCantidad() );
        pedidoDetalletDto.setImporte( pedidoDetalle.getPrecioUnitario() );
        pedidoDetalletDto.setNombre( pedidoDetalle.getProducto().getNombre() );
        return pedidoDetalletDto;
    }
}
