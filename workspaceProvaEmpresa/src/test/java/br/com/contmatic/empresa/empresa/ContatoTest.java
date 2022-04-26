package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.contato.Celular;
import br.com.contmatic.prova.contato.Contato;

public class ContatoTest {

	private static final String  NUMERO_TELEFONE = "963481012";
	private static final String DDD = "11";
	private static final String DDI = "55";
	private static final String EMAIL = "machdopaulof@gmail.com";
	private Contato contatoBefore;
	private Celular celularBefore;
	
	@Before
	public void criar_antes_todos_os_testes() {
		celularBefore = new Celular(DDI, DDD, NUMERO_TELEFONE);
		contatoBefore = new Contato(celularBefore);
	}
	
	@Test
	public void test_deve_criar_contato_com_celular_valido() {
		Contato c1 = new Contato(celularBefore);
		assertEquals(celularBefore, c1.getCelular());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_contato_com_valor_nulo() {
		contatoBefore.setCelular(null);
	}
	
	@Test
	public void test_deve_settar_email_valido() {
		contatoBefore.setEmail(EMAIL);
		assertEquals(EMAIL,contatoBefore.getEmail());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_email_nulo() {
		contatoBefore.setEmail(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_email_vazio() {
		contatoBefore.setEmail("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_email_com_mais_de_60_caracteres() {
		contatoBefore.setEmail("machadomachadomachadomachadomachadopaulofmachadopaulo@gmail.com");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_email_possuindo_espacos_no_comeco() {
		contatoBefore.setEmail(" machadopaulo@gmail.com");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_email_possuindo_espacos_no_fim() {
		contatoBefore.setEmail("machadopaulo@gmail.com ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_email_com_menos_de_8_caracteres() {
		contatoBefore.setEmail("@gmail.com");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_email_possuindo_caracteres_invalidos() {
		contatoBefore.setEmail("machado!paulo@gmail.com");
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_hashcode_de_contatos_iguais() {
		Contato c1 = contatoBefore;
		assertEquals(contatoBefore.hashCode(), c1.hashCode());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_o_mesmo_contato() {
		Contato c1 = contatoBefore;
		assertEquals(contatoBefore, c1);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_contatos_iguais() {
		Contato c1 = new Contato(celularBefore);
		assertEquals(contatoBefore, c1);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_contatos_diferentes() {
		Celular celular = new Celular("55","11","96767676");
		Contato c1 = new Contato(celular);
		assertNotEquals(contatoBefore, c1);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_contato_a_valor_nulo() {
		assertNotEquals(contatoBefore, null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_contato_a_outro_objeto_de_classe_diferente() {
		assertNotEquals(contatoBefore, new Object());
	}
	
	@Test
	public void test_deve_retornar_tostring_corretamente() {
		contatoBefore.setEmail(EMAIL);
		assertTrue(contatoBefore.toString().contains(EMAIL));
		assertTrue(contatoBefore.toString().contains(celularBefore.toString()));
	}
}
