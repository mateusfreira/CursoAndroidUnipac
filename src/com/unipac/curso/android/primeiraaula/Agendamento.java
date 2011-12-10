package com.unipac.curso.android.primeiraaula;

import com.unipac.curso.android.primeiraaula.agendamento.AgendamentoMananger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Agendamento extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(CorsoUnipacContagemActivity.TAG, "Abril a tela de Agendamento!!!");
		this.setContentView(R.layout.agendar);
		Button agenButton = (Button) findViewById(R.id.bt_agendar);
		agenButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (AgendamentoMananger.agendar("2", "10:00", "2", 1)) {
					Toast.makeText(Agendamento.this, "ok", Toast.LENGTH_LONG)
					.show();
				}else{
					Toast.makeText(Agendamento.this, "Deu tudo errado", Toast.LENGTH_LONG)
					.show();
				}
			}
		});
	}
}
