package br.com.contmatic.empresa.util;

import static br.com.contmatic.empresa.constants.Constants.IDADE_MINIMA;
import static br.com.contmatic.empresa.constants.Mensagens.PESSOA_COM_IDADE_INSUFICIENTE;
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
}
