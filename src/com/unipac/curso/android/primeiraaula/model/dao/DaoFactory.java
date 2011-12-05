package com.unipac.curso.android.primeiraaula.model.dao;

import com.unipac.curso.android.primeiraaula.CorsoUnipacContagemActivity;
import com.unipac.curso.android.primeiraaula.model.dao.impl.PessoaDaoSql;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DaoFactory {
	private volatile static DaoFactory instance;
	private SQLiteDatabase db;

	public static DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}

	private DaoFactory() {
	}

	public PessoaDao factoryPessoaDao() {
		return new PessoaDaoSql(db);
	}

	public void setDb(SQLiteDatabase db) {
		this.db = db;
		prepareTables();
	}

	private void prepareTables() {
		try {
			db.execSQL(PessoaDaoSql.CREATE_TABLE);
		} catch (Exception e) {
			Log.e(CorsoUnipacContagemActivity.TAG, 
					"Erro ao criar tabelas", e);
		}
	}
}
