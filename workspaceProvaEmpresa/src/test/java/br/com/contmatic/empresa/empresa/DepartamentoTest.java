package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Departamento;
import br.com.contmatic.prova.empresa.Empresa;
import br.com.contmatic.prova.empresa.Funcionario;

public class DepartamentoTest {
	
	private static final String NOME = "Recursos Humano";
	
	private static final String COD_DEPARTAMENTO = "R32EA";
	
	private static final String RAZAO_SOCIAL = "Ong Amigos do Planeta";
	
	private static final String CNPJ_VALIDO = "53169215000105";
	
	private Funcionario funcionario1;
	
	private Funcionario funcionario2;

	private Funcionario funcionario3;
	
	private Departamento departamentoBefore;
	
	private List<Funcionario> funcionarios;
	
	private Empresa empresaBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_testes() {
		funcionario1 = new Funcionario("Paulo Machado","41236207874",new DateTime(2003,06,7,0,0),"Gerente");
		
		funcionario2 = new Funcionario("Paulo Machado","41236207874",new DateTime(2003,06,7,0,0),"Gerente");

		funcionario3 = new Funcionario("Paulo Machado","41236207874",new DateTime(2003,06,7,0,0),"Gerente");

		departamentoBefore = new Departamento(NOME,COD_DEPARTAMENTO);
		
		empresaBefore = new Empresa(CNPJ_VALIDO,RAZAO_SOCIAL);
		
		funcionarios = new ArrayList<>();
	}
	
	@Test
	public void test_deve_criar_departamento_com_nome_valido() {
		assertSame(NOME, new Departamento(NOME,COD_DEPARTAMENTO).getNome());
	}
	
	@Test
	public void test_deve_settar_nome_valido_a_empresa_existente() {
		String NOME_2 = "Departamento de Financias";
		
		departamentoBefore.setNome(NOME_2);
		
		assertSame(NOME_2,departamentoBefore.getNome());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_invalido_a_empresa_existente() {
		departamentoBefore.setNome("Lua");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_departamento_com_nome_nulo() {
		departamentoBefore.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_nome_vazio() {
		departamentoBefore.setNome("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_menos_de_5_caracteres_no_nome() {
		departamentoBefore.setNome("jose");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_mais_de_60_caracteres_no_nome() {
		departamentoBefore.setNome("possuindo mais de sessenta, possuindo mais de sessenta caracteres");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_numeros_no_nome() {
		departamentoBefore.setNome("jose1234");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_departamento_com_nome_nulo() {
		new Departamento(null,COD_DEPARTAMENTO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_nome_vazio() {
		new Departamento("",COD_DEPARTAMENTO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_menos_de_5_caracteres_no_nome() {
		new Departamento("jose",COD_DEPARTAMENTO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_mais_de_60_caracteres_no_nome() {
		new Departamento("possuindo mais de sessenta, possuindo mais de sessenta caracteres",COD_DEPARTAMENTO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_numeros_no_nome() {
		new Departamento("jose1234",COD_DEPARTAMENTO);
	}
	
	@Test
	public void test_deve_criar_departamento_com_cod_departamento_valido() {
		assertSame(departamentoBefore.getCodigo(),new Departamento(NOME,COD_DEPARTAMENTO).getCodigo());
	}
	
	@Test
	public void test_deve_settar_cod_departamento_valido_a_departamento_existente() {
		String COD_DEPARTAMENTO_2 = "TCA12";
		departamentoBefore.setCodigo(COD_DEPARTAMENTO_2);
		assertSame(COD_DEPARTAMENTO_2,departamentoBefore.getCodigo());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cod_departamento_invalido_a_departamento_existente() {
		departamentoBefore.setCodigo("AACA11");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_departamento_com_cod_departamento_nulo() {
		departamentoBefore.setCodigo(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_cod_departamento_vazio() {
		departamentoBefore.setCodigo("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_cod_departamento_diferente_de_5_caracteres() {
		departamentoBefore.setCodigo("R12DA2");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_cod_departamento_possuindo_espacos() {
		departamentoBefore.setCodigo("123 A");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_departamento_com_cod_departamento_possuindo_caracteres_especiais() {
		departamentoBefore.setCodigo("123@!");
	}
	
	@Test
	public void test_deve_settar_departamento_com_cod_departamento_aceitando_letras_e_numeros() {
		String codDepartamento = "1231A";
		
		departamentoBefore.setCodigo(codDepartamento);
		
		assertSame(codDepartamento, departamentoBefore.getCodigo());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_cod_departamento_possuindo_caracteres_especiais() {
		new Departamento(NOME,"123@!");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_cod_departamento_possuindo_espacos() {
		new Departamento(NOME,"123 A");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_departamento_com_cod_departamento_nulo() {
		new Departamento(NOME,null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_cod_departamento_vazio() {
		new Departamento(NOME,"");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_departamento_com_cod_departamento_diferente_de_5_caracteres() {
		new Departamento(NOME,"R12DA2");
	}
	
	
	
	@Test
	public void test_deve_criar_departamento_com_cod_departamento_aceitando_letras_e_numeros() {
		assertSame(COD_DEPARTAMENTO,departamentoBefore.getCodigo());
	}
	
	@Test
	public void test_deve_retornar_a_lista_de_funcionarios() {
		funcionarios.add(funcionario1);
		
		funcionarios.add(funcionario2);
		
		funcionarios.add(funcionario3);
		
		departamentoBefore.setFuncionarios(funcionarios);
		
		assertSame(funcionarios,departamentoBefore.getFuncionarios());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uma_nova_lista_de_funcionarios_vazia() {
		departamentoBefore.setFuncionarios(funcionarios);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_um_valor_nulo_como_lista_de_funcionarios() {
		departamentoBefore.setFuncionarios(null);
	}
	
	@Test
	public void test_deve_referenciar_empresa_a_qual_o_departamento_pertence() {
		departamentoBefore.setEmpresa(empresaBefore);
		assertSame(empresaBefore,departamentoBefore.getEmpresa());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_referenciar_empresa_nula() {
		departamentoBefore.setEmpresa(null);
	}
	
	@Test
	public void test_deve_retornar_a_empresa_qual_departamento_pertence() {
		departamentoBefore.setEmpresa(empresaBefore);
		
		assertSame(empresaBefore,departamentoBefore.getEmpresa());
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_departamento_com_outra_classe() {
		assertNotEquals(departamentoBefore, new Object());
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_departamentos_diferentes() {
		assertNotEquals(new Departamento("Limpeza","RCA12"),departamentoBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_departamento_com_um_valor_null() {
		assertNotEquals(departamentoBefore,null);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_o_departamento_com_o_mesmo() {
		assertEquals(this.departamentoBefore,departamentoBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_o_hashcode_de_departamentos_diferentes() {
		assertNotEquals(departamentoBefore.hashCode(),new Departamento(NOME,"CA31A").hashCode());
	}
	
	@Test
	public void test_deve_retornar_se_tostring_possui_todos_os_atributos() {
		funcionarios.add(funcionario1);
		
		funcionarios.add(funcionario2);
		
		funcionarios.add(funcionario3);
		
		departamentoBefore.setFuncionarios(funcionarios);
		
		assertTrue(departamentoBefore.toString().contains(NOME));
		
		assertTrue(departamentoBefore.toString().contains(COD_DEPARTAMENTO));
		
		assertTrue(departamentoBefore.toString().contains(funcionarios.toString()));
	}
}
