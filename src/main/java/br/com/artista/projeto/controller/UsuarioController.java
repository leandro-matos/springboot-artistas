package br.com.artista.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.artista.projeto.dao.UsuarioDAO;
import br.com.artista.projeto.model.Usuario;

@CrossOrigin("*")
@RestController // Aceitar as requisições HTTP
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;
	
	// RETORNAR TODOS OS USUÁRIOS
	@GetMapping("/usuarios")
	public ResponseEntity<ArrayList<Usuario>> getAllUsers() {
		ArrayList<Usuario> lista = (ArrayList<Usuario>) dao.findAll();
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// RETORNAR APENAS UM USUÁRIO
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUserById(@PathVariable int id) {
		Usuario objeto = dao.findById(id).orElse(null);
		if (objeto == null ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(objeto);
		}
	}
	
	// MÉTODO VAI RECEBER DADOS
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
		Usuario logado = dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		if (logado == null) {
			return ResponseEntity.status(403).build();
		} else {
			return ResponseEntity.ok(logado);
		}
	}
	
	
}
