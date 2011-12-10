package com.unipac.curso.android.primeiraaula.util;

import com.unipac.curso.android.primeiraaula.model.UsuarioDto;

public class SesssionMananger {
	private static volatile SesssionMananger instance;
	private UsuarioDto usuario;

	private SesssionMananger() {

	}

	public static SesssionMananger getInstance() {
		if (instance == null) {
			instance = new SesssionMananger();
		}
		return instance;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
}
