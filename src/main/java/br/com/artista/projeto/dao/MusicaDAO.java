package br.com.artista.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.artista.projeto.model.Musica;

public interface MusicaDAO extends CrudRepository<Musica, Integer> {

}
