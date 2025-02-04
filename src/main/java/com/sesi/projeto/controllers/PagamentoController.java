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
import com.sesi.projeto.dto.PagamentoDto;
import com.sesi.projeto.entities.Pagamento;
import com.sesi.projeto.repositories.PagamentoRepository;

@RestController
@RequestMapping(value = "pagamento")
public class PagamentoController {
	
	@Autowired
	PagamentoRepository repo;
	
	@Autowired
	PagamentoDto dto;
	
	@GetMapping(value = "/all")
	public ResponseEntity <List<Pagamento>> mostrarTodos(){
		List<Pagamento> pag = repo.findAll();
		return ResponseEntity.ok(pag);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPorId(@RequestBody Long id){
		Pagamento pag = repo.getById(id);
		return ResponseEntity.ok(pag);
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Pagamento> registrarPagamento(Long id){
		Pagamento pag = new Pagamento(dto);
		return ResponseEntity.ok(pag);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deletarPedido(Long id) {
		repo.deleteById(id);
		return"Pagamento deletado com sucesso!";
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Pagamento updatePagamento(Long id, Pagamento pagamentoAtualizado) {
		Pagamento pag = repo.findById(id).get();
		pag.setMomento(pagamentoAtualizado.getMomento());
		
		return repo.save(pag);
	}
}
