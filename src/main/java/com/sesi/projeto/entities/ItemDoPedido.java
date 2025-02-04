package com.sesi.projeto.entities;

import com.sesi.projeto.dto.ItemDoPedidoDto;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ItemDoPedido")
public class ItemDoPedido {
	@EmbeddedId

	private ItemDoPedidoPK id = new ItemDoPedidoPK();
	private Integer quantidade;
	private Double preco;

	public ItemDoPedido(ItemDoPedidoDto dto) {
		this.quantidade = dto.quantidade();
		this.preco = dto.preco();
		}

	public ItemDoPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Pedido pedido) {
		id.setPedido(pedido);
	}
	
}
