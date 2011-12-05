package com.unipac.curso.android.primeiraaula;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Agendamento extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(CorsoUnipacContagemActivity.TAG, "Abril a tela de Agendamento!!!");
		this.setContentView(R.layout.agendar);
	}
}
