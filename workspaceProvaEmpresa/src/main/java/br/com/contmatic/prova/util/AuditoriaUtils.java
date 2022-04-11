package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_ALTERACAO_NAO_PODE_SER_MENOR_QUE_DATA_CRIACAO;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_VALIDAR_IP;
import static br.com.contmatic.prova.util.ValidatorUtil.validarPorRegex;

import org.joda.time.DateTime;

public final class AuditoriaUtils {
	
	private AuditoriaUtils() { }
	
	public static void validarIp(String ip,String mensagem) {
		validarPorRegex(ip,REGEX_VALIDAR_IP,mensagem);
	}
	
	public static void validarDataAlteracaoMaiorQueDataCriacao(DateTime dataCriacao, DateTime dataAlteracao) {
		if(!dataCriacao.isBefore(dataAlteracao)) {
			throw new IllegalStateException( DATA_ALTERACAO_NAO_PODE_SER_MENOR_QUE_DATA_CRIACAO);
		}
	}

}
