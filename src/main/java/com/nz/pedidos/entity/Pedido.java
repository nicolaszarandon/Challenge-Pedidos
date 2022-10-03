package com.nz.pedidos.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.nz.pedidos.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedido_cabecera")
public class Pedido {
	
	@Id@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "fecha_alta")
	private LocalDate fechaAlta;
	
	@NotNull(message = "La direccion no puede estar nula")
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "horario")
	private LocalTime horario;
	
	@Column(name = "monto_total")
	private Double montoTotal;
	
	@Column(name = "descuento")
	private boolean descuento;
	
	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	private Estado estado;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_cabecera_id")
	private List<PedidoDetalle> pedidosDetalle;
}
