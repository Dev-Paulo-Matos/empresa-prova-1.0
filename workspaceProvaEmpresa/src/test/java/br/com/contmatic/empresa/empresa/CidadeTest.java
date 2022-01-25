package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.empresa.endereco.Cidade;

public class CidadeTest {
	
	private static final String UF = "SP";
	
	private static final String COD_IBGE = "13212";
	
	private static final String NOME = "Carapícuiba";

	private Cidade cidadeBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_teste() {
		cidadeBefore = new Cidade(COD_IBGE);
	}
	
	@Test
	public void test_deve_criar_cidade_com_cod_ibge_valido() {
		Cidade c1 = new Cidade(COD_IBGE);
		
		assertEquals(COD_IBGE, c1.getCodigoIbge());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_cidade_com_cod_ibge_vazio() {
		new Cidade("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_cidade_com_cod_ibge_null() {
		new Cidade(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_cidade_com_cod_ibge_contendo_caracteres_especiais() {
		new Cidade("#!@!!");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_cidade_com_cod_ibge_contendo_letras() {
		new Cidade("Asasa");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_cidade_com_cod_ibge_contendo_espacos() {
		new Cidade("123 1");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_cidade_com_cod_ibge_contendo_mais_digitos_que_o_permitido() {
		new Cidade("123121");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_cidade_com_cod_ibge_contendo_menos_digitos_que_o_permitido() {
		new Cidade("1233");
	}
	
	
	
	// SETT
	
	@Test
	public void test_deve_settar_cidade_com_cod_ibge_valido() {
		String codigoIbge = "12345";
		
		cidadeBefore.setCodigoIbge(codigoIbge);
		
		assertEquals(codigoIbge, cidadeBefore.getCodigoIbge());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_cidade_com_cod_ibge_null() {
		cidadeBefore.setCodigoIbge(null);
	} 
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cidade_com_cod_ibge_vazio() {
		cidadeBefore.setCodigoIbge("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cidade_com_cod_ibge_contendo_caracteres_especiais() {
		cidadeBefore.setCodigoIbge("#!@!!");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cidade_com_cod_ibge_contendo_letras() {
		cidadeBefore.setCodigoIbge("Asasa");
	}
		
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cidade_com_cod_ibge_contendo_espacos() {
		cidadeBefore.setCodigoIbge("123 1");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cidade_com_cod_ibge_contendo_mais_digitos_que_o_permitido() {
		cidadeBefore.setCodigoIbge("123121");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cidade_com_cod_ibge_contendo_menos_digitos_que_o_permitido() {
		cidadeBefore.setCodigoIbge("1233");
	}
	
	@Test
	public void test_deve_settar_valido_nome_a_cidade() {
		cidadeBefore.setNome(NOME);
		
		assertSame(NOME,cidadeBefore.getNome());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar__nome_vazio() {
		cidadeBefore.setNome("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar__nome_null() {
		cidadeBefore.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar__nome_invalido_contendo_digitos_a_cidade() {
		cidadeBefore.setNome("12312");
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_contendo_caracteres_especiais() {
		cidadeBefore.setNome("!@#!@!");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_contendo_menos_de_3_caracteres() {
		cidadeBefore.setNome("AR");
	}
	
	@Test
	public void test_deve_settar_uf_valido() {
		cidadeBefore.setUf(UF);
		
		assertSame(UF,cidadeBefore.getUf());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uf_com_quantidade_de_caracteres_a_mais() {
		cidadeBefore.setUf("PAA");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uf_com_quantidade_de_caracteres_a_menos() {
		cidadeBefore.setUf("A");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uf_com_digitos() {
		cidadeBefore.setUf("12");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_uf_nulo() {
		cidadeBefore.setUf(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uf_vazio() {
		cidadeBefore.setUf("");
	}
	
	@Test
	public void test_deve_retornar_uf() {
		cidadeBefore.setUf(UF);
		
		assertSame(UF,cidadeBefore.getUf());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uf_contendo_caracteres_especiais() {
		cidadeBefore.setUf("!@");
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_a_cidade_com_a_mesma() {
		assertEquals(this.cidadeBefore,cidadeBefore);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_objetos_com_os_mesmos_atributos_e_de_mesma_classe() {
		assertEquals(cidadeBefore,new Cidade(COD_IBGE));
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_cidade_com_valor_null() {
		assertNotEquals(cidadeBefore,null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_de_objetos_de_classes_diferentes() {
		assertNotEquals(cidadeBefore,new Object());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_o_hash_code_de_objetos_com_os_mesmos_atributos() {
		assertEquals(cidadeBefore.hashCode(), new Cidade(COD_IBGE).hashCode());
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_hash_code_de_objetos_com_atributos_diferentes() {
		assertNotEquals(cidadeBefore.hashCode(), new Cidade("12312").hashCode());
	}
	
	@Test
	public void test_deve_retornar_to_string_contendo_todos_os_atributos() {
		cidadeBefore.setNome(NOME);
		
		cidadeBefore.setUf(UF);
		
		assertTrue(cidadeBefore.toString().contains(COD_IBGE));
		
		assertTrue(cidadeBefore.toString().contains(NOME));
		
		assertTrue(cidadeBefore.toString().contains(UF));

	}
}
	
