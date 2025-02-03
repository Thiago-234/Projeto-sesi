package com.sesi.projeto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sesi.projeto.dto.PedidoDto;
import com.sesi.projeto.entities.Pedido;
import com.sesi.projeto.repositories.PedidoRepository;

@RestController
@RequestMapping(value = "pedido")
public class PedidoController {

	@Autowired
	PedidoRepository repo;
	
	@Autowired
	PedidoDto dto;
	
	@GetMapping(value = "/all")
	public ResponseEntity <List<Pedido>> mostrarTodos(){
		List<Pedido> ped = repo.findAll();
		return ResponseEntity.ok(ped);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPorId(@RequestBody Long id){
		Pedido ped = repo.getById(id);
		return ResponseEntity.ok(ped);
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Pedido> registrarProduto(Long id){
		Pedido ped = new Pedido(dto);
		return ResponseEntity.ok(ped);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deletarPedido(Long id) {
		repo.deleteById(id);
		return"Produto deletado com sucesso!";
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Pedido updatePedido(Long id, Pedido pedidoAtualizado) {
		Pedido ped = repo.findById(id).get();
		ped.setMomento(pedidoAtualizado.getMomento());
		ped.setStatusDoPedido(pedidoAtualizado.getStatusDoPedido());
		
		return repo.save(ped);
	}
}
