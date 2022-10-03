package com.nz.pedidos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nz.pedidos.entity.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido, UUID>{
	
	List<Pedido> findByFechaAlta(LocalDate fecha);

}
