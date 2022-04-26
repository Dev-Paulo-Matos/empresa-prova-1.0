package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.FuncionarioConstantes.IDADE_MINIMA;
import static org.joda.time.LocalDate.now;

import org.joda.time.LocalDate;

public final class DataUtil {

	private DataUtil() {}
	
	public static void validarDataPassado(LocalDate data, String mensagem) {
		if(data.isBefore(now().plusYears(-90))) {
			throw new IllegalStateException(mensagem);
		}
	}
	
	public static void validarDataPassadoAuditoria(LocalDate data, String mensagem) {
		if(data.isBefore(now())) {
			throw new IllegalStateException(mensagem);
		}
	}
	
	public static void validarDataFuturo(LocalDate data, String mensagem) {
		if(now().isBefore(data)) {
			throw new IllegalStateException(mensagem);
		}
	}

	public static void validarDataMenorDezoito(LocalDate data, String mensagem) {
		if((LocalDate.now().getYear() - IDADE_MINIMA) < data.getYear()) {
			throw new IllegalStateException(mensagem);
		}
	}

}
