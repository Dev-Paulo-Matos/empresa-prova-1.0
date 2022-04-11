package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.ContatoConstantes.CELULAR_COM_QUANTIDADE_DE_DIGITOS_INVALIDO;
import static br.com.contmatic.prova.constants.ContatoConstantes.CELULAR_INVALIDO_NAO_PODE_CARACTERES_INVALIDOS;
import static br.com.contmatic.prova.constants.ContatoConstantes.CELULAR_NAO_POSSUI_DDI_DO_BRASIL;
import static br.com.contmatic.prova.constants.ContatoConstantes.CONDICAO_EMAIL_TAMANHO;
import static br.com.contmatic.prova.constants.ContatoConstantes.CONTATO_EMAIL_INVALIDO;
import static br.com.contmatic.prova.constants.ContatoConstantes.DDI_BRASIL;
import static br.com.contmatic.prova.constants.ContatoConstantes.EMAIL_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constants.ContatoConstantes.PRIMEIRO_CARACTER;
import static br.com.contmatic.prova.constants.ContatoConstantes.QUANTIDADE_DE_DIGITOS_CELULAR;
import static br.com.contmatic.prova.constants.ContatoConstantes.EMAIL_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.ContatoConstantes.CELULAR_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.ContatoConstantes.CELULAR_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.RegexConstantes.REGEX_EMAIL;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarPorRegex;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

public final class ContatoValidatorUtil {
	
	private ContatoValidatorUtil() {
	
	}
	
	public static void validarCelular(String celular) {
		validarNulo(celular, CELULAR_NAO_PODE_ESTAR_NULO);
		validarVazio(celular, CELULAR_NAO_PODE_ESTAR_VAZIO);
		validarDigitosNumerico(celular);
		validarTamanhoString(celular, QUANTIDADE_DE_DIGITOS_CELULAR, QUANTIDADE_DE_DIGITOS_CELULAR, CELULAR_COM_QUANTIDADE_DE_DIGITOS_INVALIDO);
		validarCelularBrasil(celular);
		
	}
	
	private static void validarDigitosNumerico(String celular) {
		String celularLimpo = celular.trim();
		
		for (int i=0 ; i < celularLimpo.length(); i++) {
			   
			char c = celularLimpo.charAt(i);

			if (!(Character.isDigit(c))) {
				   throw new IllegalStateException(CELULAR_INVALIDO_NAO_PODE_CARACTERES_INVALIDOS);
			}  
		}
	}
	
	private static void validarCelularBrasil(String celular) {
		String celularLimpo = celular.trim();
		
		if (!celularLimpo.substring(PRIMEIRO_CARACTER,2).equals(DDI_BRASIL)) {
			throw new IllegalStateException(CELULAR_NAO_POSSUI_DDI_DO_BRASIL);
		}
		
	}

	public static void validarEmail(String email) {
		validarNulo(email,EMAIL_NAO_PODE_SER_NULO);
		validarVazio(email, EMAIL_NAO_PODE_ESTAR_VAZIO);
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
