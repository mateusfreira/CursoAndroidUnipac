package com.unipac.curso.android.primeiraaula.model;

public class UsuarioDto {
	private int id;
	private String nome;
	private String apelido;
	private String senha;

	// private Date data_aniversario;

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

	public String getApelido() {

		return apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	/*
	 * public Date getData_aniversario() { return data_aniversario; }
	 * 
	 * public void setData_aniversario(Date data_aniversario) {
	 * this.data_aniversario = data_aniversario; }
	 */
}
