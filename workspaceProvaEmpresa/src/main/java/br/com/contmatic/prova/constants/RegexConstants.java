package br.com.contmatic.prova.constants;

public final class RegexConstants {
	
	public static final String REGEX_ACEITA_LETRAS_E_ESPACOS_E_NUMEROS_E_ACENTOS = "([A-zá-ú0-9\\s]+)";
	public static final String REGEX_ACEITA_LETRAS_E_NUMEROS_E_ACENTOS = "([A-zá-ú0-9]+)";
	public static final String REGEX_ACEITA_LETRAS_E_ESPACOS_E_ACENTOS = "([A-zá-ú\\s]+)";	
	public static final String REGEX_ACEITA_LETRAS_COM_ACENTOS = "([A-zá-ú]+)";
	public static final String REGEX_ACEITA_LETRAS = "([A-z]+)";
	public static final String REGEX_ACEITA_NUMEROS = "([0-9]+)";
	public static final String REGEX_EMAIL = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	public static final String REGEX_VALIDAR_IP = "^((1?\\d{1,2}|2([0-4]\\d|5[0-5]))\\.){3}(1?\\d{1,2}|2([0-4]\\d|5[0-5]))$|^$";




	
	//MENSAGENS
	
	public static final String REGEX_NULA = "Regex não pode ser nula!";
	private RegexConstants() {}
	
}
