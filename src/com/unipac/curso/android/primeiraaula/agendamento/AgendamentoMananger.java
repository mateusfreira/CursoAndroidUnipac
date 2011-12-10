package com.unipac.curso.android.primeiraaula.agendamento;

import android.util.Log;

import com.unipac.curso.android.primeiraaula.CorsoUnipacContagemActivity;
import com.unipac.curso.android.primeiraaula.model.UsuarioDto;
import com.unipac.curso.android.primeiraaula.util.HttpRequest;
import com.unipac.curso.android.primeiraaula.util.SesssionMananger;

public class AgendamentoMananger {
	// apelido=carol&senha=1234&empresa=1&action=agenda_atendimento&funcionario=1&inicio=08:00&qtd=1&servico=150
	public static boolean agendar(String funcionario, String horaInicio,
			String servico, int qtd) {
	
		HttpRequest httpRequest = new HttpRequest();
		UsuarioDto usuarioDto = SesssionMananger.getInstance().getUsuario();
		String params = 
				"?apelido=" + usuarioDto.getApelido() 
				+ "&senha="+ usuarioDto.getSenha()
				+ "&empresa=1"
				+ "&action=agenda_atendimento"
				+ "&funcionario=" + funcionario
				+ "&inicio=" + horaInicio 
				+ "&qtd=" + qtd
				+ "&servico="+ servico;
		String url = CorsoUnipacContagemActivity.BASE_URL+params;
		Log.d(CorsoUnipacContagemActivity.TAG, url);
		try {
				String result = httpRequest.get(url);
				if(result.startsWith("Erro")){
					Log.d(CorsoUnipacContagemActivity.TAG, result);
					return false;
				}else{
					Log.d(CorsoUnipacContagemActivity.TAG, "Erro"+result);
					return true;
				}
				
		} catch (Exception e) {
			Log.d(CorsoUnipacContagemActivity.TAG, "Erro no agendamento",e);
			return false;
		}
	}
}
