package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.contato.Contato;

public class ContatoTest {
	
	private static final String EMAIL = "email@gmail.com";
	
	private static final String CELULAR = "5511963481012";
	
	private Contato contatoBefore;
	
	@Before
	public void criar_antes_de_todos_os_testes() {
		contatoBefore = new Contato(CELULAR,EMAIL);
	}
	
	@Test
	public void testA_deve_criar_o_contato_com_celular_e_email_valido() {
		Contato contato = new Contato(CELULAR,EMAIL);
		
		assertEquals(CELULAR,contato.getCelular());
		
		assertEquals(EMAIL,contato.getEmail());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testB_nao_deve_criar_contato_com_celular_com_digitos_invalido() {
		new Contato("551196348101", EMAIL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testC_nao_deve_criar_contato_com_ddi_sem_ser_do_brasil() {
		new Contato("5311963481012", EMAIL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testD_nao_deve_criar_contato_com_celular_vazio() {
		new Contato("", EMAIL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testE_nao_deve_criar_contato_com_celular_nulo() {
		new Contato(null, EMAIL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testF_nao_deve_criar_contato_com_letras_no_celular() {
		new Contato("55119a63481012", EMAIL);
	}
	
	@Test
	public void testF_deve_criar_contato_com_espacos_no_comeco_e_no_fim() {
		String celular2 = "        5511963481012                            ";
		
		assertEquals(celular2,new Contato(celular2, EMAIL).getCelular());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testF_nao_deve_criar_contato_com_espacos() {
		new Contato("                                    ", EMAIL);
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void testB_nao_deve_settar_contato_com_celular_com_digitos_invalidos() {
		contatoBefore.setCelular("551196348101");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testF_nao_deve_settar_contato_com_espacos() {
		contatoBefore.setCelular("                                    ");
	}
	
	@Test
	public void testF_deve_settar_contato_com_espacos_no_comeco_e_no_fim() {
		String celular2 = "        5511963481012                            ";
		
		contatoBefore.setCelular(celular2);
		
		assertEquals(celular2,contatoBefore.getCelular());
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testC_nao_deve_settar_contato_com_ddi_sem_ser_do_brasil() {
		String celular = "5311963481012";
		contatoBefore.setCelular(celular);

	}
	
	@Test(expected = IllegalStateException.class)
	public void testD_nao_deve_settar_contato_com_celular_vazio() {
		contatoBefore.setCelular("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testE_nao_deve_settar_contato_com_celular_nulo() {
		contatoBefore.setCelular(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testF_nao_deve_settar_contato_com_letras_no_celular() {
		String celular = "55119a63481012";
		
		contatoBefore.setCelular(celular);
	}
	
	@Test
	public void test_deve_settar_celular_valido() {
		String celular = "5511963481011";
		
		contatoBefore.setCelular(celular);
		
		assertSame(celular,contatoBefore.getCelular());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testG_nao_deve_criar_contato_com_email_invalido() {
		new Contato(CELULAR, "email@gmailcom");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testH_nao_deve_criar_contato_com_email_vazio() {
		new Contato(CELULAR,"");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testeI_nao_deve_criar_contato_com_email_nulo() {
		new Contato(CELULAR, null);
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void testG_nao_deve_settar_contato_com_email_invalido() {
		String email = "email@gmailcom";
		
		contatoBefore.setEmail(email);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testH_nao_deve_settar_contato_com_email_vazio() {
		contatoBefore.setEmail("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testH_nao_deve_settar_contato_com_email_menor_que_3() {
		contatoBefore.setEmail("ae");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testeI_nao_deve_settar_contato_com_email_nulo() {
		contatoBefore.setEmail(null);
	}
	
	@Test
	public void test_deve_settar_novo_email_valido() {
		String email = "machado@gmail.com";
		
		contatoBefore.setEmail(email);
		
		assertSame(email, contatoBefore.getEmail());
	}
	
	@Test
	public void testJ_deve_retornar_o_email() {
		String email = EMAIL;
		
		Contato c1 = new Contato("5511323232323", email);
		
		assertEquals(c1.getEmail(), email);
	}
	
	@Test
	public void testK_deve_retornar_o_telefone() {
		String celular = "5512321321313";
		
		Contato c1  = new Contato(celular, EMAIL);
		
		assertEquals(c1.getCelular(), celular);
	}
	
	@Test
	public void testL_deve_retornar_hashcode_diferente_para_contatos_diferentes() {
		Contato c1  = new Contato("5512321321313", EMAIL);
		
		assertNotEquals(c1.hashCode(), contatoBefore.hashCode());
	}
	
	@Test
	public void testM_deve_retornar_igualdade_ao_comparar_o_mesmo_objeto() {
		assertEquals(contatoBefore, this.contatoBefore);
	}
	
	@Test
	public void testN_deve_retornar_igualdade_ao_comparar_objetos_com_os_mesmos_atributos() {
		Contato c1 = new Contato(CELULAR, EMAIL);
		assertEquals(contatoBefore, c1);
	}
	
	@Test
	public void testO_deve_retornar_falso_ao_comparar_contato_com_objetos_de_classes_diferentes() {
		Object ob1 = new Object();
		assertNotEquals(contatoBefore, ob1);
	}
	
	@Test
	public void testP_deve_retorna_falso_ao_comparar_contato_com_objetos_nulos() {
		assertNotEquals(contatoBefore, null);
	}
	
	@Test
	public void testQ_deve_verificar_se_contato_possui_todos_os_atributos_corretamente() {
		String celular = CELULAR;
		
		String email = EMAIL;
		
		Contato c1 = new Contato(celular, email);
		
		assertTrue(c1.toString().contains(email));
		
		assertTrue(c1.toString().contains(celular));
	}
}
