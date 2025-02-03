package com.sesi.projeto.entities;

import java.time.Instant;
import com.sesi.projeto.dto.PedidoDto;
import ch.qos.logback.core.status.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private Status StatusDoPedido;
	
	
	public Pedido(PedidoDto dto) {
		this.momento =dto.momento();
		this.StatusDoPedido =dto.StatusDoPedido();
	}
	
	public Pedido(Long id, Instant momento, Status statusDoPedido) {
		super();
		this.id = id;
		this.momento = momento;
		StatusDoPedido = statusDoPedido;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMomento() {
		return momento;
	}
	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	public Status getStatusDoPedido() {
		return StatusDoPedido;
	}
	public void setStatusDoPedido(Status statusDoPedido) {
		StatusDoPedido = statusDoPedido;
	}
}
