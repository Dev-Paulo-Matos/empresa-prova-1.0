package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.FuncionarioConstantes.IDADE_MINIMA;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.PESSOA_COM_IDADE_INSUFICIENTE;
import static org.joda.time.DateTime.now;
import static org.joda.time.Years.yearsBetween;

import org.joda.time.DateTime;

public final class DataUtil {

	private DataUtil() {}
	
	public static void validarDataNascimento(DateTime data) {
		
		if(!isMaiorIdadeTest(data)) {
			throw new IllegalStateException(PESSOA_COM_IDADE_INSUFICIENTE);
		}
		
	}
	
	private static boolean isMaiorIdadeTest(DateTime data) {
		DateTime atualmente = now();
		
		int idade = yearsBetween(data, atualmente).getYears();

		return idade >= IDADE_MINIMA;
	}

	public static void validarDataPassada(DateTime dataCriacao,String mensagem) {
		if(dataCriacao.plusMinutes(1).isBefore(DateTime.now())) {
			throw new IllegalStateException(mensagem);
		}
	}
	
	public static void validarDataFutura(DateTime dataCriacao,String mensagem) {
		if(dataCriacao.isAfter(DateTime.now().plusMinutes(1))) {
			throw new IllegalStateException(mensagem);
		}
	}
	

}
