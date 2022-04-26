package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.endereco.Uf;

public class UfTest {
	
	private static final String SIGLA = "SP";
	private static final String NOME = "São Paulo";
	private static final Integer CODIGO_UF = 23;
	private Uf ufBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_testes() {
		ufBefore = new Uf(CODIGO_UF);
	}
	
	@Test
	public void test_deve_criar_uf_com_codigo_uf_valido() {
		Uf uf = new Uf(CODIGO_UF);
		assertEquals(CODIGO_UF, uf.getCodigo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_uf_com_codigo_uf_nulo() {
		new Uf(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_uf_com_codigo_uf_menor_que_11() {
		new Uf(10);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_uf_com_codigo_uf_maior_que_53() {
		new Uf(54);
	}
	
	@Test
	public void test_settar_nome_valido_a_uf() {
		ufBefore.setNome(NOME);
		assertEquals(NOME, ufBefore.getNome());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_nome_nulo() {
		ufBefore.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_vazio() {
		ufBefore.setNome("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_contendo_espacos_no_comeco() {
		ufBefore.setNome(" São Paulo");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_contendo_espacos_no_fim() {
		ufBefore.setNome("São Paulo ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_contendo_mais_de_60_caracteres() {
		ufBefore.setNome("São Paulo Paulo Sao Paulo Sao Paulo Sao Paulo São Paulo São Paulo");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_contendo_numeros() {
		ufBefore.setNome("São Paulo3");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_contendo_caracteres_especiais() {
		ufBefore.setNome("São Paulo!");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_contendo_menos_de_4_caracteres() {
		ufBefore.setNome("Acr");
	}
	
	@Test
	public void test_deve_settar_sigla_correta() {
		ufBefore.setSigla(SIGLA);
		assertEquals(SIGLA, ufBefore.getSigla());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_sigla_nula() {
		ufBefore.setSigla(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_vazia() {
		ufBefore.setSigla("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_contendo_espaco_no_comeco() {
		ufBefore.setSigla(" A");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_contendo_espacos_no_fim() {
		ufBefore.setSigla("B ");
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_possuindo_numeros() {
		ufBefore.setSigla("B3");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_possuindo_caracteres_especiais() {
		ufBefore.setSigla("!A");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_possuindo_mais_de_2_caracteres() {
		ufBefore.setSigla("BAC");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_sigla_possuindo_menos_de_2_caracteres() {
		ufBefore.setSigla("C");
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_hashcode_de_uf_iguais() {
		Uf uf = ufBefore;
		assertEquals(uf.hashCode(), ufBefore.hashCode());
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_hashcode_de_uf_diferentes() {
		Uf uf = new Uf(53);
		assertNotEquals(uf.hashCode(), ufBefore.hashCode());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_o_mesmo_uf() {
		Uf uf = ufBefore;
		assertEquals(uf, ufBefore);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_uf_iguais() {
		Uf uf = new Uf(CODIGO_UF);
		assertEquals(uf, ufBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_uf_diferentes() {
		Uf uf = new Uf(43);
		assertNotEquals(uf, ufBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_uf_com_valor_nulo() {
		assertNotEquals(ufBefore, null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_uf_com_objeto_de_classe_diferente() {
		assertNotEquals(ufBefore, new Object());
	}
	
	@Test
	public void test_deve_retornar_tostring_corretamente() {
		ufBefore.setNome(NOME);
		ufBefore.setSigla(SIGLA);
		assertTrue(ufBefore.toString().contains(CODIGO_UF.toString()));
		assertTrue(ufBefore.toString().contains(NOME));
		assertTrue(ufBefore.toString().contains(SIGLA));

	}
}
