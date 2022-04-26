package br.com.contmatic.empresa.empresa;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.endereco.Cidade;
import br.com.contmatic.prova.endereco.Uf;

public class CidadeTest {
	
	private static final int CODIGO_UF = 43;
	private static final String NOME_CIDADE = "Carapicuiba";
	private static final Integer IBGE_INTEGER = 4993243;
	private Cidade cidadeBefore;
	private Uf ufBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_testes() {
		cidadeBefore = new Cidade(IBGE_INTEGER);
		ufBefore = new Uf(CODIGO_UF);
	}
	
	@Test
	public void test_deve_criar_cidade_com_codigo_ibge_correto() {
		Cidade c1 = new Cidade(IBGE_INTEGER);
		assertEquals(valueOf(IBGE_INTEGER), c1.getCodigoIbge());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_cidade_com_codigo_ibge_nulo() {
		new Cidade(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_cidade_com_codigo_ibge_maior_que_99999() {
		new Cidade(10000000);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_cidade_com_codigo_ibge_menor_que_1() {
		new Cidade(999999);
	}
	
	
	//SET
	
	@Test
	public void test_deve_settar_cidade_com_codigo_ibge_correto() {
		Integer codigoIbge = 4332433;
		cidadeBefore.setCodigoIbge(codigoIbge);
		assertEquals(codigoIbge,cidadeBefore.getCodigoIbge());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_cidade_com_codigo_ibge_nulo() {
		cidadeBefore.setCodigoIbge(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cidade_com_codigo_ibge_maior_que_99999() {
		cidadeBefore.setCodigoIbge(10000000);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cidade_com_codigo_ibge_menor_que_1() {
		cidadeBefore.setCodigoIbge(999999);
	}
	//END SET
	
	@Test
	public void test_deve_settar_nome_corretamente() {
		cidadeBefore.setNome(NOME_CIDADE);
		assertEquals(NOME_CIDADE, cidadeBefore.getNome());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_nome_com_valor_nulo() {
		cidadeBefore.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_com_caracteres_invalidos() {
		cidadeBefore.setNome("Cidade Para!@#");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_com_numeros() {
		cidadeBefore.setNome("123123A");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_com_espacos_no_comeco() {
		cidadeBefore.setNome(" Cidade Para");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_com_espacos_no_fim() {
		cidadeBefore.setNome("Cidade Para ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_com_espacos_invalidos_no_meio() {
		cidadeBefore.setNome("Cidade      Para");
	}
	
	@Test
	public void test_deve_settar_uf_corretamente() {
		cidadeBefore.setUf(ufBefore);
		assertEquals(ufBefore, cidadeBefore.getUf());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_uf_nulo() {
		cidadeBefore.setUf(null);
	}
	
	@Test
	public void test_deve_retornar_hashcode_corretamente_com_cidades_iguais() {
		Cidade c1 = cidadeBefore;
		assertEquals(c1.hashCode(), cidadeBefore.hashCode());
	}
	
	@Test
	public void test_nao_deve_retornar_hashcode_corretamente_com_cidades_diferentes() {
		Cidade c1 = new Cidade(3212321);
		assertNotEquals(c1.hashCode(), cidadeBefore.hashCode());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_cidades_iguais() {
		Cidade c1 = new Cidade(IBGE_INTEGER);
		assertEquals(c1, cidadeBefore);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_a_mesma_cidade() {
		Cidade c1 = cidadeBefore;
		assertEquals(c1, cidadeBefore);
	}
	
	@Test
	public void test_deve_nao_retornar_igualdade_ao_comparar_cidade_a_um_valor_nulo() {
		assertNotEquals(cidadeBefore, null);
	}
	
	@Test
	public void test_deve_nao_retornar_igualdade_ao_comparar_cidade_a_um_objeto_de_classe_diferente() {
		assertNotEquals(cidadeBefore, new Object());
	}
	
	@Test
	public void test_deve_retornar_tostring_corretamente() {
		cidadeBefore.setNome(NOME_CIDADE);
		cidadeBefore.setUf(ufBefore);
		assertTrue(cidadeBefore.toString().contains(IBGE_INTEGER.toString()));
		assertTrue(cidadeBefore.toString().contains(ufBefore.toString()));
		assertTrue(cidadeBefore.toString().contains(NOME_CIDADE));
	}
	
}
