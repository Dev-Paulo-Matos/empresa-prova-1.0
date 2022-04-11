package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Empresa;

public class AuditoriaTest {
	
	private static final String NOME = "PauloMachado";

	private static final String CNPJ_VALIDO = "93211954000124";

	private static final int PLUS_TIME = 1;
	
	private Empresa empresaBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_teste() {
		empresaBefore = new Empresa(CNPJ_VALIDO);
	}
	
	@Test
	public void test_deve_settar_data_criacao_corretamente(){
		DateTime now = DateTime.now().plusMinutes(PLUS_TIME);
		empresaBefore.setDataCriacao(now);
		assertEquals(now,empresaBefore.getDataCriacao());
	}
	
	@Test
	public void test_deve_settar_data_alteracao_corretamente() {
		DateTime now = DateTime.now().plusMinutes(1);
		empresaBefore.setDataCriacao(DateTime.now());
		empresaBefore.setDataAlteracao(now);
		assertEquals(now,empresaBefore.getDataAlteracao());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_data_alteracao_mais_recente_que_data_criacao() {
		empresaBefore.setDataCriacao(DateTime.now().plusMinutes(PLUS_TIME));
		empresaBefore.setDataAlteracao(DateTime.now());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uma_data_futura_da_data_criacao() {
		empresaBefore.setDataCriacao(DateTime.now().plusMinutes(20));
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uma_data_futura_da_data_alteracao() {
		empresaBefore.setDataAlteracao(DateTime.now().plusMinutes(20));
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uma_data_passado_da_data_criacao() {
		empresaBefore.setDataCriacao(DateTime.now().plusMinutes(-2));
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_uma_data_passado_da_data_alteracao() {
		empresaBefore.setDataAlteracao(DateTime.now().plusMinutes(-2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_uma_data_nula_da_data_criacao() {
		empresaBefore.setDataCriacao(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_uma_data_nula_da_data_alteracao() {
		empresaBefore.setDataAlteracao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_um_usuario_criacao_vazio() {
		empresaBefore.setNomeUsuarioCriacao("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_um_usuario_criacao_com_espacos() {
		empresaBefore.setNomeUsuarioCriacao("    ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_um_usuario_criacao_com_caracteres_especiais() {
		empresaBefore.setNomeUsuarioCriacao("paulo!@");
	}
	
	public void test_deve_settar_um_usuario_criacao_com_digitos() {
		empresaBefore.setNomeUsuarioCriacao("paulo123");
	}
	
	@Test
	public void test_deve_settar_usuario_criacao_corretamente() {
		empresaBefore.setNomeUsuarioCriacao(NOME);
		
		assertEquals(NOME,empresaBefore.getNomeUsuarioCriacao());
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_um_usuario_alteracao_vazio() {
		empresaBefore.setNomeUsuarioUltimaAlteracao("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_um_usuario_alteracao_com_espacos() {
		empresaBefore.setNomeUsuarioUltimaAlteracao("    ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_um_usuario_alteracao_com_caracteres_especiais() {
		empresaBefore.setNomeUsuarioUltimaAlteracao("paulo!@");
	}
	
	public void test_deve_settar_um_usuario_alteracao_com_digitos() {
		empresaBefore.setNomeUsuarioCriacao("paulo123");
	}
	
	@Test
	public void test_deve_settar_usuario_alteracao_corretamente() {
		empresaBefore.setNomeUsuarioUltimaAlteracao(NOME);
		
		assertEquals(NOME,empresaBefore.getNomeUsuarioUltimaAlteracao());
		
	}
	
	@Test
	public void test_deve_settar_ip_criacao_corretamente() {
		String ipUsuarioCriacao = "192.168.0.10 ";
		empresaBefore.setIpUsuarioCriacao(ipUsuarioCriacao);
		assertEquals(ipUsuarioCriacao, empresaBefore.getIpUsuarioCriacao());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_criacao_invalido() {
		String ipUsuarioCriacao = "192.168.0.1110 ";
		empresaBefore.setIpUsuarioCriacao(ipUsuarioCriacao);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_ip_criacao_nulo() {
		empresaBefore.setIpUsuarioCriacao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_criacao_vazio() {
		empresaBefore.setIpUsuarioCriacao("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_criacao_com_espacos() {
		empresaBefore.setIpUsuarioCriacao("  ");
	}
	
	@Test
	public void test_deve_settar_ip_alteracao_corretamente() {
		String ipUsuarioCriacao = "192.168.0.10 ";
		empresaBefore.setIpUsuarioUltimaAlteracao(ipUsuarioCriacao);
		assertEquals(ipUsuarioCriacao, empresaBefore.getIpUsuarioUltimaAlteracao());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_alteracao_invalido() {
		String ipUsuarioCriacao = "192.168.0.1110 ";
		empresaBefore.setIpUsuarioUltimaAlteracao(ipUsuarioCriacao);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_ip_alteracao_nulo() {
		empresaBefore.setIpUsuarioUltimaAlteracao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_alteracao_vazio() {
		empresaBefore.setIpUsuarioUltimaAlteracao("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_alteracao_com_espacos() {
		empresaBefore.setIpUsuarioUltimaAlteracao("  ");
	}
	
}
