package br.com.contmatic.empresa.util;

import static br.com.contmatic.empresa.constants.Constants.IDADE_MINIMA;
import static br.com.contmatic.empresa.constants.Constants.ZERO;
import static br.com.contmatic.empresa.constants.Mensagens.PESSOA_COM_IDADE_INSUFICIENTE;

import org.joda.time.DateTime;

public final class DataUtil {

	private DataUtil() {}
	
	public static void validarDataNascimento(DateTime data) {
		
		if(!isMaiorIdade(data)) {
			throw new IllegalStateException(PESSOA_COM_IDADE_INSUFICIENTE);
		}
		
	}
	
	private static boolean isMaiorIdade(DateTime data) { 
		int anoAtual = DateTime.now().getYear();
		
		int mesAtual = DateTime.now().getMonthOfYear();
		
		int diaAtual = DateTime.now().getDayOfMonth();
		
		int anoNascimentoFuncionario = data.getYear();
		
		int mesNascimentoFuncionario = data.getMonthOfYear();
		
		int diaNascimentoFuncionario = data.getDayOfMonth();
		
		if ((anoAtual - anoNascimentoFuncionario > IDADE_MINIMA)) {
			return true;		
		} else if ((anoAtual - anoNascimentoFuncionario == IDADE_MINIMA)) {
			if ((mesAtual - mesNascimentoFuncionario > ZERO)) {
				return true;
			} else {
				return (mesAtual - mesNascimentoFuncionario == ZERO) && (diaAtual - diaNascimentoFuncionario >= ZERO);
			}
		}
		
		return false;
			
	}
}
