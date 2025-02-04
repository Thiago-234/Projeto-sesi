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

import com.sesi.projeto.dto.CategoriaDto;
import com.sesi.projeto.entities.Categoria;
import com.sesi.projeto.entities.Pedido;
import com.sesi.projeto.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository repo;
	
	@Autowired
	CategoriaDto dto;
	
	@GetMapping(value = "/all")
	public ResponseEntity <List<Categoria>> mostrarTodos(){
		List<Categoria> cat = repo.findAll();
		return ResponseEntity.ok(cat);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPorId(@RequestBody Long id){
		Categoria cat = repo.getById(id);
		return ResponseEntity.ok(cat);
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Categoria> registrarProduto(Long id){
		Categoria cat = new Categoria(dto);
		return ResponseEntity.ok(cat);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deletarCategoria(Long id) {
		repo.deleteById(id);
		return"Categoria deletada com sucesso!";
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Categoria updateCategoria(Long id, Categoria categoriaAtualizado) {
		Categoria cat = repo.findById(id).get();
		cat.setNome(categoriaAtualizado.getNome());
		
		return repo.save(cat);
	}
}

