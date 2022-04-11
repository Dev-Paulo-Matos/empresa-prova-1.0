package br.com.contmatic.empresa.empresa;



import static java.lang.Integer.parseInt;
import static org.joda.time.DateTime.now;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.contato.Contato;
import br.com.contmatic.prova.empresa.Departamento;
import br.com.contmatic.prova.empresa.Funcionario;
import br.com.contmatic.prova.endereco.Endereco;


public class FuncionarioTest {
	
	private static final String NOME = "Paulo Machado";

	private static final String CARGO = "Gerente do RH";
	
	private static final DateTime DATA_NASCIMENTO = new DateTime(2004,01,01,0,0);
	
	private static final int DATA_ANO = now().getYear() - 18;
	
	private static final String CPF = "41236207874";
	
	private static final String NOME_DEPARTAMENTO = "Recursos Humano";
	
	private static final String COD_DEPARTAMENTO = "R32EA";

	private static final String CEP = "06315270";
	
	private static final Integer NUMERO = 476;
	
	private Funcionario funcionarioBefore;
	
	private Contato contatoBefore;
	
	private Departamento departamentoBefore;
	
	private Endereco enderecoBefore;
	
	@Before
	public void criar_antes_de_todos_os_testes() {
		funcionarioBefore = new Funcionario(CPF);
		
		contatoBefore = new Contato("5511963481012","email@gmail.com");
		
		departamentoBefore = new Departamento(NOME_DEPARTAMENTO,COD_DEPARTAMENTO);
		
		enderecoBefore = new Endereco(CEP,NUMERO);
	}
	
	@Test
	public void test_deve_criar_funcionario_com_cpf_nome_e_data_nascimento() {
		assertEquals(funcionarioBefore,new Funcionario(CPF));
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_segundo_digito_invalido() {
		new Funcionario("72441531060");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_primeiro_digito_invalido() {
		new Funcionario("41236207844");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_nulo() {
		new Funcionario(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_contendo_digitos_sequencial() {
		new Funcionario("11111111111");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_contendo_digitos_a_menos() {
		new Funcionario("321232123");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_contendo_digitos_a_mais() {
		new Funcionario("31231232132312");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_vazio() {
		new Funcionario("");
	}
	
	@Test
	public void testA_deve_criar_um_funcionario_com_o_nome_valido() {
		Funcionario funcionario = new Funcionario(CPF);
		funcionario.setNomeCompleto(NOME);
		assertSame(funcionario.getNomeCompleto(),funcionario.getNomeCompleto());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testB_nao_deve_criar_funcionario_com_o_nome_menor_que_5_caracteres() {
		funcionarioBefore.setNomeCompleto("Jose");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testC_nao_deve_criar_funcionario_com_o_nome_maior_que_60_caracteres() {
		funcionarioBefore.setNomeCompleto("Jose jose jose jose jose jose jose jose jose jose jose jose jose");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testD_nao_deve_criar_funcionario_com_o_nome_vazio() {
		funcionarioBefore.setNomeCompleto("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testD_nao_deve_criar_funcionario_com_o_nome_possuindo_espacos() {
		funcionarioBefore.setNomeCompleto("           ");
	}
	
	@Test
	public void testD_deve_criar_funcionario_com_o_nome_possuindo_espacos_e_letras() {
		String nomeCompleto = "       Paulo Machado          FRaga            Matos            ";
		funcionarioBefore.setNomeCompleto(nomeCompleto);
		assertEquals(nomeCompleto, funcionarioBefore.getNomeCompleto());
	}
	
	@Test
	public void test_deve_criar_funcionario_com_acento() {
		String nomeCompleto = "José Cardoso";
		funcionarioBefore.setNomeCompleto(nomeCompleto);
		assertEquals(nomeCompleto, funcionarioBefore.getNomeCompleto());
	}
	
	@Test
	public void test_deve_settar_um_novo_nome_ao_funcionario() {
		String nomeCompleto = "Paulo Machado Fraga Matos M";
		
		funcionarioBefore.setNomeCompleto(nomeCompleto);
		
		assertSame(nomeCompleto, funcionarioBefore.getNomeCompleto());
	}
	
	@Test
	public void testF_deve_retornar_nome_do_funcionario() {
		funcionarioBefore.setNomeCompleto(NOME);
		
		assertEquals(NOME, funcionarioBefore.getNomeCompleto());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testG_nao_deve_criar_funcionario_com_numeros_invalidos_no_cpf() {
		new Funcionario("41236207873");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testH_nao_deve_criar_funcionario_com_quantidade_de_digitos_a_mais_no_cpf() {
		new Funcionario("412362078744");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testI_nao_deve_criar_funcionario_com_quantidade_de_digitos_a_menos_no_cpf() {
		new Funcionario("4123620784");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testJ_nao_deve_criar_funcionario_com_segundo_digito_verificador_invalido_no_cpf() {
		new Funcionario("41236207875");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testK_nao_deve_criar_funcionario_com_cpf_sequencial() {
		new Funcionario("11111111111");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testL_nao_deve_criar_funcionario_com_letras_no_cpf() {
		new Funcionario("321321a1213");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testM_nao_deve_criar_funcionario_com_cpf_vazio() {
		new Funcionario("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testN_nao_deve_criar_funcionario_com_cpf_nulo() {
		new Funcionario(null);
	}
	
	//
	
	@Test(expected = IllegalStateException.class)
	public void testG_nao_deve_settar_funcionario_com_numeros_invalidos_no_cpf() {
		funcionarioBefore.setCpf("41236207873");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testH_nao_deve_settar_funcionario_com_quantidade_de_digitos_a_mais_no_cpf() {
		funcionarioBefore.setCpf("412362078744");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testI_nao_deve_settar_funcionario_com_quantidade_de_digitos_a_menos_no_cpf() {
		funcionarioBefore.setCpf("4123620784");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testJ_nao_deve_settar_funcionario_com_segundo_digito_verificador_invalido_no_cpf() {
		funcionarioBefore.setCpf("41236207875");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testK_nao_deve_settar_funcionario_com_cpf_sequencial() {
		funcionarioBefore.setCpf("11111111111");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testL_nao_deve_settar_funcionario_com_letras_no_cpf() {
		funcionarioBefore.setCpf("321321a1213");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testM_nao_deve_settar_funcionario_com_cpf_vazio() {
		funcionarioBefore.setCpf("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testN_nao_deve_settar_funcionario_com_cpf_nulo() {
		funcionarioBefore.setCpf(null);
	}
	
	@Test
	public void testO_deve_criar_funcionario_com_cpf_valido() {
		String CPF_2 = "24783928010";
		assertSame(CPF_2,new Funcionario(CPF_2).getCpf());
	}
	
	@Test
	public void test_deve_settar_um_novo_cpf_ao_funcionario() {
		String cpf2 = "38349633050";
		
		funcionarioBefore.setCpf(cpf2);
		
		assertSame(cpf2,funcionarioBefore.getCpf());
	}
	
	@Test
	public void tesP_deve_retornar_cpf() {
		assertSame(CPF,funcionarioBefore.getCpf());
	}
	//
	
	@Test(expected = IllegalStateException.class)
	public void testQ_nao_deve_criar_funcionario_com_data_de_nascimento_vazia() {
		funcionarioBefore.setDataNascimento(new DateTime());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testR_nao_deve_criar_funcionario_com_data_de_nascimento_nulo() {
		funcionarioBefore.setDataNascimento(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testS_nao_deve_criar_funcionario_com_data_de_nascimento_menor_que_18() {
		funcionarioBefore.setDataNascimento(new DateTime(DATA_ANO,06,7,0,0));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testT_nao_deve_criar_funcionario_com_data_de_nascimento_menor_que_18_por_conta_de_meses() {
		funcionarioBefore.setDataNascimento(new DateTime(DATA_ANO + 1,parseInt(String.valueOf(DateTime.now().getMonthOfYear())),parseInt(String.valueOf(DateTime.now().getDayOfMonth())) + 1,0,0));
	}
	
	//
	
	@Test(expected = IllegalStateException.class)
	public void testQ_nao_deve_settar_funcionario_com_data_de_nascimento_vazia() {
		funcionarioBefore.setDataNascimento(new DateTime(DATA_ANO,06,8,0,0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testR_nao_deve_settar_funcionario_com_data_de_nascimento_nulo() {
		funcionarioBefore.setDataNascimento(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testS_nao_deve_settar_funcionario_com_data_de_nascimento_menor_que_18() {
		funcionarioBefore.setDataNascimento(new DateTime(DATA_ANO,06,7,0,0));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testT_nao_deve_settar_funcionario_com_data_de_nascimento_menor_que_18_por_conta_de_meses() {
		funcionarioBefore.setDataNascimento(new DateTime(DATA_ANO,parseInt(String.valueOf(DateTime.now().getMonthOfYear())),parseInt(String.valueOf(DateTime.now().getDayOfMonth())) + 2,0,0));
	}
	
	@Test
	public void testU_deve_criar_funcionario_com_data_de_nascimento_maior_que_18_por_conta_de_meses() {
		DateTime DATA_NASCIMENTO_2 = new DateTime(2004,1,2,0,0);
		funcionarioBefore.setDataNascimento(DATA_NASCIMENTO_2);
		assertEquals(DATA_NASCIMENTO_2, funcionarioBefore.getDataNascimento());
	}
	
	@Test
	public void testV_deve_criar_funcionario_com_data_de_nascimento_maior_que_18() {
		DateTime DATA_NASCIMENTO_3 = new DateTime(2002,11,1,0,0);
		funcionarioBefore.setDataNascimento(DATA_NASCIMENTO_3);
		assertEquals(DATA_NASCIMENTO_3, funcionarioBefore.getDataNascimento());
	}
	
	@Test
	public void test_deve_settar_idade_valida_ao_funcionario() {
		DateTime DATA_NASCIMENTO_2 = new DateTime(2004,1,1,0,0);
		
		funcionarioBefore.setDataNascimento(DATA_NASCIMENTO_2);
		
		assertSame(DATA_NASCIMENTO_2,funcionarioBefore.getDataNascimento());
	}
	
	@Test
	public void testW_deve_retornar_a_data_de_nascimento_do_funcionario() {
		funcionarioBefore.setDataNascimento(DATA_NASCIMENTO);
		
		assertSame(DATA_NASCIMENTO,funcionarioBefore.getDataNascimento());
	}
	
	@Test
	public void testX_deve_criar_funcionario_com_cargo_valido() {
		
		funcionarioBefore.setCargo(CARGO);
		
		assertSame(CARGO,funcionarioBefore.getCargo());
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void testY_nao_deve_settar_funcionario_com_o_cargo_menor_que_5_caracteres() {
		funcionarioBefore.setCargo("SEM");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testZ_nao_deve_settar_funcionario_com_o_cargo_maior_que_60_caracteres() {
		funcionarioBefore.setCargo("Possui mais de sessenta caracteres Possui mais de sessenta caracteres");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testAA_nao_deve_settar_funcionario_com_o_cargo_contendo_numeros() {
		funcionarioBefore.setCargo("Analista 2");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testAB_nao_deve_settar_funcionario_com_o_cargo_vazio() {
		funcionarioBefore.setCargo("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testAB_nao_deve_settar_funcionario_com_o_cargo_possuindo_espacos() {
		funcionarioBefore.setCargo("           Cara ");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAC_nao_deve_settar_funcionario_com_o_cargo_nulo() {
		funcionarioBefore.setCargo(null);
	}
	
	@Test
	public void test_deve_settar_novo_cargo_a_funcionario() {
		String cargoFuncionario = "Estagiario";
		
		funcionarioBefore.setCargo(cargoFuncionario);
		
		assertSame(cargoFuncionario,funcionarioBefore.getCargo());
	}
	
	@Test
	public void testAD_deve_retornar_o_cargo() {
		funcionarioBefore.setCargo(CARGO);
		
		assertSame(CARGO,funcionarioBefore.getCargo());
	}
	
	@Test
	public void test_deve_adicionar_um_contato_valido_ao_funcionario() {
		funcionarioBefore.setContato(contatoBefore);
		assertSame(contatoBefore,funcionarioBefore.getContato());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_adicionar_um_contato_nulo_ao_funcionario() {
		funcionarioBefore.setContato(null);
	}
	
	@Test
	public void test_deve_retornar_contato_adicionado() {
		funcionarioBefore.setContato(contatoBefore);
		assertSame(contatoBefore,funcionarioBefore.getContato());
	}
	
	@Test
	public void test_deve_referenciar_departamento_a_qual_funcionario_pertence() {
		funcionarioBefore.setDepartamento(departamentoBefore);
		assertSame(departamentoBefore,funcionarioBefore.getDepartamento());
	}
	
	@Test(expected =  IllegalArgumentException.class)
	public void test_nao_deve_referenciar_departamento_caso_seja_nulo() {
		funcionarioBefore.setDepartamento(null);
	}
	
	@Test
	public void test_deve_retornar_departamento_a_qual_o_funcionario_pertence() {
		funcionarioBefore.setDepartamento(departamentoBefore);
		assertSame(departamentoBefore,funcionarioBefore.getDepartamento());
	}
	
	@Test
	public void test_deve_adicionar_um_endereco_ao_funcionario() {
		funcionarioBefore.setEndereco(enderecoBefore);
		assertSame(enderecoBefore,funcionarioBefore.getEndereco());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_adicionar_um_endereco_nulo_ao_funcionario() {
		funcionarioBefore.setEndereco(null);
	}
	
	@Test
	public void test_de_retornar_endereco_do_funcionario() {
		funcionarioBefore.setEndereco(enderecoBefore);
		assertSame(enderecoBefore,funcionarioBefore.getEndereco());
	}
	
	@Test
	public void testAE_nao_deve_retornar_igualdade_ao_comparar_objetos_diferentes() {
		assertNotEquals(funcionarioBefore,new Object());
	}
	
	@Test
	public void testAF_nao_deve_retornar_igualdade_ao_comparar_funcionarios_com_atributos_diferentes() {
		assertNotEquals(funcionarioBefore, new Funcionario("24783928010"));
	}
	
	@Test
	public void testAG_nao_deve_retornar_igualdade_ao_comparar_funcionario_com_objeto_nulo() {
		assertNotEquals(funcionarioBefore,null);
	}
	
	@Test
	public void testAH_deve_retornar_igualdade_ao_comparar_funcionarios_com_mesmos_atributos() {
		assertEquals(funcionarioBefore,new Funcionario(CPF));
	}
	
	@Test
	public void testAI_deve_retornar_igualdade_ao_comparar_funcionario_com_o_mesmo_funcionario() {
		assertEquals(funcionarioBefore,this.funcionarioBefore);
	}
	
	@Test
	public void testAJ_deve_retornar_igualdade_ao_comparar_o_hashcode_do_mesmo_funcionario() {
		assertEquals(funcionarioBefore.hashCode(),funcionarioBefore.hashCode());
	}
	
	@Test
	public void testAK_nao_deve_retornar_igualdade_no_hashcode_ao_comparar_funcionarios_diferentes() {
		assertNotEquals(funcionarioBefore.hashCode(),new Funcionario("24783928010").hashCode());
	}
	
	@Test
	public void testAL_deve_retornar_o_tostring_contendo_todos_os_atributos_passados() {
		funcionarioBefore.setNomeCompleto(NOME);
		
		funcionarioBefore.setDataNascimento(DATA_NASCIMENTO);
		
		funcionarioBefore.setCargo(CARGO);
		
		assertTrue(funcionarioBefore.toString().contains(NOME));
		
		assertTrue(funcionarioBefore.toString().contains(CPF));
		
		assertTrue(funcionarioBefore.toString().contains(DATA_NASCIMENTO.toString()));
		
		assertTrue(funcionarioBefore.toString().contains(CARGO));
		
		funcionarioBefore.setContato(contatoBefore);
		
		assertTrue(funcionarioBefore.toString().contains(contatoBefore.toString()));
	}
	
}
