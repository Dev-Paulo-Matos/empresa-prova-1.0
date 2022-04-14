package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.CnpjConstantes.CNPJ_INVALIDO;
import static br.com.contmatic.prova.constants.CnpjConstantes.CNPJ_SEM_DIGITOS_VERIFICADORES;
import static br.com.contmatic.prova.constants.CnpjConstantes.CONDICAO_10;
import static br.com.contmatic.prova.constants.CnpjConstantes.CONDICAO_11;
import static br.com.contmatic.prova.constants.CnpjConstantes.ITERACAO;
import static br.com.contmatic.prova.constants.CnpjConstantes.ITERACAO_12;
import static br.com.contmatic.prova.constants.CnpjConstantes.MODULACAO_CALCULAR;
import static br.com.contmatic.prova.constants.CnpjConstantes.PESO_1;
import static br.com.contmatic.prova.constants.CnpjConstantes.PESO_10;
import static br.com.contmatic.prova.constants.CnpjConstantes.PESO_11;
import static br.com.contmatic.prova.constants.CnpjConstantes.PESO_2;
import static br.com.contmatic.prova.constants.CnpjConstantes.PRIMEIRO_CARACTER;
import static br.com.contmatic.prova.constants.CnpjConstantes.PRIMEIRO_DIGITO_VERIFICADOR_CNPJ;
import static br.com.contmatic.prova.constants.CnpjConstantes.SEGUNDO_DIGITO_VERIFICADOR_CNPJ;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public final class CnpjUtil {

	private CnpjUtil() { 
		
	}

	public static void validarCnpj(String cnpj) {
		validarDigitosVerificadores(cnpj);
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
	    int soma = 0;
		soma = calcularDigitoPeloTamanhoCnpj(cnpj, soma);
		return digitoFinal(soma);
	}

	private static int calcularDigitoPeloTamanhoCnpj(String cnpj, int soma) {
		if(cnpj.length() == PRIMEIRO_DIGITO_VERIFICADOR_CNPJ) {
			soma = calcularDigito(cnpj, soma, ITERACAO);
		} else {
			soma = calcularDigito(cnpj, soma, ITERACAO_12);
		}
		return soma;
	}

	private static char digitoFinal(int sm) {
		char digito;
		int calculoDigito = sm % MODULACAO_CALCULAR;
		digito = obterDigito(calculoDigito);
	    return digito;
	}

	private static char obterDigito(int calculoDigito) {
		char digito;
		if ((calculoDigito == CONDICAO_10) || (calculoDigito == CONDICAO_11)) {
			digito = '0';
		} else {
	    	digito = valueOf(PESO_11-calculoDigito).charAt(PRIMEIRO_CARACTER);
	    }
		return digito;
	}

	private static int calcularDigito(String cnpj,int soma, int iteracao) {
		int peso = PESO_2;
		for (int i=iteracao; i>=0; i--) {
		    int num = parseInt(valueOf(cnpj.charAt(i)));
		    soma = soma + (num * peso);
		    peso = peso + PESO_1;
		    if (peso == PESO_10) {		    	
		    	peso = PESO_2;
		    }
		}
		return soma;
	}
	
}
