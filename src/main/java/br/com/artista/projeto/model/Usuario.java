package br.com.artista.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_usuario")
public class Usuario {

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome", length=40, nullable=false)
	private String nome;
	
	@Column(name="email", length=80, nullable=false)
	private String email;
	
	@Column(name="senha", length=80, nullable=false)
	private String senha;
	
	@Column(name="foto", length=200, nullable=false)
	private String foto;
	
	@Column(name="telefone", length=15, nullable=false)
	private String telefone;
	
	@Column(name="endereco", length=200, nullable=false)
	private String endereco;
	
	@Column(name="idade", nullable=false)
	private int idade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Usuario(int id, String nome, String email, String senha, String foto, String telefone, String endereco,
			int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.telefone = telefone;
		this.endereco = endereco;
		this.idade = idade;
	}

	public Usuario() {
		super();
	}

	
	
}
