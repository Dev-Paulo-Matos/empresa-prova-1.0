package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Departamento;
import br.com.contmatic.prova.empresa.Empresa;
import br.com.contmatic.prova.empresa.Funcionario;

public class DepartamentoTest {
	
	private static final String CNPJ = "86890723000129";
	private static final String NOME = "Departamento RHA";
	private static final String CODIGO = "5A321";
	private static final String CPF_VALIDO = "72900930030";
	private Empresa empresaBefore;
	private Departamento departamentoBefore;
	private Funcionario funcionarioBefore;
	private List<Funcionario> funcionariosBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_testes() {
		empresaBefore = new Empresa(CNPJ);
		departamentoBefore = new Departamento(CODIGO, empresaBefore);
		funcionarioBefore =  new Funcionario(CPF_VALIDO, empresaBefore);
		funcionariosBefore = new ArrayList<Funcionario>();
	}
	
	@Test
	public void test_deve_criar_departamento_com_codigo_valido() {
		assertEquals(CODIGO,new Departamento(CODIGO, empresaBefore).getCodigo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_departamento_com_codigo_null() {
		new Departamento(null, empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_codigo_vazio() {
		new Departamento("", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_codigo_contendo_espacos() {
		new Departamento("     ", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_codigo_contendo_espacos_no_comeco() {
		new Departamento(" 1234", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_codigo_contendo_espacos_no_fim() {
		new Departamento("1234 ", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_codigo_contendo_espacos_no_meio() {
		new Departamento("12 34", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_contendo_caracteres_especiais() {
		new Departamento("!@#AC", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_contendo_mais_que_5_caracteres() {
		new Departamento("123456", empresaBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_contendo_menos_que_5_caracteres() {
		new Departamento("1234", empresaBefore);
	}

	@Test
	public void test_deve_criar_departamento_com_empresa_valida() {
		Empresa empresa = new Empresa(CNPJ);
		assertEquals(empresa, new Departamento(CODIGO, empresa).getEmpresa());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_departamento_com_empresa_nula() {
		new Departamento(CODIGO, null);
	}
	
	//SET DEPARTAMENTO
	
	@Test
	public void test_deve_settar_departamento_com_empresa_valida() {
		Empresa empresa = new Empresa(CNPJ);
		departamentoBefore.setEmpresa(empresa);
		assertEquals(empresa, departamentoBefore.getEmpresa());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_departamento_com_empresa_nula() {
		departamentoBefore.setEmpresa(null);
	}
	
	// SET CODIGO
	
	@Test
	public void test_deve_settar_departamento_com_codigo_valido() {
		departamentoBefore.setCodigo(CODIGO);
		assertEquals(CODIGO, departamentoBefore.getCodigo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_departamento_com_codigo_null() {
		departamentoBefore.setCodigo(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_codigo_vazio() {
		departamentoBefore.setCodigo("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_codigo_contendo_espacos() {
		departamentoBefore.setCodigo("     ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_codigo_contendo_espacos_no_comeco() {
		departamentoBefore.setCodigo(" 1234");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_codigo_contendo_espacos_no_fim() {
		departamentoBefore.setCodigo("1234 ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_codigo_contendo_espacos_no_meio() {
		departamentoBefore.setCodigo("12 34");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_contendo_caracteres_especiais() {
		departamentoBefore.setCodigo("!@#AC");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_contendo_mais_que_5_caracteres() {
		departamentoBefore.setCodigo("123456");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_contendo_menos_que_5_caracteres() {
		departamentoBefore.setCodigo("1234");
	}
	
	@Test
	public void test_deve_settar_no_departamento_nome_valido() {
		departamentoBefore.setNome(NOME);
		assertEquals(NOME, departamentoBefore.getNome());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_no_departamento_nome_nulo() {
		departamentoBefore.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_no_departamento_nome_vazio() {
		departamentoBefore.setNome("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_no_departamento_nome_com_espacos() {
		departamentoBefore.setNome("                   ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_no_departamento_nome_com_espacos_no_comeco() {
		departamentoBefore.setNome(" Departamento do RH");
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_no_departamento_nome_com_espacos_no_fim() {
		departamentoBefore.setNome("Departamento do RH ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_no_departamento_nome_com_espacos_no_meio() {
		departamentoBefore.setNome("Departamento  do RH");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_com_mais_de_60_caracteres() {
		departamentoBefore.setNome("Departamento caracteres Departamento caracteres Departamentos");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_com_menos_de_5_caracteres() {
		departamentoBefore.setNome("Depa");
	}
	
	@Test
	public void test_deve_settar_funcionarios_corretamente() {
		funcionariosBefore.add(funcionarioBefore);
		funcionariosBefore.add(funcionarioBefore);
		departamentoBefore.setFuncionarios(funcionariosBefore);
		assertEquals(funcionariosBefore, departamentoBefore.getFuncionarios());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_deve_nao_settar_funcionarios_nulo() {
		departamentoBefore.setFuncionarios(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_deve_nao_settar_lista_de_funcionarios_sem_funcionarios() {
		departamentoBefore.setFuncionarios(funcionariosBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_deve_nao_settar_lista_de_funcionarios_com_menos_de_2_funcionario() {
		funcionariosBefore.add(funcionarioBefore);
		departamentoBefore.setFuncionarios(funcionariosBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_deve_nao_settar_lista_de_funcionarios_com_mais_de_100_funcionario() {
		for(int i = 0; i <= 100;i++) {
			funcionariosBefore.add(funcionarioBefore);
		}
		departamentoBefore.setFuncionarios(funcionariosBefore);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_hashcode_de_departamentos_igual() {
		Departamento d1 = departamentoBefore;
		assertEquals(d1.hashCode(), departamentoBefore.hashCode());
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_hashcode_de_departamentos_diferentes() {
		Departamento d1 = new Departamento("4321A", empresaBefore);
		assertNotEquals(d1.hashCode(), departamentoBefore.hashCode());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_departamento_com_o_mesmo() {
		Departamento d1 = departamentoBefore;
		assertEquals(d1, departamentoBefore);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_departamentos_iguais_de_mesma_empresa() {
		Departamento d1 = new Departamento(CODIGO,empresaBefore);
		assertEquals(d1, departamentoBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_departamentos_diferentes_de_mesma_empresa() {
		Departamento d1 = new Departamento("4321A", empresaBefore);
		assertNotEquals(d1, departamentoBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_departamentos_iguais_de_empresa_diferente() {
		Departamento d1 = new Departamento(CODIGO, new Empresa("53181832000118"));
		assertNotEquals(d1, departamentoBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_departamentos_diferentes_de_empresa_diferente() {
		Departamento d1 = new Departamento("4321A", new Empresa("53181832000118"));
		assertNotEquals(d1, departamentoBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_departamento_a_valor_nulo() {
		assertNotEquals(departamentoBefore,  null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_departamento_a_outro_objeto_de_classe_diferente() {
		assertNotEquals(departamentoBefore,  new Object());
	}
	
	@Test
	public void test_deve_retornar_to_string_corretamente_com_os_valores_settados() {
		funcionariosBefore.add(funcionarioBefore);
		funcionariosBefore.add(funcionarioBefore);
		departamentoBefore.setNome(NOME);
		departamentoBefore.setFuncionarios(funcionariosBefore);
		assertTrue(departamentoBefore.toString().contains(CODIGO));
		assertTrue(departamentoBefore.toString().contains(NOME));
		assertTrue(departamentoBefore.toString().contains(empresaBefore.toString()));
		assertTrue(departamentoBefore.toString().contains(funcionarioBefore.toString()));
	}
	
}

