package br.com.contmatic.prova.constants;

public final class RegexConstants {
	
		public static final String REGEX_ACEITA_LETRAS_E_ESPACOS_E_ACENTOS = "([A-zá-ú\\s]+)";
		
		public static final String REGEX_ACEITA_LETRAS_COM_ACENTOS = "([A-zá-ú]+)";
		
		public static final String REGEX_ACEITA_NUMEROS = "([0-9]+)";
		
		public static final String REGEX_ACEITA_LETRAS_E_ESPACOS_E_NUMEROS_E_ACENTOS = "([A-zá-ú0-9\\s]+)";
			
		public static final String REGEX_ACEITA_LETRAS_E_NUMEROS_E_ACENTOS = "([A-zá-ú0-9]+)";
		
		public static final String REGEX_EMAIL = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

		private RegexConstants() {}
		
}
