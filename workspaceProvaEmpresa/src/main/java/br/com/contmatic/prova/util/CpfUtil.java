package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.CpfConstantes.CONDICAO_10;
import static br.com.contmatic.prova.constants.CpfConstantes.CONDICAO_11;
import static br.com.contmatic.prova.constants.CpfConstantes.CPF_INVALIDO;
import static br.com.contmatic.prova.constants.CpfConstantes.CPF_SEM_DIGITOS;
import static br.com.contmatic.prova.constants.CpfConstantes.ITERACAO1;
import static br.com.contmatic.prova.constants.CpfConstantes.ITERACAO2;
import static br.com.contmatic.prova.constants.CpfConstantes.PESO_1;
import static br.com.contmatic.prova.constants.CpfConstantes.PESO_10;
import static br.com.contmatic.prova.constants.CpfConstantes.PESO_11;
import static br.com.contmatic.prova.constants.CpfConstantes.PRIMEIRO_CARACTER;
import static br.com.contmatic.prova.constants.CpfConstantes.PRIMEIRO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constants.CpfConstantes.SEGUNDO_DIGITO_VERIFICADOR;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public final class CpfUtil {

    private CpfUtil() {
    }

    public static void validarCpf(String cpf) {
        validarDigitosVerificadores(cpf);
    }

    private static void validarDigitosVerificadores(String cpf) {
        String cpfSemDigitos = cpf.substring(PRIMEIRO_CARACTER, CPF_SEM_DIGITOS);
        String digito1 = gerarDigito(cpfSemDigitos);
        String digito2 = gerarDigito(cpfSemDigitos + digito1);
        if (!(digito1.equals(valueOf(cpf.charAt(PRIMEIRO_DIGITO_VERIFICADOR))) && digito2.equals(valueOf(cpf.charAt(SEGUNDO_DIGITO_VERIFICADOR))))) {
            throw new IllegalStateException(CPF_INVALIDO);
        }
    }

    private static String gerarDigito(String cpf) {
        int soma = obterCalculo(cpf);
        return valueOf(digitoFinal(soma));
    }

    private static int obterCalculo(String cpf) {
        int soma;
        if (cpf.length() == PRIMEIRO_DIGITO_VERIFICADOR) {
            soma = calcularDigito(cpf, PESO_10, ITERACAO1);
        } else {
            soma = calcularDigito(cpf, PESO_11, ITERACAO2);
        }
        return soma;
    }

    private static char digitoFinal(int soma) {
        char digito;
        int calculoDigito = CONDICAO_11 - (soma % CONDICAO_11);
        digito = obterDigito(calculoDigito);
        return digito;
    }

    private static char obterDigito(int calculoDigito) {
        char digito;
        if ((calculoDigito == CONDICAO_10) || (calculoDigito == CONDICAO_11)) {
            digito = '0';
        } else {
            digito = valueOf(calculoDigito).charAt(PRIMEIRO_CARACTER);
        }
        return digito;
    }

    private static int calcularDigito(String cpf, int peso, int iteracao) {
        int soma = 0;
        for(int i = 0 ; i < iteracao ; i++) {
            int num = parseInt(valueOf(cpf.charAt(i)));
            soma += (num * peso);
            peso -= PESO_1;
        }
        return soma;
    }
}
