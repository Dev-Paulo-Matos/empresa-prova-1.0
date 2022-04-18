package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.CnpjConstantes.PRIMEIRO_CARACTER;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_ACEITA_LETRAS;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_ACEITA_LETRAS_COM_ACENTOS;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_ACEITA_LETRAS_E_ESPACOS_E_ACENTOS;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_ACEITA_LETRAS_E_ESPACOS_E_NUMEROS_E_ACENTOS;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_ACEITA_LETRAS_E_NUMEROS_E_ACENTOS;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_ACEITA_NUMEROS;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_EMAIL;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_NULA;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_VALIDA_ESPACOS;
import static java.lang.String.valueOf;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidatorUtil {

	private ValidatorUtil() {}
	
	public static void validarTamanhoString(String texto, int min, int max, String mensagem) {
		if (texto.length() < min || texto.trim().length() > max) {
			throw new IllegalStateException(mensagem);
		}
	}

	public static void validarCaracteresLetrasEspacosEAcentos(String texto, String mensagem) {
		validarPorRegex(texto, REGEX_ACEITA_LETRAS_E_ESPACOS_E_ACENTOS, mensagem);
	}

	public static void validarCaracteresLetras(String texto, String mensagem) {
		validarPorRegex(texto, REGEX_ACEITA_LETRAS, mensagem);
	}
	
	public static void validarCaracteresLetrasEAcentos(String texto, String mensagem) {
		validarPorRegex(texto,REGEX_ACEITA_LETRAS_COM_ACENTOS,mensagem);
	}
	
	public static void validarCaracteresNumeros(String texto, String mensagem) {
		validarPorRegex(texto,REGEX_ACEITA_NUMEROS, mensagem);
	}
	
	public static void validarCaracteresLetrasENumerosEEspacosEAcentos(String texto, String mensagem) {
		validarPorRegex(texto, REGEX_ACEITA_LETRAS_E_ESPACOS_E_NUMEROS_E_ACENTOS, mensagem);
	}
	
	public static void validarCaracteresLetrasENumerosEAcentos(String texto, String mensagem) {
		validarPorRegex(texto,REGEX_ACEITA_LETRAS_E_NUMEROS_E_ACENTOS, mensagem);
	}
	
	public static void validarNulo(Object obj, String mensagem) {
		if (obj == null) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validarVazio(String string, String mensagem) {
		if(string.isEmpty()) {
			throw new IllegalStateException(mensagem);
		}
	}
	
	public static void validarEspacos(String string, String mensagem) {
		validarPorRegex(string, REGEX_VALIDA_ESPACOS, mensagem);
	}
	
	public static void validarPorRegex(String campo, String regex, String mensagem) {
		validarNulo(regex,REGEX_NULA);
	    Pattern pattern = compile(regex, CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(campo);
	    boolean matches = matcher.matches();
	    if (!matches) {
	        throw new IllegalStateException(mensagem);
	    }
	}
	
	public static void validarTamanhoList(List<?> list, int min, int max, String mensagem) {
		if(list.size() < min || list.size() > max) {
			throw new IllegalStateException(mensagem);
		}
	}
	
	public static void validarSeESequencial(String texto, int numeroFixo, String mensagem) {
		if ((valueOf(texto.charAt(PRIMEIRO_CARACTER)).repeat(numeroFixo)).equals(texto)) {
			throw new IllegalStateException(mensagem);
		}
	}
	
	public static void validarNumero (long numero, int min, int max, String mensagem) {
		if(numero > max || numero < min) {
			throw new IllegalStateException(mensagem);
		}
	}

	public static void validarCaracteresEmail(String email, String mensagem) {
		validarPorRegex(email, REGEX_EMAIL, mensagem);
	}

}
