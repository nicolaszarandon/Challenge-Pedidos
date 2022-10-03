package com.nz.pedidos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nz.pedidos.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, UUID> {

}
