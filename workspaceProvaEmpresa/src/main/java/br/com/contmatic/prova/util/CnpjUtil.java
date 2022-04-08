package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.CnpjConstants.CNPJ_SEM_DIGITOS_VERIFICADORES;
import static br.com.contmatic.prova.constants.CnpjConstants.CONDICAO_0;
import static br.com.contmatic.prova.constants.CnpjConstants.CONDICAO_1;
import static br.com.contmatic.prova.constants.CnpjConstants.ITERACAO;
import static br.com.contmatic.prova.constants.CnpjConstants.ITERACAO_12;
import static br.com.contmatic.prova.constants.CnpjConstants.MODULACAO_CALCULAR;
import static br.com.contmatic.prova.constants.CnpjConstants.PESO_1;
import static br.com.contmatic.prova.constants.CnpjConstants.PESO_10;
import static br.com.contmatic.prova.constants.CnpjConstants.PESO_11;
import static br.com.contmatic.prova.constants.CnpjConstants.PESO_2;
import static br.com.contmatic.prova.constants.CnpjConstants.PRIMEIRO_CARACTER;
import static br.com.contmatic.prova.constants.CnpjConstants.PRIMEIRO_DIGITO_VERIFICADOR_CNPJ;
import static br.com.contmatic.prova.constants.CnpjConstants.SEGUNDO_DIGITO_VERIFICADOR_CNPJ;
import static br.com.contmatic.prova.constants.CnpjConstants.TAMANHO_CNPJ;
import static br.com.contmatic.prova.constants.CnpjConstants.CNPJ_INVALIDO;
import static br.com.contmatic.prova.constants.CnpjConstants.CNPJ_INVALIDO_CNPJ_NAO_PODE_SER_UM_NUMERO_SEQUENCIAL;
import static br.com.contmatic.prova.constants.CnpjConstants.CNPJ_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.CnpjConstants.CNPJ_POSSUI_QUANTIDADE_INVALIDA_DE_DIGITOS;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public final class CnpjUtil {
	
	private CnpjUtil() { 
		
	}

	public static void validarCnpj(String cnpj) {
		validarNulo(cnpj,"CNPJ não pode estar vazio!");
		verificarSeCnpjTemSoNumero(cnpj);
		cnpjQuantidadeDeDigitos(cnpj);
		cnpjNumeroSequencial(cnpj);
		validarDigitosVerificadores(cnpj);
	}
	
	private static void verificarSeCnpjTemSoNumero(String cnpj) {
		for (int i = 0; i < cnpj.length(); i++) {	
			if (!(isDigit(cnpj.charAt(i)))) {
				throw new IllegalStateException(CNPJ_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS);
			}
		}
	}

	private static void cnpjNumeroSequencial(String cnpjSoNumero) {
		if ((valueOf(cnpjSoNumero.charAt(PRIMEIRO_CARACTER)).repeat(TAMANHO_CNPJ)).equals(cnpjSoNumero)) {
			throw new IllegalStateException(CNPJ_INVALIDO_CNPJ_NAO_PODE_SER_UM_NUMERO_SEQUENCIAL);
		}
		
	}
	
	private static void cnpjQuantidadeDeDigitos(String cnpjSoNumero) {
		if (cnpjSoNumero.length() != TAMANHO_CNPJ) {
			throw new IllegalStateException(CNPJ_POSSUI_QUANTIDADE_INVALIDA_DE_DIGITOS);
		}
		
	}
	
	private static void validarDigitosVerificadores(String cnpj) {
		String cnpjSemDigitos = cnpj.substring(PRIMEIRO_CARACTER,CNPJ_SEM_DIGITOS_VERIFICADORES);
		char digito1 = gerarDigito(cnpjSemDigitos);
		char digito2 = gerarDigito(cnpj + digito1);
		if(digito1 != cnpj.charAt(PRIMEIRO_DIGITO_VERIFICADOR_CNPJ) || digito2 != cnpj.charAt(SEGUNDO_DIGITO_VERIFICADOR_CNPJ)) {
			throw new IllegalStateException(CNPJ_INVALIDO);
		}
	}
	
	private static char gerarDigito(String cnpj) {
	    int sm = 0;
		sm = calcularDigitoPeloTamanhoCnpj(cnpj, sm);
		return digitoFinal(sm);
	}

	private static int calcularDigitoPeloTamanhoCnpj(String cnpj, int sm) {
		if(cnpj.length() == PRIMEIRO_DIGITO_VERIFICADOR_CNPJ) {
			sm = calcularDigito(cnpj, sm, ITERACAO);
		} else {
			sm = calcularDigito(cnpj, sm, ITERACAO_12);
		}
		return sm;
	}

	private static char digitoFinal(int sm) {
		char digito;
		int r;
		r = sm % MODULACAO_CALCULAR;
		digito = obterDigito(r);
	    return digito;
	}

	private static char obterDigito(int r) {
		char digito;
		if ((r == CONDICAO_0) || (r == CONDICAO_1)) {
			digito = '0';
		} else {
	    	digito = String.valueOf(PESO_11-r).charAt(PRIMEIRO_CARACTER);
	    }
		return digito;
	}

	private static int calcularDigito(String cnpj,int sm, int iteracao) {
		int i;
		int num;
		int peso = PESO_2;
		
		for (i=iteracao; i>=0; i--) {
			
		    num = parseInt(valueOf(cnpj.charAt(i)));
		    
		    sm = sm + (num * peso);
		    
		    peso = peso + PESO_1;
		    
		    if (peso == PESO_10)
		    	
		       peso = PESO_2;
		}
		return sm;
	}
	
}