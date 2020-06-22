package br.com.artista.projeto.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.artista.projeto.model.Artista;

public interface ArtistaDAO extends CrudRepository<Artista, Integer> {

	public ArrayList<Artista> findByNacionalidade(String nacionalidade);
	public Artista findByNomeArtisticoAndNacionalidade(String nomeArtistico, String nacionalidade);
}
