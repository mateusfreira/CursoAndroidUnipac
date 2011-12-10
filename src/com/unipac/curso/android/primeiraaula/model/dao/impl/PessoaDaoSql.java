package com.unipac.curso.android.primeiraaula.model.dao.impl;

import java.util.Date;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.unipac.curso.android.primeiraaula.CorsoUnipacContagemActivity;
import com.unipac.curso.android.primeiraaula.model.Pessoa;
import com.unipac.curso.android.primeiraaula.model.dao.PessoaDao;

public class PessoaDaoSql implements PessoaDao {
	private SQLiteDatabase db;
	private final static String TABLE_NAME = "Pessoa";
	public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS Pessoa (id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "									nome varchar,"
			+ "									telefone varchar,"
			+ "									celular varchar,"
			+ "									aniversario INTEGER"
			+ "									);";
	private final static String INSERT = "INSERT INTO " + TABLE_NAME
			+ " (id,nome,telefone,celular,aniversario)" + "							VALUES (";
	private static final int ID_COLUMN_INDEX = 0;
	private static final int NOME_COLUMN_INDEX = 1;
	private static final int TELEFONE_COLUMN_INDEX = 2;
	private static final int CELULAR_COLUMN_INDEX = 3;
	private static final int ANIVERSARIO_COLUMN_INDEX = 4;

	public PessoaDaoSql(SQLiteDatabase db) {
		this.db = db;
		createDefalutPessoa();
	}

	private void createDefalutPessoa() {
		Pessoa mateus = new Pessoa();
		mateus.setNome("Mateus Freira");
		mateus.setTelefone("31-35945009");
		mateus.setCelular("31-99536408");
		mateus.setAniversario(new Date(1988, 12, 17));
		salvar(mateus);
	}

	@Override
	public void salvar(Pessoa pessoa) {
		String sql = null;
		if (!pessoa.isStorage()) {
			sql = INSERT;
			sql += " NULL,";// id
			sql += "'" + pessoa.getNome() + "',";// nome
			sql += "'" + pessoa.getTelefone() + "',";// telefone
			sql += "'" + pessoa.getCelular() + "',";// celular
			sql += "" + pessoa.getAniversario().getTime();// aniversario
			sql += " )";

		} else {
			sql = "UPDATE " + TABLE_NAME + " set ";
			sql += " nome = '" + pessoa.getNome() + "',";// nome
			sql += "telefone = '" + pessoa.getTelefone() + "',";// telefone
			sql += " celular = '" + pessoa.getCelular() + "',";// celular
			sql += "aniversario = " + pessoa.getAniversario().getTime();// aniversario
			sql += " where id = " + pessoa.getId();
		}

		Log.d(CorsoUnipacContagemActivity.TAG, sql);
		db.execSQL(sql);
	}

	@Override
	public Pessoa getPessoa(String nomeUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa getPessoa(Integer id) {
		Cursor cursor = db.query(TABLE_NAME, null, "id = ?",
				new String[] { id.toString() }, null, null, null);

		if (cursor.moveToFirst()) {
			Pessoa pessoa = new Pessoa();
			// inteiro
			pessoa.setId(cursor.getInt(ID_COLUMN_INDEX));
			// String
			pessoa.setNome(cursor.getString(NOME_COLUMN_INDEX));
			pessoa.setTelefone(cursor.getString(TELEFONE_COLUMN_INDEX));
			pessoa.setCelular(cursor.getString(CELULAR_COLUMN_INDEX));
			// data
			Date niver = new Date();
			niver.setTime(cursor.getLong(ANIVERSARIO_COLUMN_INDEX));
			pessoa.setAniversario(niver);
			return pessoa;
		} else {
			throw new RuntimeException("Não existe esse id na base!!!");
		}
	}

	@Override
	public void remove(Pessoa pessoa) {
		// TODO Auto-generated method stub

	}

}
