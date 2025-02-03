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

import com.sesi.projeto.dto.ItemDoPedidoDto;
import com.sesi.projeto.entities.ItemDoPedido;
import com.sesi.projeto.repositories.ItemDoPedidoRepository;

@RestController
@RequestMapping(value = "itens")
public class ItemDoPedidoController {
	
	@Autowired
	ItemDoPedidoRepository repo;
	
	@Autowired
	ItemDoPedidoDto dto;
	
	@GetMapping(value = "/all")
	public ResponseEntity <List<ItemDoPedido>> mostrarTodos(){
		List<ItemDoPedido> item = repo.findAll();
		return ResponseEntity.ok(item);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPorId(@RequestBody Long id){
		ItemDoPedido item = repo.getById(id);
		return ResponseEntity.ok(item);
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<ItemDoPedido> registrarItem(Long id){
		ItemDoPedido item = new ItemDoPedido(dto);
		return ResponseEntity.ok(item);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deletarItem(Long id) {
		repo.deleteById(id);
		return"Item deletada com sucesso!";
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public ItemDoPedido updateItem(Long id, ItemDoPedido itemAtualizado) {
		ItemDoPedido item = repo.findById(id).get();
		item.setQuantidade(itemAtualizado.getQuantidade());
		item.setPreco(itemAtualizado.getPreco());
		
		return repo.save(item);
	}
}
