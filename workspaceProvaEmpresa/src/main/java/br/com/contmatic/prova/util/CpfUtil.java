package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.CpfConstants.CONDICAO_10;
import static br.com.contmatic.prova.constants.CpfConstants.CONDICAO_11;
import static br.com.contmatic.prova.constants.CpfConstants.CPF_SEM_DIGITOS;
import static br.com.contmatic.prova.constants.CpfConstants.ITERACAO1;
import static br.com.contmatic.prova.constants.CpfConstants.ITERACAO2;
import static br.com.contmatic.prova.constants.CpfConstants.PESO2;
import static br.com.contmatic.prova.constants.CpfConstants.PESO_1;
import static br.com.contmatic.prova.constants.CpfConstants.PESO_10;
import static br.com.contmatic.prova.constants.CpfConstants.PRIMEIRO_CARACTER;
import static br.com.contmatic.prova.constants.CpfConstants.PRIMEIRO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constants.RegexConstants.REGEX_ACEITA_NUMEROS;
import static br.com.contmatic.prova.constants.CpfConstants.SEGUNDO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constants.CpfConstants.TAMANHO_CPF;
import static br.com.contmatic.prova.constants.CpfConstants.CPF_INVALIDO;
import static br.com.contmatic.prova.constants.CpfConstants.CPF_INVALIDO_NAO_PODE_SER_NUMERO_SEQUENCIAL;
import static br.com.contmatic.prova.constants.CpfConstants.CPF_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarPorRegex;
import static br.com.contmatic.prova.util.ValidatorUtil.validarSeESequencial;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;


public final class CpfUtil {

	private CpfUtil() {}
	
	public static void validarCpf(String cpf) {
		validarNulo(cpf);
		
		verificarCpfTemSoNumeros(cpf);
		
		cpfQuantidadeDeDigitos(cpf);
		
		validarSeESequencial(cpf, TAMANHO_CPF,CPF_INVALIDO_NAO_PODE_SER_NUMERO_SEQUENCIAL);
		
		validarDigitosVerificadores(cpf);
				
	}
	
	private static void verificarCpfTemSoNumeros(String cpf) {
		validarPorRegex(cpf, REGEX_ACEITA_NUMEROS, CPF_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS);
		
	}

	private static void cpfQuantidadeDeDigitos(String cpf) {
		if(cpf.length() != TAMANHO_CPF) {
			throw new IllegalStateException(CPF_INVALIDO);
		}
	}
	
	private static void  validarDigitosVerificadores(String cpf) {
		String cpfSemDigitos = cpf.substring(PRIMEIRO_CARACTER,CPF_SEM_DIGITOS);
		
		String digito1 = gerarDigito(cpfSemDigitos);
		
		String digito2 = gerarDigito(cpfSemDigitos + digito1);

		if(!(digito1.equals(valueOf(cpf.charAt(PRIMEIRO_DIGITO_VERIFICADOR))) && digito2.equals(valueOf(cpf.charAt(SEGUNDO_DIGITO_VERIFICADOR))))) {
			throw new IllegalStateException(CPF_INVALIDO);
		}
		
	}
	
	private static String gerarDigito(String cpf) {
	     int sm;
	     
	     sm = obterCalculo(cpf);
	     
         return valueOf(digitoFinal(sm)); 
	}

	private static int obterCalculo(String cpf) {
		int sm;
		if(cpf.length() == PRIMEIRO_DIGITO_VERIFICADOR) {
	    	 sm = calcularDigito(cpf,PESO_10,ITERACAO1);
	     } else {
	    	 sm = calcularDigito(cpf,PESO2,ITERACAO2);
	     }
		return sm;
	} 

	private static char digitoFinal(int sm) {
		char digito;
		
		int r = CONDICAO_11 - (sm % CONDICAO_11);
		
         digito = obterDigito(r);
         
		return digito;
	}

	private static char obterDigito(int r) {
		char digito;
		
		if ((r == CONDICAO_10) || (r == CONDICAO_11)) {
              digito = '0';
         } else {
        	 digito = valueOf(r).charAt(PRIMEIRO_CARACTER);
         }
		return digito;
	}

	private static int calcularDigito(String cpf,int peso,int iteracao) {
		int sm = 0;
		
		int i;
		
		int num;
		 
		 for(i=0; i<iteracao; i++) {
			 num = parseInt(valueOf(cpf.charAt(i)));
			 
		     sm = sm + (num * peso);
		     
		     peso = peso - PESO_1;
		 }
		return sm;
	}
	
}
	