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

import br.com.artista.projeto.dao.ArtistaDAO;
import br.com.artista.projeto.model.Artista;

@CrossOrigin("*")
@RestController
public class ArtistaController {

	@Autowired
	private ArtistaDAO dao;
	
	// RETORNAR TODOS OS ARTISTAS
	@GetMapping("/artistas")
	public ResponseEntity<ArrayList<Artista>> getAllArtistas() {
		ArrayList<Artista> lista = (ArrayList<Artista>) dao.findAll();
		if (lista.size() == 0 ) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	// RETORNAR APENAS UM ARTISTA
	@GetMapping("/artistas/{codigo}")
	public ResponseEntity<Artista> getArtistaById(@PathVariable int codigo) {
		Artista objeto = dao.findById(codigo).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(objeto);
	}
	
	// MÉTODO VAI RECEBER DADOS
	@GetMapping("/nacionalidade/{nacionalidade}")
	public ResponseEntity<ArrayList<Artista>> getArtistaNacionalidade(@PathVariable String nacionalidade) {
		ArrayList<Artista> lista = (ArrayList<Artista>) dao.findByNacionalidade(nacionalidade);
		if (lista == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	public boolean verificar(@RequestBody Artista novo) {
		Artista resposta = dao.findByNomeArtisticoAndNacionalidade(novo.getNomeArtistico(), novo.getNacionalidade());
		if (resposta != null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	@PostMapping("/artista/novo")
	public ResponseEntity<Artista> addArtista(@RequestBody Artista novo) {
		try {
			if (verificar(novo) == true) {
				dao.save(novo);
				return ResponseEntity.ok(novo);
			} else {
				return ResponseEntity.status(400).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(400).build();
		}
	}
	

}
