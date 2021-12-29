package br.com.contmatic.empresa.constants;

public final class Constants {
	
	// REGEX
	
	public static final String REGEX_ACEITA_LETRAS_E_ESPACOS_E_ACENTOS = "([A-zá-ú\s]+)";
	
	public static final String REGEX_ACEITA_LETRAS_COM_ACENTOS = "([A-zá-ú]+)";
	
	public static final String REGEX_ACEITA_NUMEROS = "([0-9]+)";
	
	
	public static final String REGEX_ACEITA_LETRAS_E_NUMEROS_E_ACENTOS = "([A-zá-ú0-9]+)";
	
	// FUNCIONARIO
	
	public static final int FUNCIONARIO_NOME_TAMANHO_MAXIMO = 60;

	public static final int FUNCIONARIO_NOME_TAMANHO_MINIMO = 5;
	
	public static final int ZERO = 0;
	
	public static final int IDADE_MINIMA = 18;
	
	public static final int TAMANHO_MAX_LISTA_FUNCIONARIO = 100;

	public static final int TAMANHO_MIN_LISTA_FUNCIONARIO = 2;
	
	// CONTATO
	
	public static final String DDI_BRASIL = "55";
	
	public static final int CONDICAO_EMAIL_TAMANHO = 3;
	
	public static final int QUANTIDADE_DE_DIGITOS_CELULAR = 13;

	
	// REGEX
	
	public static final String REGEX_EMAIL = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

	// DEPARTAMENTO
	
	public static final int DEPARTAMENTO_COD_TAMANHO_FIXO = 5;

	public static final int DEPARTAMENTO_NOME_TAMANHO_MAXIMO = 60;

	public static final int DEPARTAMENTO_NOME_TAMANHO_MINIMO = 5;
	
	public static final int TAMANHO_MAX_LISTA_DEPARTAMENTO = 20;
	
	// EMPRESA
	
	public static final int RAZAO_SOCIAL_NOME_TAMANHO_MAXIMO = 60;

	public static final int RAZAO_SOCIAL_NOME_TAMANHO_MINIMO = 5;
	
	private Constants() {}
	
	// CIDADE
	
	public static final int CODIGO_IBGE_TAMNHO_FIXO = 5;

	public static final int NOME_CIDADE_TAMANHO_MINIMO = 3;
	
	public static final int NOME_CIDADE_TAMANHO_MAXIMO = 60;
	
	public static final int UF_CIDADE_TAMANHO_FIXO = 2;
	

	// ENDERECO
	
	public static final int CEP_TAMANHO_FIXO = 8;
	
	public static final int NUMERO_ENDERECO_TAMANHO_MINIMO = 1;
	
	public static final int NUMERO_ENDERECO_TAMANHO_MAXIMO = 5;
	
	public static final int RUA_TAMANHO_MINIMO = 3;
	
	public static final int RUA_TAMANHO_MAXIMO = 60;
	
	// CPF
	
	public static final int ITERACAO2 = 10;

	public static final int ITERACAO1 = 9;

	public static final int CONDICAO_11 = 11;

	public static final int CONDICAO_10 = 10;

	public static final int CPF_SEM_DIGITOS = 9;

	public static final int TAMANHO_CPF = 11;

	public static final int QUANTIDADE_DE_DIGITOS_CPF = 11;
	
	public static final int PRIMEIRO_DIGITO_VERIFICADOR = 9;
	
	public static final int SEGUNDO_DIGITO_VERIFICADOR = 10;
	
	public static final int PESO2 = 11;
	
	// CNPJ
	
	public static final int PESO_11 = 11;

	public static final int CONDICAO_1 = 1;

	public static final int CONDICAO_0 = 0;

	public static final int PESO_10 = 10;

	public static final int MODULACAO_CALCULAR = 11;

	public static final int ITERACAO_12 = 12;

	public static final int ITERACAO = 11;

	public static final int CNPJ_SEM_DIGITOS_VERIFICADORES = 12;

	public static final int PRIMEIRO_CARACTER = 0;

	public static final int TAMANHO_CNPJ = 14;
	
	public static final int PRIMEIRO_DIGITO_VERIFICADOR_CNPJ = 12;
	
	public static final int SEGUNDO_DIGITO_VERIFICADOR_CNPJ = 13;
	
	// LISTA TAMANHO
	
	public static final int TAMANHO_MIN_LISTA_DEPARTAMENTO = 2;
	
	public static final int TAMANHO_MAX_ENDERECO = 20;

	public static final int TAMANHO_MIN_ENDERECO = 1;
}
