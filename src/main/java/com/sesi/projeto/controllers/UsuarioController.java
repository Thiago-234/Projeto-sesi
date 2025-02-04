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

import com.sesi.projeto.dto.UsuarioDto;
import com.sesi.projeto.entities.Usuario;
import com.sesi.projeto.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repo;
	
	@Autowired
	UsuarioDto dto;
	
	@GetMapping(value = "/all")
	public ResponseEntity <List<Usuario>> mostrarTodos(){
		List<Usuario> usuario = repo.findAll();
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPorId(@RequestBody Long id){
		Usuario usuario = repo.getById(id);
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Usuario> registrarUsuario(Long id){
		Usuario usuario = new Usuario(dto);
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deletarUsuario(Long id) {
		repo.deleteById(id);
		return"Usuario deletado com sucesso!";
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Usuario updateItem(Long id, Usuario usuarioAtualizado) {
		Usuario usuario = repo.findById(id).get();
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setEmail(usuarioAtualizado.getEmail());
		usuario.setSenha(usuarioAtualizado.getSenha());
		usuario.setTelefone(usuarioAtualizado.getTelefone());
		usuario.setRoles(usuarioAtualizado.getRoles());
		
		return repo.save(usuario);
	}
}

