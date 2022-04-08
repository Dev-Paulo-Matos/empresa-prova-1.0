package br.com.contmatic.prova.constants;

public final class FuncionarioConstants {
	
	public static final int FUNCIONARIO_NOME_TAMANHO_MAXIMO = 60;
	public static final int FUNCIONARIO_NOME_TAMANHO_MINIMO = 5;
	public static final int ZERO = 0;
	public static final int IDADE_MINIMA = 18;
	public static final int TAMANHO_MAX_LISTA_FUNCIONARIO = 100;
	public static final int TAMANHO_MIN_LISTA_FUNCIONARIO = 2;
	
	//MENSAGENS
	
	public static final String DATA_NULA = "Data invalida!";
	public static final String PESSOA_COM_IDADE_INSUFICIENTE = "Pessoa não tem idade o suficiente para trabalhar";
	public static final String NOME_NAO_PODE_ESTAR_VAZIO = "Nome não pode estar vazio";
	public static final String NOME_NAO_PODE_SER_MENOR_QUE_5_E_NEM_MAIOR_QUE_60_CARACTERES = "Nome não pode ser menor que 5 e nem maior que 60 caracteres!";
	public static final String NOME_NAO_PODE_CONTER_CARACTERES_ESPECIAIS = "Nome não pode conter caracteres especiais!";
	public static final String CARGO_NAO_PODE_ESTAR_VAZIO = "Cargo não pode estar vazio!";
	public static final String CARGO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS = "Cargo não pode conter caracteres especiais!";
	public static final String CARGO_NAO_PODE_SER_MENOR_QUE_5_E_MAIOR_QUE_60_CARACTERES = "Cargo não pode ser menor que 5 e maior que 60 caracteres!";
	public static final String LISTA_DE_FUNCIONARIO_NAO_PODE_ESTAR_VAZIA = "Lista de funcionario não pode estar vazia";
	public static final String LISTA_DE_FUNCIONARIO_DEVE_POSSUIR_DE_2_A_100_FUNCIONARIO = "Lista de Funcionario deve possuir de 2 a 100 Funcionario!";

	private FuncionarioConstants() {}

}
