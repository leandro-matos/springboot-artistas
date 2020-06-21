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

import br.com.artista.projeto.dao.MusicaDAO;
import br.com.artista.projeto.model.Musica;

@RestController
@CrossOrigin("*")
public class MusicaController {
	
	@Autowired
	private MusicaDAO dao;
	
	// RETORNAR TODOS AS MÚSICAS
	@GetMapping("/musicas")
	public ResponseEntity<ArrayList<Musica>> getAllMusicas() {
		ArrayList<Musica> lista = (ArrayList<Musica>) dao.findAll();
		if (lista.size() == 0 ) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	// RETORNAR APENAS UMA MÚSICA
	@GetMapping("/musicas/{codigo}")
	public ResponseEntity<Musica> getMusicaById(@PathVariable int codigo) {
		Musica objeto = dao.findById(codigo).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(objeto);
	}
	
	@PostMapping("musica/nova")
	public ResponseEntity<Musica> addMusica(@RequestBody Musica nova) {
		try {
			dao.save(nova);
			return ResponseEntity.ok(nova);
		}catch(Exception e) {
			return ResponseEntity.status(400).build();
		}
	}

}
