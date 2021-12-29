package br.com.contmatic.empresa.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.empresa.endereco.Cidade;

public class CidadeTest {
	
	private static final String UF = "SP";
	
	private static final String COD_IBGE = "13212";
	
	private static final String NOME = "Carapícuiba";

	
	private Cidade cidadeBefore;
	
	@BeforeEach
	 void deve_criar_antes_de_todos_os_teste() {
		cidadeBefore = new Cidade(COD_IBGE);
	}
	
	// C COD
	
	@Test
	void test_deve_criar_cidade_com_cod_ibge_valido() {
		Cidade c1 = new Cidade(COD_IBGE);
		
		assertEquals(COD_IBGE, c1.getCodigoIbge());
	}
	
	@Test
	void test_nao_deve_criar_cidade_com_cod_ibge_vazio() {
		assertThrows(IllegalStateException.class,()->{
			new Cidade("");
		});
	
	}
	
	@Test
	void test_nao_deve_criar_cidade_com_cod_ibge_null() {
		assertThrows(IllegalArgumentException.class,()->{
			new Cidade(null);
		});
	}
	
	@Test
	void test_nao_deve_criar_cidade_com_cod_ibge_contendo_caracteres_especiais() {
		assertThrows(IllegalStateException.class,()->{
			new Cidade("#!@!!");
		});
	}
	
	@Test
	void test_nao_deve_criar_cidade_com_cod_ibge_contendo_letras() {
		assertThrows(IllegalStateException.class,()->{
			new Cidade("Asasa");
		});
	}
		
	@Test
	void test_nao_deve_criar_cidade_com_cod_ibge_contendo_espacos() {
		assertThrows(IllegalStateException.class,()->{
			new Cidade("123 1");
		});
	}
	
	@Test
	void test_nao_deve_criar_cidade_com_cod_ibge_contendo_mais_digitos_que_o_permitido() {
		assertThrows(IllegalStateException.class,()->{
			new Cidade("123121");
		});
	}
	
	@Test
	void test_nao_deve_criar_cidade_com_cod_ibge_contendo_menos_digitos_que_o_permitido() {
		assertThrows(IllegalStateException.class,()->{
			new Cidade("1233");
		});
	}
	
	
	
	// SETT
	
	@Test
	void test_deve_settar_cidade_com_cod_ibge_valido() {
		String codigoIbge = "12345";
		
		cidadeBefore.setCodigoIbge(codigoIbge);
		
		assertEquals(codigoIbge, cidadeBefore.getCodigoIbge());
	}
	
	@Test
	void test_nao_deve_settar_cidade_com_cod_ibge_null() {
		assertThrows(IllegalArgumentException.class,()->{
			cidadeBefore.setCodigoIbge(null);
		});
	}
	
	@Test
	void test_nao_deve_settar_cidade_com_cod_ibge_vazio() {
			assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setCodigoIbge("");
		});
	}
	
	@Test
	void test_nao_deve_settar_cidade_com_cod_ibge_contendo_caracteres_especiais() {
		assertThrows(IllegalStateException.class,()->{
			cidadeBefore.setCodigoIbge("#!@!!");
		});
	}
	
	@Test
	void test_nao_deve_settar_cidade_com_cod_ibge_contendo_letras() {
		assertThrows(IllegalStateException.class,()->{
			cidadeBefore.setCodigoIbge("Asasa");
		});
	}
		
	@Test
	void test_nao_deve_settar_cidade_com_cod_ibge_contendo_espacos() {
			assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setCodigoIbge("123 1");
		});
	}
	
	@Test
	void test_nao_deve_settar_cidade_com_cod_ibge_contendo_mais_digitos_que_o_permitido() {
		assertThrows(IllegalStateException.class,()->{
			cidadeBefore.setCodigoIbge("123121");
		});
	}
	
	@Test
	 void test_nao_deve_settar_cidade_com_cod_ibge_contendo_menos_digitos_que_o_permitido() {
		assertThrows(IllegalStateException.class,()->{
			cidadeBefore.setCodigoIbge("1233");
		});
	}
	
	@Test
	 void test_deve_settar_valido_nome_a_cidade() {
		cidadeBefore.setNome(NOME);
		
		assertSame(NOME,cidadeBefore.getNome());
	}
	
	@Test
	void test_nao_deve_settar__nome_vazio() {
		assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setNome("");
		});
	}
	
	@Test
	void test_nao_deve_settar__nome_null() {
		assertThrows(IllegalArgumentException.class,()->{
		cidadeBefore.setNome(null);
		});
	}
	
	@Test
	void test_nao_deve_settar__nome_invalido_contendo_digitos_a_cidade() {
		assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setNome("12312");
		});
	}

	@Test
	void test_nao_deve_settar_nome_contendo_caracteres_especiais() {
		assertThrows(IllegalStateException.class,()->{
			cidadeBefore.setNome("!@#!@!");
		});
	}
	
	@Test
	void test_nao_deve_settar_nome_contendo_menos_de_3_caracteres() {
		assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setNome("AR");
		});
	}
	@Test
	 void test_deve_settar_uf_valido() {
		cidadeBefore.setUf(UF);
		
		assertSame(UF,cidadeBefore.getUf());
	}
	
	@Test
	 void test_nao_deve_settar_uf_com_quantidade_de_caracteres_a_mais() {
		assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setUf("PAA");
		});
		
	}
	
	@Test
	 void test_nao_deve_settar_uf_com_quantidade_de_caracteres_a_menos() {
		assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setUf("A");
		});
	}
	
	@Test
	 void test_nao_deve_settar_uf_com_digitos() {
		assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setUf("12");
		});
	}
	
	@Test
	 void test_nao_deve_settar_uf_nulo() {
		assertThrows(IllegalArgumentException.class,()->{
		cidadeBefore.setUf(null);
		});
	}
	
	@Test
	 void test_nao_deve_settar_uf_vazio() {
		assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setUf("");
		});
		
	}
	
	@Test
	 void test_deve_retornar_uf() {
		cidadeBefore.setUf(UF);
		
		assertSame(UF,cidadeBefore.getUf());
	}
	
	@Test
	 void test_nao_deve_csettaruf_contendo_caracteres_especiais() {
		assertThrows(IllegalStateException.class,()->{
		cidadeBefore.setUf("!@");
		});
	}
	
	@Test
	 void test_deve_retornar_igualdade_ao_comparar_a_cidade_com_a_mesma() {
		assertEquals(cidadeBefore,cidadeBefore);
	}
	
	@Test
	 void test_deve_retornar_igualdade_ao_comparar_objetos_com_os_mesmos_atributos_e_de_mesma_classe() {
		assertEquals(cidadeBefore,new Cidade(COD_IBGE));
	}
	
	@Test
	 void test_nao_deve_retornar_igualdade_ao_comparar_cidade_com_valor_null() {
		assertNotEquals(cidadeBefore,null);
	}
	
	@Test
	 void test_nao_deve_retornar_igualdade_de_objetos_de_classes_diferentes() {
		assertNotEquals(cidadeBefore,new Object());
	}
	
	@Test
	 void test_deve_retornar_igualdade_ao_comparar_o_hash_code_de_objetos_com_os_mesmos_atributos() {
		assertEquals(cidadeBefore.hashCode(), new Cidade(COD_IBGE).hashCode());
	}
	
	@Test
	 void test_nao_deve_retornar_igualdade_ao_comparar_hash_code_de_objetos_com_atributos_diferentes() {
		assertNotEquals(cidadeBefore.hashCode(), new Cidade("12312").hashCode());
	}
	
	@Test
	 void test_deve_retornar_to_string_contendo_todos_os_atributos() {
		cidadeBefore.setNome(NOME);
		
		cidadeBefore.setUf(UF);
		
		assertTrue(cidadeBefore.toString().contains(COD_IBGE));
		
		assertTrue(cidadeBefore.toString().contains(NOME));
		
		assertTrue(cidadeBefore.toString().contains(UF));

	}
}
	
