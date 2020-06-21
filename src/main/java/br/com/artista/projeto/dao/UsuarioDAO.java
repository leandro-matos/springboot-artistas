package br.com.artista.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.artista.projeto.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

	public Usuario findByEmailAndSenha(String email, String senha);
}
