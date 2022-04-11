package br.com.contmatic.prova.constants;

public final class CidadeConstantes {
	
	public static final int CODIGO_IBGE_TAMNHO_FIXO = 5;
	public static final int NOME_CIDADE_TAMANHO_MINIMO = 3;
	public static final int NOME_CIDADE_TAMANHO_MAXIMO = 60;
	public static final int UF_CIDADE_TAMANHO_FIXO = 2;
	public static final Integer NUMERO_TAMANHO_MAXIMO = 99999;
	public static final Integer NUMERO_TAMANHO_MINIMO = 1;
	
	//MENSAGENS
	
	public static final String NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES = "Nome da cidade deve possuir de 3 a 60 caracteres!";
	public static final String CODIGO_IBGE_DEVE_POSSUIR_5_CARACTERES = "Codigo IBGE deve possuir 5 caracteres!";
	public static final String UF_CONTEM_O_NUMERO_DE_DIGITOS_INVALIDO = "UF contem o numero de digitos invalido!";
	public static final String NOME_NAO_PODE_ESTAR_VAZIO = "Nome da cidade não pode estar vazio!";
	public static final String NOME_NAO_PODE_ESTAR_NULO = "Nome da cidade não pode estar nulo!";

	public static final String NOME_NAO_PODE_CONTER_NUMEROS_E_NEM_CARACTERES_ESPECIAIS = "Nome da cidade não pode conter numeros e nem caracteres especiais!";
	public static final String CODIGO_IBGE_NAO_PODE_ESTAR_NULO = "Codigo Ibge não pode estar nulo!";
	public static final String CODIGO_IBGE_NAO_PODE_ESTAR_VAZIO = "Codigo Ibge não pode estar vazio!";
	public static final String CODIGO_IBGE_DEVE_CONTER_APENAS_NUMEROS = "Codigo Ibge deve conter apenas numeros!";
	public static final String UF_NAO_PODE_ESTAR_NULO = "UF não pode estar nulo!";
	public static final String UF_DEVE_CONTER_APENAS_LETRAS_E_NAO_PODE_POSSUIR_ACENTOS = "UF deve conter apenas letras e não pode possuir acentos!";
	public static final String CIDADE_NAO_PODE_ESTAR_VAZIO = "Cidade não pode estar vazia!";
	public static final String CIDADE_NAO_PODE_ESTAR_NULO = "Cidade não pode estar nulo!";
	public static final String CODIGO_IBGE_DEVE_POSSUIR_5_DIGITOS = "codigoIbge deve possuir 5 digitos";

	private CidadeConstantes() {}
	
}
