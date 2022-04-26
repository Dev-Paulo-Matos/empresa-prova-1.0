package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.endereco.Cidade;
import br.com.contmatic.prova.endereco.Endereco;

public class EnderecoTest {
	
	private static final String TIPO_LOGRADOURO = "Rua";
	private static final String BAIRRO = "Jardim das belezas";
	private static final String LOGRADOURO = "São Vicente 3";
	private static final Integer  NUMERO_ENDERECO = 4;
	private static final String CEP_ENDERECO = "06315270";
	private static final int CIDADE_CODIGO = 4323432;
	private Endereco enderecoBefore;
	private Cidade cidadeBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_testes() {
		cidadeBefore = new Cidade(CIDADE_CODIGO);
		enderecoBefore = new Endereco(CEP_ENDERECO, NUMERO_ENDERECO);
	}
	
	@Test
	public void test_deve_criar_endereco_com_cep_valido() {
		Endereco e1 = new Endereco(CEP_ENDERECO, NUMERO_ENDERECO);
		assertEquals(CEP_ENDERECO, e1.getCep());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_endereco_com_cep_nulo() {
		new Endereco(null, NUMERO_ENDERECO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_vazio() {
		new Endereco("", NUMERO_ENDERECO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_contendo_letras() {
		new Endereco("12331AVV", NUMERO_ENDERECO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_contendo_caracteres_invalidos() {
		new Endereco("12331#$#", NUMERO_ENDERECO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_contendo_mais_que_8_digitos() {
		new Endereco("123314444", NUMERO_ENDERECO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_contendo_menos_que_8_digitos() {
		new Endereco("3314444", NUMERO_ENDERECO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_contendo_espacos_no_comeco() {
		new Endereco(" 3314444", NUMERO_ENDERECO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_contendo_espacos_no_fim() {
		new Endereco("3314444 ", NUMERO_ENDERECO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_possuindo_digitos_sequenciais() {
		new Endereco("11111111", NUMERO_ENDERECO);
	}
	
	// SET
	
	@Test
	public void test_deve_settar_endereco_com_cep_valido() {
		String cep = "23123212";
		enderecoBefore.setCep(cep);
		assertEquals(cep, enderecoBefore.getCep());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_endereco_com_cep_nulo() {
		enderecoBefore.setCep(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_vazio() {
		enderecoBefore.setCep("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_contendo_letras() {
		enderecoBefore.setCep("12331AVV");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_contendo_caracteres_invalidos() {
		enderecoBefore.setCep("12331#$#");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_contendo_mais_que_8_digitos() {
		enderecoBefore.setCep("123314444");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_contendo_menos_que_8_digitos() {
		enderecoBefore.setCep("3314444");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_contendo_espacos_no_comeco() {
		enderecoBefore.setCep(" 3314444");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_contendo_espacos_no_fim() {
		enderecoBefore.setCep("3314444 ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_possuindo_digitos_sequenciais() {
		enderecoBefore.setCep("11111111");
	}
	
	//
	
	@Test
	public void test_deve_criar_endereco_com_numero_valido() {
		Endereco e1 = new Endereco(CEP_ENDERECO, NUMERO_ENDERECO);
		assertEquals(NUMERO_ENDERECO, e1.getNumero());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_endereco_com_numero_nulo() {
		new Endereco(CEP_ENDERECO, null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_numero_menor_que_1() {
		new Endereco(CEP_ENDERECO, 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_numero_maior_que_9999() {
		new Endereco(CEP_ENDERECO, 10000);
	}
	
	// SET
	
	@Test
	public void test_deve_settar_endereco_com_numero_valido() {
		Integer numero = 423;
		enderecoBefore.setNumero(numero);
		assertEquals(numero, enderecoBefore.getNumero());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_endereco_com_numero_nulo() {
		enderecoBefore.setNumero(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_numero_menor_que_1() {
		enderecoBefore.setNumero(0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_numero_maior_que_9999() {
		enderecoBefore.setNumero(10000);
	}
	
	//
	
	@Test
	public void test_deve_settar_logradouro_valido() {
		enderecoBefore.setLogradouro(LOGRADOURO);
		assertEquals(LOGRADOURO, enderecoBefore.getLogradouro());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_logradouro_nulo() {
		enderecoBefore.setLogradouro(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_logradouro_vazio() {
		enderecoBefore.setLogradouro("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_logradouro_possuindo_espaco_no_comeco() {
		enderecoBefore.setLogradouro(" São Vicente 3");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_logradouro_possuindo_espaco_no_fim() {
		enderecoBefore.setLogradouro("São Vicente 3 ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_logradouro_possuindo_caracteres_especiais() {
		enderecoBefore.setLogradouro("São Vicente ##");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_logradouro_possuindo_mais_de_60_caracteres() {
		enderecoBefore.setLogradouro("São vicente São Vicente São Vicente São Vicente São Vicente São Vicente");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_logradouro_possuindo_menos_de_3_caracteres() {
		enderecoBefore.setLogradouro("Sã");
	}
	
	@Test
	public void test_deve_settar_bairro_valido() {
		enderecoBefore.setBairro(BAIRRO);
		assertEquals(BAIRRO, enderecoBefore.getBairro());
	}
	
	@Test
	public void test_deve_settar_bairro_possuindo_numeros() {
		String bairro2 = "Bairro 321";
		enderecoBefore.setBairro(bairro2);
		assertEquals(bairro2, enderecoBefore.getBairro());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_bairro_nulo() {
		enderecoBefore.setBairro(null);
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_bairro_vazio() {
		enderecoBefore.setBairro("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_bairro_com_espacos_no_comeco() {
		enderecoBefore.setBairro(" Jardim das Belezas");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_bairro_com_espacos_no_fim() {
		enderecoBefore.setBairro("Jardim das Belezas ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_bairro_com_caracteres_invalidos() {
		enderecoBefore.setBairro("Jardim das Belezas!@#");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_bairro_com_mais_de_60_caracteres() {
		enderecoBefore.setBairro("Jardim das Belezas Belezas Belezas Belezas Belezas Belezas Belezas");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_bairro_com_menos_de_4_caracteres() {
		enderecoBefore.setBairro("Jrd");
	}
	
	@Test
	public void test_deve_settar_tipo_logradouro_valido() {
		enderecoBefore.setTipoLogradouro(TIPO_LOGRADOURO);
		assertEquals(TIPO_LOGRADOURO, enderecoBefore.getTipoLogradouro());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_tipo_logradouro_nulo() {
		enderecoBefore.setTipoLogradouro(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_tipo_logradouro_vazio() {
		enderecoBefore.setTipoLogradouro("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_tipo_logradouro_possuindo_espacos_no_comeco() {
		enderecoBefore.setTipoLogradouro(" Rua");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_tipo_logradouro_possuindo_espacos_no_fim() {
		enderecoBefore.setTipoLogradouro("Rua ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_tipo_logradouro_possuindo_numeros() {
		enderecoBefore.setTipoLogradouro("Rua4");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_tipo_logradouro_possuindo_menos_de_3_caracteres() {
		enderecoBefore.setTipoLogradouro("AV");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_tipo_logradouro_possuindo_mais_de_60_caracteres() {
		enderecoBefore.setTipoLogradouro("AV");
	}
	
	@Test
	public void test_deve_settar_cidade_valida() {
		enderecoBefore.setCidade(cidadeBefore);
		assertEquals(cidadeBefore, enderecoBefore.getCidade());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_cidade_nula() {
		enderecoBefore.setCidade(null);
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_hashcode_de_enderecos_iguais() {
		Endereco e1 = enderecoBefore;
		assertEquals(e1.hashCode(), enderecoBefore.hashCode());
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_hashcode_de_enderecos_diferentes() {
		Endereco e1 = new Endereco("43431232",43);
		assertNotEquals(e1.hashCode(), enderecoBefore.hashCode());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_enderecos_iguais() {
		Endereco e1 = new Endereco(CEP_ENDERECO, NUMERO_ENDERECO);
		assertEquals(e1, enderecoBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_enderecos_diferentes() {
		Endereco e1 = new Endereco("43431232",43);
		assertNotEquals(e1, enderecoBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_endereco_a_um_valor_nulo() {
		assertNotEquals(enderecoBefore, null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_endereco_a_um_objeto_de_classe_diferente() {
		assertNotEquals(enderecoBefore, new Object());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_o_mesmo_endereco() {
		Endereco e1 = enderecoBefore;
		assertEquals(enderecoBefore, e1);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_endereco_de_cep_diferente() {
		Endereco e1 = new Endereco("94343123", NUMERO_ENDERECO);
		assertNotEquals(enderecoBefore, e1);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_endereco_de_numero_diferente() {
		Endereco e1 = new Endereco(CEP_ENDERECO, 54);
		assertNotEquals(enderecoBefore, e1);
	}
	
	@Test
	public void test_deve_retornar_to_string_corretamente() {
		enderecoBefore.setBairro(BAIRRO);
		enderecoBefore.setCidade(cidadeBefore);
		enderecoBefore.setLogradouro(LOGRADOURO);
		enderecoBefore.setTipoLogradouro(TIPO_LOGRADOURO);
		assertTrue(enderecoBefore.toString().contains(BAIRRO));
		assertTrue(enderecoBefore.toString().contains(CEP_ENDERECO));
		assertTrue(enderecoBefore.toString().contains(LOGRADOURO));
		assertTrue(enderecoBefore.toString().contains(TIPO_LOGRADOURO));
		assertTrue(enderecoBefore.toString().contains(cidadeBefore.toString()));
	}
}

