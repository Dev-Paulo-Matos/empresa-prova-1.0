package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.UtilsConstants.PRIMEIRO_CARACTER;
import static br.com.contmatic.prova.constants.RegexConstants.REGEX_ACEITA_LETRAS_COM_ACENTOS;
import static br.com.contmatic.prova.constants.RegexConstants.REGEX_ACEITA_LETRAS_E_ESPACOS_E_ACENTOS;
import static br.com.contmatic.prova.constants.RegexConstants.REGEX_ACEITA_LETRAS_E_ESPACOS_E_NUMEROS_E_ACENTOS;
import static br.com.contmatic.prova.constants.RegexConstants.REGEX_ACEITA_LETRAS_E_NUMEROS_E_ACENTOS;
import static br.com.contmatic.prova.constants.RegexConstants.REGEX_ACEITA_NUMEROS;
import static br.com.contmatic.prova.constants.UtilsConstants.NULO;
import static br.com.contmatic.prova.constants.UtilsConstants.REGEX_NULA;
import static br.com.contmatic.prova.constants.UtilsConstants.STRING_5_A_60;
import static br.com.contmatic.prova.constants.UtilsConstants.STRING_INVALIDA_CARACTERES;
import static br.com.contmatic.prova.constants.UtilsConstants.STRING_INVALIDA_PODE_CONTER_APENAS_LETRAS;
import static br.com.contmatic.prova.constants.UtilsConstants.STRING_INVALIDA_PODE_CONTER_APENAS_NUMEROS;
import static java.lang.String.valueOf;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidatorUtil {

	private ValidatorUtil() {}
	
	public static void validarTamanhoString(String texto, int min, int max) {
		validarTamanhoString(texto,min,max,null);
	}
	
	public static void validarTamanhoString(String texto, int min, int max, String mensagem) {
		if (texto.length() < min || texto.length() > max) {
			if(mensagem != null) {
				throw new IllegalStateException(mensagem);
			}
			throw new IllegalStateException(STRING_5_A_60);
		}
	}

	public static void validarCaracteresLetrasEspacosEAcentos(String texto) {
		validarPorRegex(texto, REGEX_ACEITA_LETRAS_E_ESPACOS_E_ACENTOS, STRING_INVALIDA_CARACTERES);
	}
	
	public static void validarCaracteresLetrasEAcentos(String texto) {	
		validarPorRegex(texto,REGEX_ACEITA_LETRAS_COM_ACENTOS,STRING_INVALIDA_PODE_CONTER_APENAS_LETRAS);
	}
	
	public static void validarCaracteresNumeros(String texto) {	
		validarPorRegex(texto,REGEX_ACEITA_NUMEROS,STRING_INVALIDA_PODE_CONTER_APENAS_NUMEROS);
	}
	
	public static void validarCaracteresLetrasENumerosEEspacosEAcentos(String texto) {
		validarPorRegex(texto, REGEX_ACEITA_LETRAS_E_ESPACOS_E_NUMEROS_E_ACENTOS, STRING_INVALIDA_CARACTERES);
	}
	
	public static void validarCaracteresLetrasENumerosEAcentos(String texto) {
		validarPorRegex(texto,REGEX_ACEITA_LETRAS_E_NUMEROS_E_ACENTOS,STRING_INVALIDA_CARACTERES);
	}
	
	public static void validarNulo(Object obj) {
		validarNulo(obj,null);
	}
	
	public static void validarNulo(Object obj, String mensagem) {
		if (obj == null) {
			if(mensagem == null) {
				throw new IllegalArgumentException(NULO);
			}
			throw new IllegalArgumentException(mensagem);
		}	
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
			if(mensagem != null) {
				throw new IllegalStateException("String com digitos sequenciais!");
			}
			throw new IllegalStateException(mensagem);
		}
	}
	public static void validarSeESequencial(String texto, int numeroFixo) {
		validarSeESequencial(texto,numeroFixo,null);
	}
}
