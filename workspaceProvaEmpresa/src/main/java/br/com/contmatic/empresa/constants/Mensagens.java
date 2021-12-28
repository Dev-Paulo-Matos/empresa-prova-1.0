package br.com.contmatic.empresa.constants;

public final class Mensagens {
	
	// VALIDATOR UTIL
	
	public static final String STRING_INVALIDA = "String invalida!";
	
	public static final String NULO = "Não se deve passar um valor nulo";
	
	public static final String STRING_INVALIDA_CARACTERES = "String invalida, string contem caracteres invalidos";
	
	public static final String STRING_5_A_60 = "String com menos de 5 caracteres ou acima de 60 caracteres";
	
	public static final String REGEX_NULA = "Regex nula";
	
	// CONTATO
	
	public static final String CONTATO_NULO = "Contato invalido!";
	
	public static final String CONTATO_EMAIL_INVALIDO = "E-mail invalido!";
	
	public static final String CELULAR_NAO_POSSUI_DDI_DO_BRASIL = "Celular não possui DDI do Brasil";
	
	public static final String CELULAR_COM_QUANTIDADE_DE_DIGITOS_INVALIDO = "Celular com quantidade de digitos invalido!";

	public static final String CELULAR_INVALIDO_NAO_PODE_CARACTERES_INVALIDOS = "Celular invalido, não pode caracteres invalidos!";

	public static final String EMAIL_NAO_PODE_SER_NULO = "Email não pode ser nulo!";

	
	// FUNCIONARIO
	
	public static final String DATA_NULA = "Data invalida!";
	
	public static final String PESSOA_COM_IDADE_INSUFICIENTE = "Pessoa não tem idade o suficiente para trabalhar";

	// CNPJ
	
	public static final String CNPJ_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS = "CNPJ não deve conter letras e nem caracteres especiais!";

	public static final String CNPJ_INVALIDO_CNPJ_NAO_PODE_SER_UM_NUMERO_SEQUENCIAL = "CNPJ invalido! CNPJ não pode ser um numero sequencial!";

	public static final String CNPJ_POSSUI_QUANTIDADE_INVALIDA_DE_DIGITOS = "CNPJ, possui quantidade invalida de digitos!";

	public static final String CNPJ_INVALIDO = "Cnpj invalido!";
	
	// CPF
	
	public static final String CPF_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS = "CPF não deve conter letras e nem caracteres especiais";

	public static final String CPF_INVALIDO = "Cpf invalido!";

	public static final String CPF_INVALIDO_NAO_PODE_SER_NUMERO_SEQUENCIAL = "CPF invalido! CPF não pode ser um numero sequencial!";

	// LISTA VALIDACOES
	
	public static final String LISTA_DEVE_CONTER_PELO_MENOS_2_ELEMENTOS_LISTA_INVALIDA = "Lista deve conter pelo menos 2 elementos, lista invalida!";
	
	// STRING  VALIDACOES
	
	public static final String STRING_INVALIDA_PODE_CONTER_APENAS_NUMEROS = "String invalida, pode conter apenas numeros";
	
	public static final String STRING_INVALIDA_PODE_CONTER_APENAS_LETRAS = "String invalida, pode conter apenas letras";
	
	
	// EMPRESA
	
	public static final String LISTA_DEVE_POSSUIR_DE_1_A_20_ENDERECOS = "Lista deve possuir de 1 a 20 endereços!";

	public static final String LISTA_DEVE_POSSUIR_DE_2_A_20_DEPARTAMENTOS = "Lista deve possuir de 2 a 20 departamentos!";
	
	// DEPARTAMENTO
	
	public static final String LISTA_DEVE_POSSUIR_DE_2_A_100_FUNCIONARIOS = "Lista deve possuir de 2 a 100 funcionarios!";
	
	public static final String COD_DEPARTAMENTO_DEVE_POSSUIR_5_CARACTERES = "Cod Departamento deve possuir 5 caracteres!";
	
	// CIDADE
	
	public static final String NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES = "Nome deve possuir de 3 a 60 caracteres!";
	
	public static final String CODIGO_IBGE_DEVE_POSSUIR_5_CARACTERES = "Codigo IBGE deve possuir 5 caracteres!";

	public static final String UF_CONTEM_O_NUMERO_DE_DIGITOS_INVALIDO = "UF contem o numero de digitos invalido!";
	
	// ENDERECO
	
	public static final String CEP_CONTEM_O_NUMERO_DE_DIGITOS_INVALIDO = "CEP contem o numero de digitos invalido!";

	public static final String NUMERO_DA_CASA_CONTEM_A_QUANTIDADE_DE_DIGITOS_INVALIDA = "Numero da casa contem a quantidade de digitos invalida!";

	
	private Mensagens() { }
	
	
}
