package br.com.contmatic.prova.constants;

public final class CnpjConstantes {
	
	public static final int PESO_1 = 1;
	public static final int PESO_11 = 11;
	public static final int CONDICAO_11 = 1;
	public static final int CONDICAO_10 = 0;
	public static final int PESO_10 = 10;
	public static final int MODULACAO_CALCULAR = 11;
	public static final int ITERACAO_12 = 12;
	public static final int ITERACAO = 11;
	public static final int CNPJ_SEM_DIGITOS_VERIFICADORES = 12;
	public static final int PRIMEIRO_CARACTER = 0;
	public static final int TAMANHO_CNPJ = 14;
	public static final int PRIMEIRO_DIGITO_VERIFICADOR_CNPJ = 12;	
	public static final int SEGUNDO_DIGITO_VERIFICADOR_CNPJ = 13;
	public static final int PESO_2 = 2;
		
	// MENSAGENS
	
	public static final String CNPJ_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS = "CNPJ não deve conter letras e nem caracteres especiais!";
	public static final String CNPJ_INVALIDO_CNPJ_NAO_PODE_SER_UM_NUMERO_SEQUENCIAL = "CNPJ invalido! CNPJ não pode ser um numero sequencial!";
	public static final String CNPJ_POSSUI_QUANTIDADE_INVALIDA_DE_DIGITOS = "CNPJ, possui quantidade invalida de digitos!";
	public static final String CNPJ_INVALIDO = "Cnpj invalido!";
	public static final String CNPJ_NAO_PODE_ESTAR_NULO = "CNPJ não pode estar Nulo!";
	public static final String CNPJ_NAO_PODE_ESTAR_VAZIO = "CNPJ não pode estar vazio!";
	public static final String CNPJ_POSSUI_ESPACOS_INVALIDOS = "Cnpj possui espaços invalidos!";
	private CnpjConstantes() {}
	
}
