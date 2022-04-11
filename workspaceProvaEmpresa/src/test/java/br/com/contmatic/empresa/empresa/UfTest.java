package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.endereco.Uf;

public class UfTest {
	
	private static final String NOME = "Paulo Machado";
	
	private static final String SIGLA = "SP";

	private static final Integer CODIGO = 12;
	
	private Uf ufBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_teste() {
		ufBefore = new Uf(CODIGO);
	}
	
	@Test
	public void deve_criar_uf_com_codigo_valido() {
		assertEquals(CODIGO,new Uf(CODIGO).getCodigo());
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_criar_uf_com_codigo_invalido() {
		new Uf(144);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_uf_com_codigo_nulo() {
		new Uf(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_settar_codigo_invalido() {
		ufBefore.setCodigo(123);
	}
	
	@Test
	public void test_deve_settar_codigo_valido() {
		Integer codigo2 = 16;
		ufBefore.setCodigo(codigo2);
		assertEquals(codigo2, ufBefore.getCodigo());
	}
	
	@Test
	public void test_deve_settar_nome_valido() {
		ufBefore.setNome(NOME);
		
		assertEquals(NOME,ufBefore.getNome());
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_settar_nome_invalido() {
		ufBefore.setNome("123");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_settar_nome_contendo_numeros() {
		ufBefore.setNome("1234");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_settar_nome_contendo_caracteres_especiais() {
		ufBefore.setNome("Paulo Machado!");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_settar_nome_contendo_mais_de_60_caracteres() {
		ufBefore.setNome("Paulo Machadoqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_settar_nome_contendo_menos_de_4_caracteres() {
		ufBefore.setNome("PAA");
	}
	
	@Test
	public void test_deve_settar_sigla_valida() {
		ufBefore.setSigla(SIGLA);
		
		assertEquals(SIGLA,ufBefore.getSigla());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_invalida() {
		ufBefore.setSigla("AAA");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_contendo_mais_de_2_caracteres() {
		ufBefore.setSigla("AAA");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_contendo_menos_de_2_caracteres() {
		ufBefore.setSigla("AAA");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_contendo_caracteres_especiais() {
		ufBefore.setSigla("A!");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_contendo_numeros() {
		ufBefore.setSigla("12");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_sigla_nula() {
		ufBefore.setSigla(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_vazia() {
		ufBefore.setSigla("");
	}
	
	@Test
	public void test_deve_retornar_codigo() {
		assertEquals(CODIGO,ufBefore.getCodigo());
	}
	
	@Test
	public void test_deve_retornar_nome() {
		ufBefore.setNome(NOME);
		assertEquals(NOME,ufBefore.getNome());
	}
	
	@Test
	public void test_deve_retornar_sigla() {
		ufBefore.setSigla(SIGLA);
		assertEquals(SIGLA, ufBefore.getSigla());
	}
	
	@Test
	public void test_uf_deve_possuir_hash_code_corretamente() {
		assertEquals(ufBefore.hashCode(), new Uf(CODIGO).hashCode());
	}
	
	@Test
	public void test_uf_deve_possuir_igualdae_com_objetos_de_mesmos_atributos() {
		assertEquals(ufBefore,new Uf(CODIGO));
	}
	
	@Test
	public void test_uf_nao_deve_possuir_igualdae_com_objetos_de_diferentes_atributos() {
		Uf obj = new Uf(52);
		
		assertNotEquals(ufBefore, obj);
	}
	
	@Test
	public void test_uf_nao_deve_possuir_igualdae_com_objeto_nulo() {
		assertNotEquals(ufBefore,null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_com_objeto_de_classes_diferentes() {
		assertNotEquals(ufBefore,new Object());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_o_mesmo_objeto() {
		Uf uf = ufBefore;
		assertEquals(uf,ufBefore);
	}
	
	@Test
	public void to_string_deve_conter_todos_os_atributos() {
		ufBefore.setNome(NOME);
		
		ufBefore.setSigla(SIGLA);
		
		assertTrue(ufBefore.toString().contains(CODIGO.toString()));
		
		assertTrue(ufBefore.toString().contains(NOME));
		
		assertTrue(ufBefore.toString().contains(SIGLA));
		
		
	
	}
	
}
