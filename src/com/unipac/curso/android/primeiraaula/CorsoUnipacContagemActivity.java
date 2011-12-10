package com.unipac.curso.android.primeiraaula;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unipac.curso.android.primeiraaula.model.dao.DaoFactory;
import com.unipac.curso.android.primeiraaula.util.HttpRequest;

public class CorsoUnipacContagemActivity extends Activity {
	public static final String TAG = "Curso android";
	public static final String DATA_BASE = "agenda_1.0";
	public static final String BASE_URL = "http://10.0.0.145:8080/JavaFlex/Agendamento";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			DaoFactory.getInstance().setDb(
					this.openOrCreateDatabase(DATA_BASE, Context.MODE_PRIVATE,
							null));
			DaoFactory.getInstance().factoryPessoaDao();
		} catch (Exception e) {
			Log.e(TAG, "Erro ao criar o banco de dados", e);
		}
		setContentView(R.layout.login);
		Button entrar = (Button) findViewById(R.id.bt_login);
		final EditText usuario = (EditText) findViewById(R.id.txt_usuario);
		final EditText senha = (EditText) findViewById(R.id.txt_senha);
		entrar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (login(usuario.getText().toString(), senha.getText()
						.toString())) {
					CorsoUnipacContagemActivity.this
							.setContentView(R.layout.main);
					Button meuButton = (Button) findViewById(R.id.bt_meus_dados);
					meuButton.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							Intent intent = new Intent(
									CorsoUnipacContagemActivity.this,
									MeusDados.class);
							CorsoUnipacContagemActivity.this
									.startActivity(intent);

						}
					});
				} else {
					Toast.makeText(CorsoUnipacContagemActivity.this,
							"Tapado digitou o usuario errado!!!",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	public boolean login(String usuario, String senha) {
		try {
			HttpRequest httpRequest = new HttpRequest();
			String result = httpRequest.get(BASE_URL + "?action=login&apelido="+usuario+"&senha=" +senha+"&empresa=1");
			if (result.startsWith("Erro")) {
				return false;
			} else {
				Toast.makeText(this, result, Toast.LENGTH_LONG).show();
				return true;
			}
		} catch (Exception e) {
			Log.e(TAG, "Erro ao logar", e);
			return false;
		}
	}
}