package com.nz.pedidos.component.impl;


import org.springframework.stereotype.Component;

import com.nz.pedidos.component.ICalcularTotal;
import com.nz.pedidos.entity.Pedido;

@Component
public class CalcularTotalImpl implements ICalcularTotal {

    private static final Double DESCUENTO = 30.0;
    private static final int CANTIDAD_ART = 3;

    @Override
    public void calcularTotal(Pedido pedido) {

       int cantArticulosPedido = pedido.getPedidosDetalle().stream()
    		   .map(detallePedido -> detallePedido.getCantidad())
    		   .mapToInt(num->num)
    		   .sum();
       
       Double totalPedido = pedido.getPedidosDetalle().stream()
    		   .map(detallePedido -> detallePedido.getPrecioUnitario())
    		   .mapToDouble(num->num)
    		   .sum();
       
       if(cantArticulosPedido > CANTIDAD_ART) {
    	   totalPedido = ((100 - DESCUENTO)/100)*totalPedido;
    	   pedido.setDescuento(true);
       }
       pedido.setMontoTotal(totalPedido);
    }
}
