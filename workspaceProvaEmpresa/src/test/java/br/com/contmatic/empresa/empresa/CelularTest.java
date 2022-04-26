package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.contato.Celular;

public class CelularTest {
	
	private static final String TELEFONE = "963481012";
	private static final String DDD = "11";
	private static final String DDI = "55";
	private Celular celularBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_testes() {
		celularBefore = new Celular(DDI, DDD, TELEFONE);
	}
	
	@Test
	public void test_deve_criar_celular_com_ddi_valido() {
		Celular c1 = new Celular(DDI, DDD, TELEFONE);
		assertEquals(DDI, c1.getDdi());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_celular_com_ddi_nulo() {
		new Celular(null, DDD, TELEFONE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_ddi_contendo_letras() {
		new Celular("AA", DDD, TELEFONE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_ddi_contendo_mais_que_4_caracteres() {
		new Celular("1234", DDD, TELEFONE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_ddi_vazio() {
		new Celular("", DDD, TELEFONE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_ddi_contendo_caracteres_especiais() {
		new Celular("!@", DDD, TELEFONE);
	}
	
	@Test
	public void test_deve_criar_celular_com_ddd_valido() {
		Celular c1 = new Celular(DDI, DDD, TELEFONE);
		assertEquals(DDD, c1.getDd());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_celular_com_ddd_nulo() {
		new Celular(DDI, null, TELEFONE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_ddd_contendo_letras() {
		new Celular(DDI, "AA", TELEFONE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_ddd_contendo_mais_que_4_caracteres() {
		new Celular(DDI, "1234", TELEFONE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_ddd_vazio() {
		new Celular(DDI, "", TELEFONE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_ddd_contendo_caracteres_especiais() {
		new Celular(DDI, "!@", TELEFONE);
	}
	
	//TELEFONE
	
	@Test
	public void test_deve_criar_celular_com_telefone_valido() {
		Celular c1 = new Celular(DDI, DDD, TELEFONE);
		assertEquals(TELEFONE, c1.getTelefone());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_celular_com_telefone_nulo() {
		new Celular(DDI, DDD, null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_telefone_contendo_letras() {
		new Celular(DDI, DDD, "1231231A3");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_telefone_contendo_mais_que_9_caracteres() {
		new Celular(DDI, DDD, "1232123212");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_telefone_vazio() {
		new Celular(DDI, DDD, "");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_celular_com_telefone_contendo_caracteres_especiais() {
		new Celular(DDI, DDD, "!123142@");
	}
	
	// SETT
	
	@Test
	public void test_deve_settar_ddi_valido() {
		String ddi = "12";
		celularBefore.setDdi(ddi);
		assertEquals(ddi, celularBefore.getDdi());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_celular_com_ddi_nulo() {
		celularBefore.setDdi(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_ddi_contendo_letras() {
		celularBefore.setDdi("AA");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_ddi_contendo_mais_que_4_caracteres() {
		celularBefore.setDdi("1234");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_ddi_vazio() {
		celularBefore.setDdi("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_ddi_contendo_caracteres_especiais() {
		celularBefore.setDdi("!@");
	}
	
	@Test
	public void test_deve_settar_celular_com_ddd_valido() {
		String ddd = "32";
		celularBefore.setDd(ddd);
		assertEquals(ddd, celularBefore.getDd());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_celular_com_ddd_nulo() {
		celularBefore.setDd(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_ddd_contendo_letras() {
		celularBefore.setDd("AA");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_ddd_contendo_mais_que_4_caracteres() {
		celularBefore.setDd("1234");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_ddd_vazio() {
		celularBefore.setDd("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_ddd_contendo_caracteres_especiais() {
		celularBefore.setDd("!@");
	}
	
	//TELEFONE
	
	@Test
	public void test_deve_settar_celular_com_telefone_valido() {
		String telefone2 = "43434123";
		celularBefore.setTelefone(telefone2);
		assertEquals(telefone2, celularBefore.getTelefone());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_celular_com_telefone_nulo() {
		celularBefore.setTelefone(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_telefone_contendo_letras() {
		celularBefore.setTelefone("1231231A3");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_telefone_contendo_mais_que_9_caracteres() {
		celularBefore.setTelefone("1232123212");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_telefone_vazio() {
		celularBefore.setTelefone("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_celular_com_telefone_contendo_caracteres_especiais() {
		celularBefore.setTelefone("!123142@");
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_hashcode_de_celulares_iguais() {
		Celular c1 = celularBefore;
		assertEquals(celularBefore.hashCode(), c1.hashCode());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_o_mesmo_celular() {
		Celular c1 = celularBefore;
		assertEquals(celularBefore, c1);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_celulares_iguais() {
		assertEquals(celularBefore, new Celular(DDI, DDD, TELEFONE));
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_celulares_com_ddi_diferente() {
		assertNotEquals(celularBefore, new Celular("33", DDD, TELEFONE));
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_celulares_com_ddd_diferente() {
		assertNotEquals(celularBefore, new Celular(DDI, "32", TELEFONE));
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_celulares_com_telefone_diferente() {
		assertNotEquals(celularBefore, new Celular(DDI, DDD, "32131233"));
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_celular_com_valor_nulo() {
		assertNotEquals(celularBefore, null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_celular_com_objeto_de_classe_diferente() {
		assertNotEquals(celularBefore, new Object());
	}
	
	@Test
	public void test_deve_retornar_tostring_corretamente() {
		assertTrue(celularBefore.toString().contains(DDD));
		assertTrue(celularBefore.toString().contains(DDI));
		assertTrue(celularBefore.toString().contains(TELEFONE));
	}
}
