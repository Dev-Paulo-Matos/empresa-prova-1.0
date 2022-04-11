package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.endereco.Cidade;
import br.com.contmatic.prova.endereco.Uf;

public class CidadeTest {
	
	private static final Uf UF = new Uf(12);

	private static final Integer COD_IBGE = 13212;
	
	private static final String NOME = "Carapícuiba";

	private Cidade cidadeBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_teste() {
		cidadeBefore = new Cidade(COD_IBGE);
	}
	
	@Test
	public void test_deve_criar_cidade_com_cod_ibge_valido() {
		Cidade c1 = new Cidade(COD_IBGE);
		
		assertEquals(COD_IBGE.toString(), c1.getCodigoIbge().toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_cidade_com_cod_ibge_null() {
		new Cidade(null);
	}
	
	@Test
	public void test_deve_settar_cidade_com_cod_ibge_valido() {
		Integer codigoIbge = 12345;
		
		cidadeBefore.setCodigoIbge(codigoIbge);
		
		assertEquals(codigoIbge.toString(), cidadeBefore.getCodigoIbge().toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_cidade_com_cod_ibge_null() {
		cidadeBefore.setCodigoIbge(null);
	} 
	
	@Test
	public void test_deve_settar_valido_nome_a_cidade() {
		cidadeBefore.setNome(NOME);
		
		assertSame(NOME,cidadeBefore.getNome());
	}
	
	@Test
	public void test_deve_settar_uf_valido() {
		final Uf uf = UF;
		cidadeBefore.setUf(uf);
		assertEquals(uf,cidadeBefore.getUf());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uf_invalido() {
		cidadeBefore.setUf(new Uf(1234512));

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
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_vazio() {
		cidadeBefore.setNome("           ");
	}
	
	@Test
	public void test_deve_deve_settar_nome_com_espacos_no_comeco_e_no_fim() {
		String nome2 = "                   Paulo Machado Fraga Matos                        ";
		cidadeBefore.setNome(nome2);
		assertEquals(nome2,cidadeBefore.getNome());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_uf_nulo() {
		cidadeBefore.setUf(null);
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
		assertNotEquals(cidadeBefore.hashCode(), new Cidade(12314).hashCode());
	}
	
	@Test
	public void test_deve_retornar_to_string_contendo_todos_os_atributos() {
		cidadeBefore.setNome(NOME);
		
		cidadeBefore.setUf(UF);
		
		assertTrue(cidadeBefore.toString().contains(COD_IBGE.toString()));
		
		assertTrue(cidadeBefore.toString().contains(UF.toString()));
		
		assertTrue(cidadeBefore.toString().contains(NOME));
		

	}
}
	
