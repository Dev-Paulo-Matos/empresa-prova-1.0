package br.com.contmatic.empresa.util;

import static br.com.contmatic.empresa.constants.Constants.CONDICAO_10;
import static br.com.contmatic.empresa.constants.Constants.CONDICAO_11;
import static br.com.contmatic.empresa.constants.Constants.CPF_SEM_DIGITOS;
import static br.com.contmatic.empresa.constants.Constants.ITERACAO1;
import static br.com.contmatic.empresa.constants.Constants.ITERACAO2;
import static br.com.contmatic.empresa.constants.Constants.PESO2;
import static br.com.contmatic.empresa.constants.Constants.PESO_10;
import static br.com.contmatic.empresa.constants.Constants.PRIMEIRO_CARACTER;
import static br.com.contmatic.empresa.constants.Constants.PRIMEIRO_DIGITO_VERIFICADOR;
import static br.com.contmatic.empresa.constants.Constants.SEGUNDO_DIGITO_VERIFICADOR;
import static br.com.contmatic.empresa.constants.Constants.TAMANHO_CPF;
import static br.com.contmatic.empresa.constants.Mensagens.CPF_INVALIDO;
import static br.com.contmatic.empresa.constants.Mensagens.CPF_INVALIDO_NAO_PODE_SER_NUMERO_SEQUENCIAL;
import static br.com.contmatic.empresa.constants.Mensagens.CPF_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarSeESequencial;
import static java.lang.Character.isDigit;
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
		for (int i = 0; i < cpf.length(); i++) {
			
			char c = cpf.charAt(i);
			
			if (!(isDigit(c))) {
				throw new IllegalStateException(CPF_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS);
			}
			
		}
		
		
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
		//TODO testar as 4 condicoes de primeiro e segundo digito invalido
		if(!(digito1.equals(valueOf(cpf.charAt(PRIMEIRO_DIGITO_VERIFICADOR))) && digito2.equals(valueOf(cpf.charAt(SEGUNDO_DIGITO_VERIFICADOR))))) {
			throw new IllegalStateException(CPF_INVALIDO);
		}
		
	}
	
	private static String gerarDigito(String cpf) {
	     int sm;
	     
	     if(cpf.length() == PRIMEIRO_DIGITO_VERIFICADOR) {
	    	 sm = calcularDigito(cpf,PESO_10,ITERACAO1);
	     } else {
	    	 sm = calcularDigito(cpf,PESO2,ITERACAO2);
	     }
	     
         return valueOf(digitoFinal(sm)); 
	} 

	private static char digitoFinal(int sm) {
		char digito;
		
		int r = 11 - (sm % 11);
		
         if ((r == CONDICAO_10) || (r == CONDICAO_11))
              digito = '0';
         else digito = valueOf(r).charAt(PRIMEIRO_CARACTER);
		return digito;
	}

	private static int calcularDigito(String cpf,int peso,int iteracao) {
		int sm = 0;
		
		int i;
		
		int num;
		 
		 for(i=0; i<iteracao; i++) {
			 num = parseInt(valueOf(cpf.charAt(i)));
			 
		     sm = sm + (num * peso);
		     
		     peso = peso - 1;
		 }
		return sm;
	}
	
}
	