package br.com.contmatic.empresa.util;

import static br.com.contmatic.empresa.constants.Constants.CONDICAO_EMAIL_TAMANHO;
import static br.com.contmatic.empresa.constants.Constants.DDI_BRASIL;
import static br.com.contmatic.empresa.constants.Constants.PRIMEIRO_CARACTER;
import static br.com.contmatic.empresa.constants.Constants.QUANTIDADE_DE_DIGITOS_CELULAR;
import static br.com.contmatic.empresa.constants.Constants.REGEX_EMAIL;
import static br.com.contmatic.empresa.constants.Mensagens.CELULAR_COM_QUANTIDADE_DE_DIGITOS_INVALIDO;
import static br.com.contmatic.empresa.constants.Mensagens.CELULAR_INVALIDO_NAO_PODE_CARACTERES_INVALIDOS;
import static br.com.contmatic.empresa.constants.Mensagens.CELULAR_NAO_POSSUI_DDI_DO_BRASIL;
import static br.com.contmatic.empresa.constants.Mensagens.CONTATO_EMAIL_INVALIDO;
import static br.com.contmatic.empresa.constants.Mensagens.EMAIL_NAO_PODE_SER_NULO;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarPorRegex;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarTamanhoString;

public final class ContatoValidatorUtil {
	
	private ContatoValidatorUtil() {
	
	}
	
	public static void validarCelular(String celular) {
		validarNulo(celular);
		
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
