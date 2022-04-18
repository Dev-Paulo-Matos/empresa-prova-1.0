package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.contato.Celular;
import br.com.contmatic.prova.contato.Contato;
import br.com.contmatic.prova.empresa.Departamento;
import br.com.contmatic.prova.empresa.Empresa;
import br.com.contmatic.prova.empresa.Funcionario;
import br.com.contmatic.prova.endereco.Endereco;

public class FuncionarioTest {

	private static final String DEPARTAMENTO_CODIGO = "23123";
	private static final String CARGO = "Faxineiro I";
	private static final LocalDate IDADE_18 = LocalDate.now().plusYears(-18);
	private static final int NUMERO = 476;
	private static final String CEP = "06315270";
	private static final String NOME = "Paulo Machado Fraga Matos";
	private static final String CNPJ_VALIDO = "33613835000176";
	private static final String CPF_VALIDO = "72900930030";
	private Funcionario funcionarioBefore;
	private Empresa empresaBefore;
	private Endereco enderecoBefore;
	private Departamento departamentoBefore;
	private Celular celularBefore;
	private Contato contatoBefore;
	private List<Contato> contatosBefore;
	
	@Before
	public void criar_antes_de_todos_os_testes() {
		empresaBefore = new Empresa(CNPJ_VALIDO);
		funcionarioBefore = new Funcionario(CPF_VALIDO, empresaBefore);
		enderecoBefore = new Endereco(CEP, NUMERO);
		departamentoBefore = new Departamento(DEPARTAMENTO_CODIGO, empresaBefore);
		celularBefore = new Celular("55","11","963481012");
		contatoBefore = new Contato(celularBefore);
		contatosBefore = new ArrayList<Contato>(); 
	}
	
	@Test
	public void test_deve_criar_funcionario_com_cpf_valido() {
		assertEquals(CPF_VALIDO, funcionarioBefore.getCpf());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_com_o_primeiro_digito_verificador_invalido() {
		new Funcionario("41236207864", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_com_o_segundo_digito_verificador_invalido() {
		new Funcionario("41236207871", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_contendo_digitos_a_mais_do_permitido() {
		new Funcionario("412362078744", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_contendo_digitos_a_menos_do_permitido() {
		new Funcionario("4123620787", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_sequencial() {
		new Funcionario("11111111111", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_contendo_caracteres_especiais() {
		new Funcionario("4123620787@", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_contendo_letras() {
		new Funcionario("123BCEFDGSA", empresaBefore);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_nulo() {
		new Funcionario(null, empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_vazio() {
		new Funcionario("", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_vazio_e_contendo_espacos() {
		new Funcionario("                         ", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_funcionario_com_cpf_contendo_espacos() {
		new Funcionario(" 41236207874 ", empresaBefore);
	}
	
	@Test
	public void test_deve_criar_funcionario_com_empresa_valida() {
		assertEquals(empresaBefore, funcionarioBefore.getEmpresa());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_funcionario_com_empresa_nula() {
		new Funcionario(CPF_VALIDO, null);
	}
	
	//setters
	
	@Test
	public void test_deve_settar_funcionario_com_cpf_valido() {
		String cpf = "70160397065";
		funcionarioBefore.setCpf(cpf);
		assertEquals(cpf, funcionarioBefore.getCpf());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_com_o_primeiro_digito_verificador_invalido() {
		funcionarioBefore.setCpf("41236207864");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_com_o_segundo_digito_verificador_invalido() {
		funcionarioBefore.setCpf("41236207871");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_contendo_digitos_a_mais_do_permitido() {
		funcionarioBefore.setCpf("412362078744");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_contendo_digitos_a_menos_do_permitido() {
		funcionarioBefore.setCpf("4123620787");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_sequencial() {
		funcionarioBefore.setCpf("11111111111");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_contendo_caracteres_especiais() {
		funcionarioBefore.setCpf("4123620787@");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_contendo_letras() {
		funcionarioBefore.setCpf("123BCEFDGSA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_nulo() {
		funcionarioBefore.setCpf(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_vazio() {
		funcionarioBefore.setCpf("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_vazio_e_contendo_espacos() {
		funcionarioBefore.setCpf("                         ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_funcionario_com_cpf_contendo_espacos() {
		funcionarioBefore.setCpf(" 41236207874 ");
	}
	
	@Test
	public void test_deve_settar_funcionario_com_empresa_valida() {
		assertEquals(empresaBefore, funcionarioBefore.getEmpresa());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_funcionario_com_empresa_nula() {
		funcionarioBefore.setEmpresa(null);
	}
	
	// FUNCIONARIO ^EMPRESA ^CPF
	
	@Test
	public void test_deve_settar_nome_do_funcionario() {
		funcionarioBefore.setNomeCompleto(NOME);
		assertEquals(NOME, funcionarioBefore.getNomeCompleto());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_do_funcionario_contendo_caracteres_invalidos() {
		funcionarioBefore.setNomeCompleto("@Paulo Machado Fraga Matos");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_do_funcionario_contendo_numeros() {
		funcionarioBefore.setNomeCompleto("Paulo 1233");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_do_funcionario_contendo_mais_de_60_caracteres() {
		funcionarioBefore.setNomeCompleto("Paulo Machado Fraga Matos Paulo Machado Fraga Matos Paulo Machado");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_do_funcionario_contendo_menos_de_5_caracteres() {
		funcionarioBefore.setNomeCompleto("mast");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_nome_do_funcionario_null() {
		funcionarioBefore.setNomeCompleto(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_do_funcionario_vazio() {
		funcionarioBefore.setNomeCompleto("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_do_funcionario_contendo_espacos_no_comeco() {
		funcionarioBefore.setNomeCompleto("  Paulo Machado");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_do_funcionario_contendo_espacos_no_fim() {
		funcionarioBefore.setNomeCompleto("Paulo Machado    ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_do_funcionario_contendo_espacos_no_meio() {
		funcionarioBefore.setNomeCompleto("Paulo    Machado");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_do_funcionario_contendo_apenas_espacos() {
		funcionarioBefore.setNomeCompleto("      ");
	}
	
	//FUNCIONARIO ^nomeCompleto^
	
	@Test
	public void test_deve_settar_endereco_valido() {
		funcionarioBefore.setEndereco(enderecoBefore);
		assertEquals(enderecoBefore, funcionarioBefore.getEndereco());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_endereco_nulo() {
		funcionarioBefore.setEndereco(null);
	}
	
	@Test
	public void test_deve_settar_data_nascimento_no_funcionario() {
		funcionarioBefore.setDataNascimento(IDADE_18);
		assertEquals(IDADE_18, funcionarioBefore.getDataNascimento());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_data_nascimento_menor_que_18() {
		funcionarioBefore.setDataNascimento(LocalDate.now().plusYears(-17));
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_data_nascimento_futuro() {
		funcionarioBefore.setDataNascimento(LocalDate.now().plusYears(1));
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_data_nascimento_passado() {
		funcionarioBefore.setDataNascimento(LocalDate.now().plusYears(-100));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_data_nascimento_nula() {
		funcionarioBefore.setDataNascimento(null);
	}
	
	// Data Nascimento
	
	@Test
	public void test_deve_settar_cargo() {
		funcionarioBefore.setCargo(CARGO);
		assertEquals(CARGO, funcionarioBefore.getCargo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_cargo_nulo() {
		funcionarioBefore.setCargo(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cargo_com_mais_de_60_caracteres() {
		funcionarioBefore.setCargo("Cargo possuindo sessenta caracteres Cargo Possuindo SessentaA");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cargo_com_menos_de_5_caracteres() {
		funcionarioBefore.setCargo("Cara");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cargo_vazio() {
		funcionarioBefore.setCargo("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cargo_possuindo_espacos() {
		funcionarioBefore.setCargo("       ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cargo_possuindo_espacos_no_comeco() {
		funcionarioBefore.setCargo("  Programador");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cargo_possuindo_espacos_no_fim() {
		funcionarioBefore.setCargo("Programador  ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cargo_contendo_numeros() {
		funcionarioBefore.setCargo("Cargo 123");
	}
	
	//CARGO ^^
	
	@Test
	public void test_deve_settar_departamento_valido() {
		funcionarioBefore.setDepartamento(departamentoBefore);
		assertEquals(departamentoBefore, funcionarioBefore.getDepartamento());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_departamento_nulo() {
		funcionarioBefore.setDepartamento(null);
	}
	
	
	// Departamento ^^
	
	@Test
	public void test_deve_settar_contatos_valido() {
		contatosBefore.add(contatoBefore);
		funcionarioBefore.setContatos(contatosBefore);
		assertEquals(contatosBefore, funcionarioBefore.getContatos());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_contatos_nulo() {
		funcionarioBefore.setContatos(null);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_hashcode_de_funcionarios_iguais() {
		Funcionario f1 = new Funcionario(CPF_VALIDO, empresaBefore);
		assertEquals(funcionarioBefore.hashCode(), f1.hashCode());
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_hashcode_de_funcionarios_diferentes() {
		Funcionario f1 = new Funcionario("41236207874", empresaBefore);
		assertNotEquals(funcionarioBefore.hashCode(), f1.hashCode());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_funcionarios_iguais() {
		Funcionario f1 = new Funcionario(CPF_VALIDO, empresaBefore);
		assertEquals(f1, funcionarioBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_funcionarios_diferentes() {
		Funcionario f1 = new Funcionario("41236207874", empresaBefore);
		assertNotEquals(f1, funcionarioBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_funcionario_com_nulo() {
		Funcionario f1 = new Funcionario("41236207874", empresaBefore);
		assertNotEquals(f1, null);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_o_proprio_funcionario() {
		assertEquals(funcionarioBefore, funcionarioBefore);
	}
}
