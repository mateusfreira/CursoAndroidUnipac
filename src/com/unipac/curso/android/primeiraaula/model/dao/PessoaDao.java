package com.unipac.curso.android.primeiraaula.model.dao;

import com.unipac.curso.android.primeiraaula.model.Pessoa;

public interface PessoaDao {
	public void salvar(Pessoa pessoa);

	public Pessoa getPessoa(String nomeUsuario);

	public Pessoa getPessoa(Integer id);

	public void remove(Pessoa pessoa);

}
