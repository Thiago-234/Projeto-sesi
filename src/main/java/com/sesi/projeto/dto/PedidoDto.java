package com.sesi.projeto.dto;

import java.time.Instant;

import com.sesi.projeto.entities.StatusDoPedido;

public record PedidoDto (Instant momento, StatusDoPedido Status){

}
