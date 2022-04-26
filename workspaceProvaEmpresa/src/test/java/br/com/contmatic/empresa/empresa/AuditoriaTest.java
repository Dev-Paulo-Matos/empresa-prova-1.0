package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Empresa;

public class AuditoriaTest {
	
	private static final String CNPJ = "01395109000138";
	private Empresa empresaBefore;
	
	@Before
	public void deve_criar_antes_de_todos_os_testes() {
		empresaBefore = new Empresa(CNPJ);
	}
	
	@Test
	public void test_deve_settar_data_criacao_corretamente() {
		LocalDate now = LocalDate.now();
		empresaBefore.setDataCriacao(now);
		assertEquals(now, empresaBefore.getDataCriacao());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_data_criacao_nula() {
		empresaBefore.setDataCriacao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_data_criacao_com_data_no_passado() {
		empresaBefore.setDataCriacao(LocalDate.now().plusDays(-4));
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_data_criacao_com_data_no_futuro() {
		empresaBefore.setDataCriacao(LocalDate.now().plusDays(4));
	}
	
	@Test
	public void test_deve_settar_data_alteracao_corretamente() {
		LocalDate time = LocalDate.now();
		empresaBefore.setDataCriacao(time);
		empresaBefore.setDataAlteracao(time);
		assertEquals(time, empresaBefore.getDataAlteracao());
	}
	
	@Test
	public void test_deve_settar_data_alteracao_apos_data_criacao() {
		LocalDate time = LocalDate.now();
		empresaBefore.setDataCriacao(time);
		empresaBefore.setDataAlteracao(time);
		assertEquals(time, empresaBefore.getDataAlteracao());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_data_alteracao_no_passado() {
		LocalDate time = LocalDate.now();
		empresaBefore.setDataCriacao(time);
		empresaBefore.setDataAlteracao(time.plusDays(-3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_data_alteracao_nula() {
		LocalDate time = LocalDate.now();
		empresaBefore.setDataCriacao(time);
		empresaBefore.setDataAlteracao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_data_alteracao_com_data_no_futuro() {
		LocalDate time = LocalDate.now();
		empresaBefore.setDataCriacao(time);
		empresaBefore.setDataAlteracao(time.plusDays(2));
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_data_alteracao_com_data_no_passado() {
		LocalDate time = LocalDate.now();
		empresaBefore.setDataCriacao(time);
		empresaBefore.setDataAlteracao(time.plusDays(2));
	}
	
	@Test
	public void test_deve_settar_nome_usuario_criacao() {
		String nomeUsuarioCriacao = "pauloMachad";
		empresaBefore.setNomeUsuarioCriacao(nomeUsuarioCriacao);
		assertEquals(nomeUsuarioCriacao, empresaBefore.getNomeUsuarioCriacao());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_criacao_contendo_numeros() {
		empresaBefore.setNomeUsuarioCriacao("paulo4Machad");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_nome_usuario_criacao_com_valor_nulo() {
		empresaBefore.setNomeUsuarioCriacao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_criacao_com_valor_vazio() {
		empresaBefore.setNomeUsuarioCriacao("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_criacao_contendo_espacos_no_comeco() {
		empresaBefore.setNomeUsuarioCriacao(" pauloMachad");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_criacao_contendo_espacos_no_fim() {
		empresaBefore.setNomeUsuarioCriacao("pauloMachad ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_criacao_contendo_espacos() {
		empresaBefore.setNomeUsuarioCriacao("paulo Machad");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_criacao_contendo_mais_de_60_caracteres() {
		empresaBefore.setNomeUsuarioCriacao("pauloMachadfragamatosmachadoPauloFragaMatosMachadoFragaMatosA");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_criacao_contendo_menos_de_4_caracteres() {
		empresaBefore.setNomeUsuarioCriacao("pao");
	}
	/// USUARIO ALTERACAO
	
	@Test
	public void test_deve_settar_nome_usuario_alteracao() {
		String nomeUsuarioUltimaAlteracao = "pauloMachad";
		empresaBefore.setNomeUsuarioUltimaAlteracao(nomeUsuarioUltimaAlteracao);
		assertEquals(nomeUsuarioUltimaAlteracao, empresaBefore.getNomeUsuarioUltimaAlteracao());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_alteracao_contendo_numeros() {
		empresaBefore.setNomeUsuarioUltimaAlteracao("paulo4Machad");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_nome_usuario_alteracao_com_valor_nulo() {
		empresaBefore.setNomeUsuarioUltimaAlteracao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_alteracao_com_valor_vazio() {
		empresaBefore.setNomeUsuarioUltimaAlteracao("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_alteracao_contendo_espacos_no_comeco() {
		empresaBefore.setNomeUsuarioUltimaAlteracao(" pauloMachad");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_alteracao_contendo_espacos_no_fim() {
		empresaBefore.setNomeUsuarioUltimaAlteracao("pauloMachad ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_alteracao_contendo_espacos() {
		empresaBefore.setNomeUsuarioUltimaAlteracao("paulo Machad");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_alteracao_contendo_mais_de_60_caracteres() {
		empresaBefore.setNomeUsuarioUltimaAlteracao("pauloMachadfragamatosmachadoPauloFragaMatosMachadoFragaMatosA");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_nome_usuario_alteracao_contendo_menos_de_4_caracteres() {
		empresaBefore.setNomeUsuarioUltimaAlteracao("pao");
	}
	
	@Test
	public void test_deve_settar_ip_usuario_criacao_corretamente() {
		String ipUsuarioCriacao = "177.92.74.240";
		empresaBefore.setIpUsuarioCriacao(ipUsuarioCriacao);
		assertEquals(ipUsuarioCriacao, empresaBefore.getIpUsuarioCriacao());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_ip_usuario_criacao_com_valor_nulo() {
		empresaBefore.setIpUsuarioCriacao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_usuario_criacao_com_ip_vazio() {
		empresaBefore.setIpUsuarioCriacao("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_usuario_criacao_com_ip_incorreto() {
		empresaBefore.setIpUsuarioCriacao("257.92.74.2");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_usuario_criacao_com_espacos_no_comeco() {
		empresaBefore.setIpUsuarioCriacao(" 257.92.74.2");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_usuario_criacao_com_espacos_no_fim() {
		empresaBefore.setIpUsuarioCriacao("257.92.74.2 ");
	}
	
	// ALTERACAO
	
	@Test
	public void test_deve_settar_ip_usuario_alteracao_corretamente() {
		String ipUsuarioUltimaAlteracao = "177.92.74.240";
		empresaBefore.setIpUsuarioUltimaAlteracao(ipUsuarioUltimaAlteracao);
		assertEquals(ipUsuarioUltimaAlteracao, empresaBefore.getIpUsuarioUltimaAlteracao());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_nao_deve_settar_ip_usuario_alteracao_com_valor_nulo() {
		empresaBefore.setIpUsuarioUltimaAlteracao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_usuario_alteracao_com_ip_vazio() {
		empresaBefore.setIpUsuarioUltimaAlteracao("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_usuario_alteracao_com_ip_incorreto() {
		empresaBefore.setIpUsuarioUltimaAlteracao("257.92.74.2");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_usuario_alteracao_com_espacos_no_comeco() {
		empresaBefore.setIpUsuarioUltimaAlteracao(" 257.92.74.2");
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_nao_deve_settar_ip_usuario_alteracao_com_espacos_no_fim() {
		empresaBefore.setIpUsuarioUltimaAlteracao("257.92.74.2 ");
	}
}
