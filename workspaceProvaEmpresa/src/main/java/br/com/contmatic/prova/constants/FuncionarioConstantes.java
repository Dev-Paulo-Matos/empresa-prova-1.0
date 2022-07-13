package br.com.contmatic.prova.constants;

import java.math.BigDecimal;

public final class FuncionarioConstantes {
	
	public static final int FUNCIONARIO_NOME_TAMANHO_MAXIMO = 60;
	public static final int FUNCIONARIO_NOME_TAMANHO_MINIMO = 5;
	public static final int ZERO = 0;
	public static final int IDADE_MINIMA = 18;
	public static final int TAMANHO_MAX_LISTA_FUNCIONARIO = 100;
	public static final int TAMANHO_MIN_LISTA_FUNCIONARIO = 2;
	public static final BigDecimal SALARIO_MAXIMO = new BigDecimal("4000.00");
	public static final BigDecimal SALARIO_MINIMO = new BigDecimal("1780.00");
	//MENSAGENS
	
	public static final String DATA_NULA = "Data invalida!";
	public static final String PESSOA_COM_IDADE_INSUFICIENTE = "Pessoa não tem idade o suficiente para trabalhar";
	public static final String NOME_NAO_PODE_ESTAR_NULO = "Nome não pode estar nulo";
	public static final String NOME_NAO_PODE_ESTAR_VAZIO = "Nome não pode estar vazio";
	public static final String NOME_NAO_PODE_SER_MENOR_QUE_5_E_NEM_MAIOR_QUE_60_CARACTERES = "Nome não pode ser menor que 5 e nem maior que 60 caracteres!";
	public static final String NOME_NAO_PODE_CONTER_CARACTERES_ESPECIAIS = "Nome não pode conter caracteres especiais!";
	public static final String CARGO_NAO_PODE_ESTAR_VAZIO = "Cargo não pode estar vazio!";
	public static final String CARGO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS = "Cargo deve ter apenas letras, acentos e espaços!";
	public static final String CARGO_NAO_PODE_SER_MENOR_QUE_5_E_MAIOR_QUE_60_CARACTERES = "Cargo não pode ser menor que 5 e maior que 60 caracteres!";
	public static final String LISTA_DE_FUNCIONARIO_NAO_PODE_ESTAR_VAZIA = "Lista de funcionario não pode estar vazia";
	public static final String LISTA_DE_FUNCIONARIO_DEVE_POSSUIR_DE_2_A_100_FUNCIONARIO = "Lista de Funcionario deve possuir de 2 a 100 Funcionario!";
	public static final String CARGO_NAO_PODE_ESTAR_NULO = "Cargo não pode estar nulo!";
	public static final String CARGO_NAO_PODE_POSSUIR_ESPACOS = "Cargo não pode possuir espacos";
	public static final String NOME_NAO_PODE_POSSUIR_ESPACOS_INVALIDOS = "Nome não pode possuir espaços invalidos!";
	public static final String DATA_DE_NASCIMENTO_DO_FUNCIONARIO_NAO_PODE_SER_MAIS_ANTIGA_QUE_90_ANOS = "Data de Nascimento do funcionario não pode ser mais antiga que 90 anos!";
	public static final String DATA_DE_NASCIMENTO_DO_FUNCIONARIO_NAO_PODE_SER_UMA_DATA_FUTURA = "Data de nascimento do funcionario não pode ser uma data futura!";
	public static final String DATA_DE_NASCIMENTO_NAO_PODE_ESTAR_MENOR_QUE_18 = "Data de nascimento não pode estar menor que 18!";
	public static final String INATIVO_NAO_PODE_RECEBER_UM_VALOR_NULO = "Ativo não pode receber um valor nulo!";
    public static final String SALARIO_NAO_PODE_SER_MAIOR_QUE_O_SALARIO_MAXIMO = "Salario não pode ser maior que o salario maximo!";
    public static final String SALARIO_NAO_PODE_SER_MENOR_QUE_O_SALARIO_MINIMO = "Salario não pode ser menor que o salario minimo!";

	
	private FuncionarioConstantes() {}

}
