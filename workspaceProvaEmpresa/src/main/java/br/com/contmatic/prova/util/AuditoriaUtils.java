package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_VALIDAR_IP;
import static br.com.contmatic.prova.util.ValidatorUtil.validarPorRegex;

public final class AuditoriaUtils {
	
	private AuditoriaUtils() { }
	
	public static void validarIp(String ip,String mensagem) {
		validarPorRegex(ip,REGEX_VALIDAR_IP,mensagem);
	}

}
