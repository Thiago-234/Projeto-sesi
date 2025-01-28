package com.sesi.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.projeto.dto.ProdutoDto;
import com.sesi.projeto.entities.Produto;
import com.sesi.projeto.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository repo;
	
	@Autowired
	ProdutoDto dto;
	
	@GetMapping
	public ResponseEntity <List<Produto>> mostrarTodos(){
		List<Produto> prod = repo.findAll();
		return ResponseEntity.ok(prod);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPorId(@RequestBody Long id){
		Produto prod = repo.getById(id);
		return ResponseEntity.ok(prod);
	}
	
	@PostMapping
	public ResponseEntity<Produto> registrarProduto(Long id){
		Produto prod = new Produto(dto);
		return ResponseEntity.ok(prod);
	}
	
}
