package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.contato.Celular;
import br.com.contmatic.prova.contato.Contato;
import br.com.contmatic.prova.empresa.Departamento;
import br.com.contmatic.prova.empresa.Empresa;
import br.com.contmatic.prova.endereco.Endereco;

public class EmpresaTest {
	
	private static final String NOME_FANTASIA_VALIDO = "Nome Fantasia Valido";
	private static final String RAZAO_SOCIAL_VALIDA = "Razao Social valida";
	private static final String CNPJ_VALIDA = "04466524000123";
	private Empresa empresaBefore;
	private Contato contatoBefore;
	private Celular celularBefore;
	private Departamento departamentoBefore1;
	private Departamento departamentoBefore2;
	private Endereco enderecoBefore;
	private List<Contato> contatosBefore;
	private List<Departamento> departamentosBefore;
	private List<Endereco> enderecosBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_testes() {
		empresaBefore = new Empresa(CNPJ_VALIDA);
		departamentoBefore1 = new Departamento("54321",empresaBefore);
		departamentoBefore2 = new Departamento("12345",empresaBefore);
		celularBefore = new Celular("55","11","963481012");
		contatoBefore = new Contato(celularBefore);
		enderecoBefore = new Endereco("06315270", 476);
		contatosBefore = new ArrayList<Contato>();
		departamentosBefore = new ArrayList<Departamento>();
		enderecosBefore = new ArrayList<Endereco>();

	}
	
	@Test
	public void test_deve_criar_empresa_com_cnpj_valido() {
		String cnpj = "46165257000102";
		assertEquals(cnpj, new Empresa(cnpj).getCnpj());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_invalido() {
		new Empresa("46165257000101");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_nulo() {
		new Empresa(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_vazio() {
		new Empresa("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_contendo_espacos() {
		new Empresa("             ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_contendo_espacos_no_comeco() {
		new Empresa("  46165257000102");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_contendo_espacos_no_fim() {
		new Empresa("46165257000102   ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_contendo_espacos_no_meio() {
		new Empresa("461652  57000102");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_maior_que_14( ) {
		new Empresa("461652570001021");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_menor_que_14( ) {
		new Empresa("4616525700010");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_contendo_letras() {
		new Empresa("461652A7A00010");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_contendo_caracteres_especiais() {
		new Empresa("461652A7!00010");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_sequencial() {
		new Empresa("11111111111111");
	}
	
	@Test
	public void test_deve_retornar_cnpj_valido_da_empresa() {
		assertEquals(CNPJ_VALIDA, empresaBefore.getCnpj());
	}
	
	@Test
	public void test_deve_settar_cnpj_valido() {
		String cnpj = "09631748000167";
		empresaBefore.setCnpj(cnpj);
		assertEquals(cnpj, empresaBefore.getCnpj());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_invalido() {
		new Empresa("09631748000134");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_nulo() {
		empresaBefore.setCnpj(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_vazio() {
		empresaBefore.setCnpj("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_contendo_espacos() {
		empresaBefore.setCnpj("             ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_contendo_espacos_no_comeco() {
		empresaBefore.setCnpj("  46165257000102");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_contendo_espacos_no_fim() {
		empresaBefore.setCnpj("46165257000102   ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_contendo_espacos_no_meio() {
		empresaBefore.setCnpj("461652  57000102");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_maior_que_14( ) {
		empresaBefore.setCnpj("461652570001021");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_menor_que_14( ) {
		empresaBefore.setCnpj("4616525700010");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_contendo_letras() {
		empresaBefore.setCnpj("461652A7A00010");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_contendo_caracteres_especiais() {
		empresaBefore.setCnpj("4616527#!00010");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_sequencial() {
		empresaBefore.setCnpj("22222222222222");
	}
	
	@Test
	public void test_deve_settar_razao_social_valida() {
		empresaBefore.setRazaoSocial(RAZAO_SOCIAL_VALIDA);
		assertEquals(RAZAO_SOCIAL_VALIDA, empresaBefore.getRazaoSocial());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_razao_social_nulo() {
		empresaBefore.setRazaoSocial(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_razao_social_vazio() {
		empresaBefore.setRazaoSocial("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_razao_social_contendo_espacos() {
		empresaBefore.setRazaoSocial("                              ");
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_razao_social_contendo_espacos_no_comeco() {
		empresaBefore.setRazaoSocial("   Razao Social invalida");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_razao_social_contendo_espacos_no_fim() {
		empresaBefore.setRazaoSocial("Razao Social invalida   ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_razao_social_contendo_espacos_invalido_no_meio() {
		empresaBefore.setRazaoSocial("Razao So  cial invalida");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_razao_social_contendo_caracteres_invalidos() {
		empresaBefore.setRazaoSocial("Razao Social invalida!!!!!!");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_razao_social_contendo_mais_de_60_caracteres() {
		empresaBefore.setRazaoSocial("Razao Social Contendo mais de sessenta caracteres, Razao Social Contendo mais de sessenta caracteres");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_razao_social_contendo_menos_de_5_caracteres() {
		empresaBefore.setRazaoSocial("raza");
	}
	
	@Test
	public void test_deve_settar_razao_social_contendo_numeros() {
		String razaoSocial = "Razao social pode conter numeros 123";
		empresaBefore.setRazaoSocial(razaoSocial);
		assertEquals(razaoSocial,empresaBefore.getRazaoSocial());
	}
	
	@Test
	public void test_deve_settar_razao_social_contendo_acentos() {
		String razaoSocial = "Razão social contem acentos";
		empresaBefore.setRazaoSocial(razaoSocial);
		assertEquals(razaoSocial,empresaBefore.getRazaoSocial());
	}
	
	@Test
	public void test_deve_settar_nome_fantasia_contendo_letras_numeros_e_acentos() {
		String nomeFantasia = "Validação 123";
		empresaBefore.setNomeFantasia(nomeFantasia);
		assertEquals(nomeFantasia, empresaBefore.getNomeFantasia());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_nome_fantasia_nulo() {
		empresaBefore.setNomeFantasia(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_vazio() {
		empresaBefore.setNomeFantasia("");
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_contendo_espacos() {
		empresaBefore.setNomeFantasia("     ");
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_contendo_espacos_no_comeco() {
		empresaBefore.setNomeFantasia("  Nome fantasia invalido");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_contendo_espacos_no_fim() {
		empresaBefore.setNomeFantasia("Nome fantasia invalido  ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_contendo_espacos_no_meio() {
		empresaBefore.setNomeFantasia("Nome fant  asia invalido");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_contendo_mais_de_60_caracteres() {
		empresaBefore.setNomeFantasia("Nome fantasia invalido possuindo mais de 60 caracteres contendo");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_contendo_menos_de_5_caracteres() {
		empresaBefore.setNomeFantasia("Nome");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_contendo_caracteres_especiais() {
		empresaBefore.setNomeFantasia("Contendo caracteres invalidos!@#");
	}
	
	@Test
	public void test_deve_settar_lista_de_contato_valido() {
		contatosBefore.add(contatoBefore);
		empresaBefore.setContatos(contatosBefore);
		assertEquals(contatosBefore, empresaBefore.getContatos());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_contato_menos_de_1_contato() {
		empresaBefore.setContatos(contatosBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_contato_com_mais_de_20_contato() {
		for(int i = 0; i <= 20; i++) {
			contatosBefore.add(contatoBefore);
		}
		empresaBefore.setContatos(contatosBefore);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_lista_de_contato_nula() {
		empresaBefore.setContatos(null);
	}
	
	@Test
	public void test_deve_settar_lista_de_departamento_valido() {
		departamentosBefore.add(departamentoBefore1);
		departamentosBefore.add(departamentoBefore2);
		empresaBefore.setDepartamentos(departamentosBefore);
		assertEquals(departamentosBefore, empresaBefore.getDepartamentos());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_departamento_vazio() {
		empresaBefore.setDepartamentos(departamentosBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_departamento_contendo_menos_de_2_departamento() {
		departamentosBefore.add(departamentoBefore1);
		empresaBefore.setDepartamentos(departamentosBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_departamento_contendo_mais_de_20_departamento() {
		for(int i = 0;i <= 20; i++) {
			departamentosBefore.add(departamentoBefore1);
		}
		empresaBefore.setDepartamentos(departamentosBefore);
	}
	
	@Test
	public void test_deve_settar_lista_de_departamento_contendo_menos_de_20_departamento_e_mais_de_2_departamento() {
		for(int i = 0;i < 19; i++) {
			departamentosBefore.add(departamentoBefore1);
		}
		empresaBefore.setDepartamentos(departamentosBefore);
		assertEquals(departamentosBefore, empresaBefore.getDepartamentos());
	}
	
	@Test
	public void test_deve_settar_lista_de_enderecos_valido() {
		enderecosBefore.add(enderecoBefore);
		empresaBefore.setEnderecos(enderecosBefore);
		assertEquals(enderecosBefore,empresaBefore.getEnderecos());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_enderecos_com_menos_de_1_endereco() {
		empresaBefore.setEnderecos(enderecosBefore);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_enderecos_com_mais_de_20_endereco() {
		for(int i = 0;i <= 20;i++) {
			enderecosBefore.add(enderecoBefore);
		}
		empresaBefore.setEnderecos(enderecosBefore);
	}
	
	@Test
	public void test_deve_settar_lista_de_enderecos_com_menos_de_20_endereco_e_mais_de_1_endereco() {
		for(int i = 0;i < 20;i++) {
			enderecosBefore.add(enderecoBefore);
		}
		empresaBefore.setEnderecos(enderecosBefore);
		assertEquals(enderecosBefore, empresaBefore.getEnderecos());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_hash_code_de_empresas_iguais() {
		Empresa empresaBefore2 = empresaBefore;
		assertEquals(empresaBefore.hashCode(),empresaBefore2.hashCode());
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_hash_code_de_empresas_diferentes() {
		Empresa empresaBefore2 = new Empresa("07431511000107");
		assertNotEquals(empresaBefore.hashCode(),empresaBefore2.hashCode());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_a_mesma_empresa() {
		Empresa empresaBefore2 = empresaBefore;
		assertEquals(empresaBefore,empresaBefore2);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_empresas_diferentes() {
		Empresa empresaBefore2 = new Empresa("07431511000107");
		assertNotEquals(empresaBefore, empresaBefore2);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_empresa_a_um_valor_nulo() {
		assertNotEquals(empresaBefore, null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_a_empresa_a_um_valor_nulo() {
		assertNotEquals(empresaBefore, null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_empresa_a_outro_objeto_de_classe_diferente() {
		assertNotEquals(empresaBefore, new Object());
	}
	
	@Test
	public void test_deve_settar_e_retornar_to_string_corretamente() {
		contatosBefore.add(contatoBefore);
		contatosBefore.add(contatoBefore);
		enderecosBefore.add(enderecoBefore);
		enderecosBefore.add(enderecoBefore);
		departamentosBefore.add(departamentoBefore1);
		departamentosBefore.add(departamentoBefore2);
		empresaBefore = new Empresa(CNPJ_VALIDA);
		empresaBefore.setRazaoSocial(RAZAO_SOCIAL_VALIDA);
		empresaBefore.setNomeFantasia(NOME_FANTASIA_VALIDO);
		empresaBefore.setContatos(contatosBefore);
		empresaBefore.setEnderecos(enderecosBefore);
		empresaBefore.setDepartamentos(departamentosBefore);
		assertTrue(empresaBefore.toString().contains(CNPJ_VALIDA));
		assertTrue(empresaBefore.toString().contains(NOME_FANTASIA_VALIDO));
		assertTrue(empresaBefore.toString().contains(RAZAO_SOCIAL_VALIDA));
		assertTrue(empresaBefore.toString().contains(enderecosBefore.toString()));
		assertTrue(empresaBefore.toString().contains(contatosBefore.toString()));
		assertTrue(empresaBefore.toString().contains(departamentosBefore.toString()));
	}
}
