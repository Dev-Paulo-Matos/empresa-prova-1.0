package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.empresa.endereco.Cidade;
import br.com.contmatic.empresa.endereco.Endereco;

public class EnderecoTest {
	
	private static final String LOGRADOURO = "Rua Antonio Roberto";

	private static final String CEP = "06315270";

	private static final String NUMERO = "476";
	
	private static final String COD_IBGE = "13212";
	
	private static final String TIPO_LOGRADOURO = "RUA";
	
	private static final String BAIRRO = "Jardim das Belezas 2";
	
	private Cidade cidadeBefore;
	
	private Endereco enderecoBefore;
	
	@Before
	public void test_deve_criar_antes_de_todos_os_outros() {
		enderecoBefore = new Endereco(CEP,NUMERO);
		
		cidadeBefore = new Cidade(COD_IBGE);
	}
	
	@Test
	public void test_deve_criar_endereco_com_cep_valido() {
		assertSame(CEP,enderecoBefore.getCep());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_digitos_invalidos_no_cep() {
		new Endereco("312321231",NUMERO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_contendo_caracteres_especiais() {
		new Endereco("!#@!@#@1",NUMERO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_vazio() {
		new Endereco("",NUMERO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_cep_com_digito_sequencial() {
		new Endereco("11111111",NUMERO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_endereco_com_cep_nulo() {
		new Endereco(null,NUMERO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_cep_contendo_letras() {
		new Endereco("ase1231",NUMERO);
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_digitos_invalidos_no_cep() {
		enderecoBefore.setCep("312321231");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_contendo_caracteres_especiais() {
		enderecoBefore.setCep("!#@!@#@1");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_vazio() {
		enderecoBefore.setCep("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_cep_com_digito_sequencial() {
		enderecoBefore.setCep("11111111");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_endereco_com_cep_nulo() {
		enderecoBefore.setCep(null);
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_cep_contendo_letras() {
		enderecoBefore.setCep("ase1231");
	}
	
	@Test
	public void test_deve_settar_tipo_logradouro() {
		enderecoBefore.setTipoLogradouro(TIPO_LOGRADOURO);
		
		assertSame(TIPO_LOGRADOURO,enderecoBefore.getTipoLogradouro());
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
	public void test_nao_deve_settar_tipo_logradouro_com_menos_de_3_caracteres() {
		enderecoBefore.setTipoLogradouro("AB");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_tipo_logradouro_com_mais_de_20_caracteres() {
		enderecoBefore.setTipoLogradouro("String com Mais de vinte caracteres");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_numeros_no_tipo_logradouro() {
		enderecoBefore.setTipoLogradouro("12313");
	}
	
	@Test
	public void test_deve_settar_um_novo_cep_valido_a_um_endereco_ja_criado() {
		assertSame(CEP,enderecoBefore.getCep());
		
		String cep2 = "07843121";
		
		enderecoBefore.setCep(cep2);
		
		assertSame(cep2,enderecoBefore.getCep());
	}
	
	@Test
	public void test_deve_retornar_cep_de_um_endereco_criado() {
		assertSame(CEP,enderecoBefore.getCep());
	} 
	
	@Test
	public void test_deve_criar_endereco_com_numero_valido() {
		assertSame(NUMERO,enderecoBefore.getNumero());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_contendo_letras_no_numero() {
		new Endereco(CEP,"A123");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_mais_de_5_numeros() {
		String numero2 = "123456";
		new Endereco(CEP,numero2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_numero_vazio() {
		String numero2 = "";
		new Endereco(CEP,numero2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_endereco_com_numero_nulo() {
		new Endereco(CEP,null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_endereco_com_numero_contendo_caracteres_invalidos() {
		new Endereco(CEP,"!@#!");
	}
	
	@Test
	public void test_deve_settar_endereco_com_numero_valido() {
		String numero2 = "312";
		enderecoBefore.setNumero(numero2);
		assertSame(numero2,enderecoBefore.getNumero());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_contendo_letras_no_numero() {
		enderecoBefore.setNumero("A123");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_mais_de_5_numeros() {
		String numero2 = "123456";
		
		enderecoBefore.setNumero(numero2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_numero_vazio() {
		String numero2 = "";
		
		enderecoBefore.setNumero(numero2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_endereco_com_numero_nulo() {
		enderecoBefore.setNumero(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_endereco_com_numero_contendo_caracteres_invalidos() {
		enderecoBefore.setNumero("!@#!");
	}
	
	@Test
	public void test_deve_criar_endereco_e_settar_um_novo_numero() {
		Endereco endereco1 = new Endereco(CEP,NUMERO);
		
		String numero2 = "321";
		
		endereco1.setNumero(numero2);
		
		assertSame(numero2,endereco1.getNumero());
	}
	
	@Test
	public void test_deve_retornar_numero_do_endereco() {
		assertSame(NUMERO,enderecoBefore.getNumero());
	}
	
	@Test
	public void test_deve_settar_cidade_valida_a_endereco() {
		enderecoBefore.setCidade(cidadeBefore);
		assertTrue(enderecoBefore.toString().contains(cidadeBefore.toString()));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_cidade_invalida_a_endereco() {
		enderecoBefore.setCidade(null);
	}
	
	@Test
	public void test_deve_retornar_cidade() {
		enderecoBefore.setCidade(cidadeBefore);
		
		assertSame(cidadeBefore,enderecoBefore.getCidade());
	}
	
	@Test
	public void test_deve_settar_rua_valida() {
		enderecoBefore.setLogradouro(LOGRADOURO);
		
		assertSame(LOGRADOURO,enderecoBefore.getLogradouro());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_rua_contendo_caracteres_especiais() {
		String rua2 = "Rua Antonio Roberto 4!";
		enderecoBefore.setLogradouro(rua2);
	}
	
	@Test
	public void test_deve_settar_rua_contendo_digitos() {
		String rua2 = "Rua 5";
		
		enderecoBefore.setLogradouro(rua2);
		
		assertSame(rua2,enderecoBefore.getLogradouro());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_rua_com_valor_nullo() {
		enderecoBefore.setLogradouro(null);
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_rua_com_valor_vazio() {
		enderecoBefore.setLogradouro("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_rua_com_quantidade_de_caracteres_a_menos() {
		enderecoBefore.setLogradouro("Ru");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_rua_com_quantidade_de_caracteres_a_mais() {
		enderecoBefore.setLogradouro("Logradouro GRANDE Logradouro GRANDE Logradouro GRANDE Logradouro GRANDE RUA GRANDE RUA GRANDE RUA GRANDE RUA");
	}

	@Test
	public void test_deve_retornar_a_rua() {
		enderecoBefore.setLogradouro(LOGRADOURO);
		
		assertSame(LOGRADOURO, enderecoBefore.getLogradouro());
	}
	
	@Test
	public void test_deve_criar_bairro_e_retornar() {
		enderecoBefore.setBairro(BAIRRO);
		
		assertSame(BAIRRO, enderecoBefore.getBairro());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_bairro_com_valor_nullo() {
		enderecoBefore.setBairro(null);
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_bairro_com_valor_vazio() {
		enderecoBefore.setBairro("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_bairro_com_quantidade_de_caracteres_a_menos() {
		enderecoBefore.setBairro("Ru");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_bairro_com_quantidade_de_caracteres_a_mais() {
		enderecoBefore.setBairro("Logradouro GRANDE Logradouro GRANDE Logradouro GRANDE Logradouro GRANDE RUA GRANDE RUA GRANDE RUA GRANDE RUA");
	}
	
	
	@Test
	public void test_deve_retornar_igualdade_ao_compara_o_endereco_com_o_proprio_endereco() {
		assertEquals(this.enderecoBefore,enderecoBefore);
	}
	
	@Test
	public void test_deve_retornar_igualdade_no_hashcode_comparar_objetos_com_mesmo_atributo() {
		assertEquals(enderecoBefore.hashCode(),new Endereco(CEP,NUMERO).hashCode());
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_no_hashcode_ao_comparar_objetos_com_atributos_diferentes() {
		assertNotEquals(enderecoBefore.hashCode(),new Endereco("06715270","123").hashCode());
	}
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_endereco_a_um_valor_nulo() {
		assertNotEquals(enderecoBefore,null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_endereco_com_objetos_de_classes_diferentes() {
		assertNotEquals(enderecoBefore,new Object());
	}
	
	@Test
	public void test_deve_retornar_igualdade_a_comparar_enderecos_com_os_mesmos_atributos() {
		assertEquals(enderecoBefore,new Endereco(CEP,NUMERO));
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_a_comparar_enderecos_com_numeros_diferentes() {
		assertNotEquals(enderecoBefore,new Endereco(CEP,"123"));
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_a_comparar_enderecos_com_cep_diferente() {
		assertNotEquals(enderecoBefore,new Endereco("06789123",NUMERO));
	}
	
	@Test
	public void test_deve_retornar_to_string() {
		enderecoBefore.setCidade(cidadeBefore);
		
		enderecoBefore.setLogradouro(LOGRADOURO);
		
		assertTrue(enderecoBefore.toString().contains(CEP));
		
		assertTrue(enderecoBefore.toString().contains(NUMERO));
		
		assertTrue(enderecoBefore.toString().contains(LOGRADOURO));
		
		assertTrue(enderecoBefore.toString().contains(cidadeBefore.toString()));

	}
	
}
