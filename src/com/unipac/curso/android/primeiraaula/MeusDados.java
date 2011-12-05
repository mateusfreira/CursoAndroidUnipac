package com.unipac.curso.android.primeiraaula;

import com.unipac.curso.android.primeiraaula.model.Pessoa;
import com.unipac.curso.android.primeiraaula.model.dao.DaoFactory;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

public class MeusDados extends Activity {
	ImageView imageView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(CorsoUnipacContagemActivity.TAG, "Abril a tela de MeusDados");
		this.setContentView(R.layout.meus_dados);
		Pessoa pessoa = DaoFactory.getInstance().factoryPessoaDao()
				.getPessoa(1);
		EditText nome = (EditText) findViewById(R.id.tx_nome);
		nome.setText(pessoa.getNome());
		EditText telefone = (EditText) findViewById(R.id.tx_telefone);
		telefone.setText(pessoa.getTelefone());
		EditText celular = (EditText) findViewById(R.id.tx_celular);
		celular.setText(pessoa.getCelular());
		EditText dataNacimento = (EditText) findViewById(R.id.tx_date);
		dataNacimento.setText(pessoa.getAniversario().toString());

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		Bundle bundle = intent.getExtras();
		Bitmap bitmap = (Bitmap) bundle.get("data");
		imageView.setImageBitmap(bitmap);
	}

}
