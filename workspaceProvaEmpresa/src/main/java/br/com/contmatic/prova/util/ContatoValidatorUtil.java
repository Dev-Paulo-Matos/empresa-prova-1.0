package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.ContatoConstants.CONDICAO_EMAIL_TAMANHO;
import static br.com.contmatic.prova.constants.ContatoConstants.DDI_BRASIL;
import static br.com.contmatic.prova.constants.ContatoConstants.PRIMEIRO_CARACTER;
import static br.com.contmatic.prova.constants.ContatoConstants.QUANTIDADE_DE_DIGITOS_CELULAR;
import static br.com.contmatic.prova.constants.RegexConstants.REGEX_EMAIL;
import static br.com.contmatic.prova.constants.ContatoConstants.CELULAR_COM_QUANTIDADE_DE_DIGITOS_INVALIDO;
import static br.com.contmatic.prova.constants.ContatoConstants.CELULAR_INVALIDO_NAO_PODE_CARACTERES_INVALIDOS;
import static br.com.contmatic.prova.constants.ContatoConstants.CELULAR_NAO_POSSUI_DDI_DO_BRASIL;
import static br.com.contmatic.prova.constants.ContatoConstants.CONTATO_EMAIL_INVALIDO;
import static br.com.contmatic.prova.constants.ContatoConstants.EMAIL_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarPorRegex;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;

public final class ContatoValidatorUtil {
	
	private ContatoValidatorUtil() {
	
	}
	
	public static void validarCelular(String celular) {
		validarNulo(celular,"Celular não pode estar vazio!");
		
		validarDigitosNumerico(celular);
		
		validarTamanhoString(celular, QUANTIDADE_DE_DIGITOS_CELULAR, QUANTIDADE_DE_DIGITOS_CELULAR, CELULAR_COM_QUANTIDADE_DE_DIGITOS_INVALIDO);
		
		validarCelularBrasil(celular);
		
	}
	
	private static void validarDigitosNumerico(String celular) {
		for (int i=0 ; i < celular.length(); i++) {
			   
			char c = celular.charAt(i);

			if (!(Character.isDigit(c))) {
				   throw new IllegalStateException(CELULAR_INVALIDO_NAO_PODE_CARACTERES_INVALIDOS);
			}
			   
		}
	}
	
	private static void validarCelularBrasil(String celular) {
		if (!celular.substring(PRIMEIRO_CARACTER,2).equals(DDI_BRASIL)) {
			throw new IllegalStateException(CELULAR_NAO_POSSUI_DDI_DO_BRASIL);
		}
		
	}

	public static void validarEmail(String email) {
		validarNulo(email,EMAIL_NAO_PODE_SER_NULO);
		
		validarCaracteresEmail(email);
	}
	
	private static void validarCaracteresEmail(String email) { 
        if (email.length() > CONDICAO_EMAIL_TAMANHO) {
            validarPorRegex(email, REGEX_EMAIL, CONTATO_EMAIL_INVALIDO);
        } else {
        	throw new IllegalStateException(CONTATO_EMAIL_INVALIDO);
        }
        

	}
	
}
