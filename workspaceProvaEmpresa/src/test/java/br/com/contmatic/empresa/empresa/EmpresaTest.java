package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.contato.Contato;
import br.com.contmatic.prova.empresa.Departamento;
import br.com.contmatic.prova.empresa.Empresa;
import br.com.contmatic.prova.endereco.Endereco;


public class EmpresaTest {
	
	private static final String RAZAO2 = "AMIGOS 5 do Bem";

	private static final String COD_DEPARTAMENTO = "RC214";

	private static final String RECURSOS_HUMANO = "Recursos Humano";

	private static final String RAZAO_SOCIAL = "Ong Amigos do Planeta";
	
	private static final String CNPJ_VALIDO = "53169215000105";
	
	private static final String CEP = "06315270";
	
	private static final String NUMERO = "476";
	
	private static final String FANTASIA = "AMIGOS DO BEMM 1";
	
	private Empresa empresaBefore;
	
	private Contato contatoBefore;
	
	private static List<Departamento> departamentos;
	
	private static Departamento departamento1;
	
	private static Departamento departamento2;
	
	private static List<Endereco> enderecos;
	
	private static Endereco endereco1;
	
	private static Endereco endereco2;
		
	@Before
	public void criar_antes_de_todos_os_testes() { 
		empresaBefore = new Empresa(CNPJ_VALIDO,RAZAO_SOCIAL);
		
		contatoBefore = new Contato("5511963481012","email@gmail.com");
		
		departamentos = new ArrayList<>();
		
		departamento1 = new Departamento(RECURSOS_HUMANO,COD_DEPARTAMENTO);
			
		departamento2 = new Departamento(RECURSOS_HUMANO,COD_DEPARTAMENTO);
		
		enderecos = new ArrayList<>();
		
		endereco1 = new Endereco(CEP,NUMERO);
	}
	
	@Test
	public void test_deve_criar_empresa_com_cnpj_valido() {
		assertSame(empresaBefore.getCnpj(),new Empresa(CNPJ_VALIDO,RAZAO_SOCIAL).getCnpj());
	}
	
	@Test
	public void test_deve_settar_novo_cnpj_valido_a_empresa_existente() {
		String CNPJ = "58106202000100";
		empresaBefore.setCnpj(CNPJ);
		assertSame(CNPJ,empresaBefore.getCnpj());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_novo_cnpj_invalido_a_empresa_existente() {
		empresaBefore.setCnpj("58106202000110");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_invalido() {
		new Empresa("53169215000102",RAZAO_SOCIAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_com_menos_de_11_caracteres() {
		new Empresa("9420345300019",RAZAO_SOCIAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_com_mais_de_11_caracteres() {
		new Empresa("942034530001691",RAZAO_SOCIAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_vazio() {
		empresaBefore.setNomeFantasia("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_setta_nome_fantasia_nulo() {
		empresaBefore.setNomeFantasia(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_setta_nome_fantasia_com_menos_de_5_caracteres() {
		empresaBefore.setNomeFantasia("ABCD");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_fantasia_com_mais_de_60_caracteres() {
		empresaBefore.setNomeFantasia("MAIS DE 60 CARACTERES MAIS DE 60 CARACTERES MAIS DE 60 CARACTERES");
	}
	
	@Test
	public void test_deve_settar_nome_fantasia_correto() {
		empresaBefore.setNomeFantasia(FANTASIA);
		
		assertSame(FANTASIA, empresaBefore.getNomeFantasia());
	}
	
	@Test
	public void test_deve_settar_nome_fantasia_com_numeros() {
		empresaBefore.setNomeFantasia(FANTASIA);
		
		assertSame(FANTASIA, empresaBefore.getNomeFantasia());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_sequencial() {
		new Empresa("11111111111111",RAZAO_SOCIAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_possundo_caracteres_invalidos() {
		new Empresa("9420345300a019",RAZAO_SOCIAL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_nulo() {
		new Empresa(null,RAZAO_SOCIAL);
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_cnpj_vazio() {
		new Empresa("",RAZAO_SOCIAL);
	}
	//
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_invalido() {
		empresaBefore.setCnpj("53169215000102");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_com_menos_de_11_caracteres() {
		empresaBefore.setCnpj("9420345300019");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_com_mais_de_11_caracteres() {
		empresaBefore.setCnpj("942034530001691");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_sequencial() {
		empresaBefore.setCnpj("11111111111111");
	}
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_possundo_caracteres_invalidos() {
		empresaBefore.setCnpj("9420345300a019");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_nulo() {
		empresaBefore.setCnpj(null);
	}

	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_cnpj_vazio() {
		empresaBefore.setCnpj("");
	}
	
	@Test
	public void test_deve_retornar_o_cnpj_valido() {
		assertSame(CNPJ_VALIDO,empresaBefore.getCnpj());
	}
	
	@Test
	public void test_deve_criar_empresa_com_razao_social_valido() {
		assertSame(empresaBefore.getRazaoSocial(),new Empresa(CNPJ_VALIDO,RAZAO_SOCIAL).getRazaoSocial());
	}
	
	@Test
	public void test_deve_settar_nova_razao_social_valida() {
		String RAZAO_SOCIAL2 = "Ong Amigos Perdidos";
		empresaBefore.setRazaoSocial(RAZAO_SOCIAL2);
		assertSame(RAZAO_SOCIAL2,empresaBefore.getRazaoSocial());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nova_razao_social_invalida() {
		empresaBefore.setRazaoSocial("Lua");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_empresa_com_razao_social_nula() {
		empresaBefore.setRazaoSocial(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_razao_social_vazia() {
		empresaBefore.setRazaoSocial("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_razao_social_possuindo_mais_de_60_caracteres() {
		empresaBefore.setRazaoSocial("RAZAO SOCIAL INVALIDO RAZAO SOCIAL INVALIDO RAZAO SOCIAL INVALIDO");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_empresa_com_razao_social_possindo_menos_de_5_caracteres() {
		empresaBefore.setRazaoSocial("Empr");
	}
	
	@Test
	public void test_deve_settar_empresa_com_razao_social_contendo_numeros() {
		empresaBefore.setRazaoSocial(RAZAO2);
		assertEquals(RAZAO2,empresaBefore.getRazaoSocial());
	}
	//
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_criar_empresa_com_razao_social_nula() {
		new Empresa(CNPJ_VALIDO,null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_razao_social_vazia() {
		new Empresa(CNPJ_VALIDO,"");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_razao_social_possuindo_mais_de_60_caracteres() {
		new Empresa(CNPJ_VALIDO,"RAZAO SOCIAL INVALIDO RAZAO SOCIAL INVALIDO RAZAO SOCIAL INVALIDO");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_criar_empresa_com_razao_social_possindo_menos_de_5_caracteres() {
		new Empresa(CNPJ_VALIDO,"Empr");
	}
	
	@Test
	public void test_deve_criar_empresa_com_razao_social_contendo_numeros() {
		Empresa empresa = new Empresa(CNPJ_VALIDO,RAZAO2);
		assertEquals(RAZAO2,empresa.getRazaoSocial());
	}
	
	@Test
	public void test_deve_retornar_a_razao_social_valida() {
		assertSame(RAZAO_SOCIAL,empresaBefore.getRazaoSocial());
	}
	
	@Test
	public void test_deve_adicionar_um_contato_a_empresa() {
		empresaBefore.setContato(contatoBefore);
		
		assertSame(contatoBefore,empresaBefore.getContato());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_adicionar_contato_nulo_a_empresa() {
		empresaBefore.setContato(null);
	}
	
	@Test
	public void test_deve_retornar_contato() {
		empresaBefore.setContato(contatoBefore);
		
		assertSame(contatoBefore,empresaBefore.getContato());
	}
	
	@Test
	public void test_deve_adicionar_lista_de_departamento_valido_a_empresa() {
		departamentos.add(departamento1);

		departamentos.add(departamento2);
		
		empresaBefore.setDepartamentos(departamentos);
		
		assertSame(departamentos,empresaBefore.getDepartamentos());
	}
	
	@Test
	public void test_deve_retornar_a_lista_de_departamento_adicionada() {
		departamentos.add(departamento1);

		departamentos.add(departamento2);
		
		empresaBefore.setDepartamentos(departamentos);
		
		assertSame(departamentos,empresaBefore.getDepartamentos());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_departamentos_com_mais_de_20_departamentos() {
		for(int i = 0; i < 22; i++) {
			departamentos.add(new Departamento(RECURSOS_HUMANO,COD_DEPARTAMENTO));
		}
		empresaBefore.setDepartamentos(departamentos);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_departamentos_com_apenas_um_departamento() {
		departamentos.add(departamento1);
		empresaBefore.setDepartamentos(departamentos);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_adicionar_lista_de_departamentos_sem_endereco() {
		empresaBefore.setDepartamentos(departamentos);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_adicionar_lista_de_departamento_nula() {
		empresaBefore.setDepartamentos(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_adicionar_lista_de_endereco_nula_a_empresa() {
		empresaBefore.setEnderecos(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_adicionar_lista_de_enderecos_sem_endereco() {
		empresaBefore.setEnderecos(enderecos);
	}
	
	@Test
	public void test_deve_adicionar_lista_de_enrecos_com_um_endereco_cadastrado() {
		enderecos.add(endereco1);
		
		empresaBefore.setEnderecos(enderecos);
		
		assertSame(enderecos,empresaBefore.getEnderecos());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_lista_de_enderecos_com_mais_de_20_enderecos() {
		for(int i = 0; i < 22; i++) {
			enderecos.add(new Endereco(CEP,NUMERO));
		}
		empresaBefore.setEnderecos(enderecos);
	}
	
	@Test
	public void test_deve_adicionar_lista_de_enderecos_com_dois_enderecos_cadastrados() {
		enderecos.add(endereco1);
		
		enderecos.add(endereco2);
		
		empresaBefore.setEnderecos(enderecos);
		
		assertSame(enderecos,empresaBefore.getEnderecos());
	}
	
	@Test
	public void test_deve_retornar_enderecos() {
		enderecos.add(endereco1);
		
		enderecos.add(endereco2);
		
		empresaBefore.setEnderecos(enderecos);
		
		assertSame(enderecos, empresaBefore.getEnderecos());
	}
	
	@Test
	public void test_deve_retornar_igualdade_ao_comparar_empresa_com_a_mesma_empresa() {
		assertEquals(empresaBefore,this.empresaBefore);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_empresa_com__null () {
		assertNotEquals(empresaBefore,null);
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_empresas_diferentes() {
		assertNotEquals(empresaBefore,new Empresa("14077034000199", "Razao Social Valida"));
	}
	
	@Test
	public void test_nao_deve_retornar_igualdade_ao_comparar_objetos_de_classes_diferentes() {
		assertNotEquals(empresaBefore,new Object());
	}
	
	@Test
	public void test_deve_retornar_hashcode_igual_com_empresas_iguais() {
		assertEquals(empresaBefore.hashCode(),new Empresa(CNPJ_VALIDO,RAZAO_SOCIAL).hashCode());
	}
	
	@Test
	public void test_deve_retornar_que_tostring_deve_possuir_todos_os_atributos() {
		assertTrue(empresaBefore.toString().contains(CNPJ_VALIDO));
		
		assertTrue(empresaBefore.toString().contains(RAZAO_SOCIAL));
		
		empresaBefore.setContato(contatoBefore);
		
		assertTrue(empresaBefore.toString().contains(contatoBefore.toString()));
		
		departamentos.add(departamento1);

		departamentos.add(departamento2);
		
		empresaBefore.setDepartamentos(departamentos);
		
		assertTrue(empresaBefore.toString().contains(departamentos.toString()));
		
		empresaBefore.setNomeFantasia(FANTASIA);
		
		assertTrue(empresaBefore.toString().contains(FANTASIA));
		
		enderecos.add(endereco1);
		
		enderecos.add(endereco2);
		
		empresaBefore.setEnderecos(enderecos);
		
		assertTrue(empresaBefore.toString().contains(enderecos.toString()));

	}
	
}
