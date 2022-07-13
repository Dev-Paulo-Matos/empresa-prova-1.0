package br.com.contmatic.empresa.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Empresa;

public class AuditoriaTest {

    private static final String IP_CRIACAO = "177.92.74.240";
    private static final String IP_ALTERACAO = "177.92.74.240";
    private static final String CNPJ = "01395109000138";
    private static final LocalDateTime time1 = LocalDateTime.now();
    private static final LocalDateTime time2 = LocalDateTime.now();
    
    private Empresa empresaBefore;

    @Before
    public void deve_criar_antes_de_todos_os_testes() {
        empresaBefore = new Empresa(CNPJ);
    }

    @Test
    public void test_deve_settar_data_criacao_corretamente() {
        LocalDateTime now = LocalDateTime.now();
        empresaBefore.setDataCriacao(now);
        assertEquals(now, empresaBefore.getDataCriacao());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_nao_deve_settar_data_criacao_nula() {
        empresaBefore.setDataCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void test_nao_deve_settar_data_criacao_com_data_no_passado() {
        empresaBefore.setDataCriacao(LocalDateTime.now().plusDays(-4));
    }

    @Test(expected = IllegalStateException.class)
    public void test_nao_deve_settar_data_criacao_com_data_no_futuro() {
        empresaBefore.setDataCriacao(LocalDateTime.now().plusDays(4));
    }

    @Test
    public void test_deve_settar_data_alteracao_corretamente() {
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now();
        empresaBefore.setDataCriacao(time);
        empresaBefore.setDataAlteracao(time2);
        assertEquals(time2, empresaBefore.getDataAlteracao());
    }

    @Test
    public void test_deve_settar_data_alteracao_apos_data_criacao() {
        LocalDateTime time = LocalDateTime.now();
        empresaBefore.setDataCriacao(time);
        LocalDateTime time2 = LocalDateTime.now();
        empresaBefore.setDataAlteracao(time2);
        assertEquals(time2, empresaBefore.getDataAlteracao());
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_nao_deve_settar_data_alteracao_anterior_a_data_criacao() {
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now();
        empresaBefore.setDataCriacao(time);
        empresaBefore.setDataAlteracao(time2.plusMinutes(-1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_nao_deve_settar_data_alteracao_nula() {
        LocalDateTime time = LocalDateTime.now();
        empresaBefore.setDataCriacao(time);
        empresaBefore.setDataAlteracao(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_nao_deve_settar_data_alteracao_com_data_criacao_nula() {
        LocalDateTime time = LocalDateTime.now();
        empresaBefore.setDataAlteracao(time);
    }

    @Test(expected = IllegalStateException.class)
    public void test_nao_deve_settar_data_alteracao_no_passado() {
        LocalDateTime time = LocalDateTime.now();
        empresaBefore.setDataCriacao(time);
        empresaBefore.setDataAlteracao(time.plusDays(-3));
    }

    @Test(expected = IllegalStateException.class)
    public void test_nao_deve_settar_data_alteracao_com_data_no_futuro() {
        LocalDateTime time = LocalDateTime.now();
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
    
    @Test
    public void test_deve_retornar_to_string_corretamente() {
        empresaBefore.setDataCriacao(time1);
        empresaBefore.setDataAlteracao(time2);
        empresaBefore.setIpUsuarioCriacao(IP_CRIACAO);
        empresaBefore.setIpUsuarioUltimaAlteracao(IP_ALTERACAO);
        assertTrue(empresaBefore.toString().contains(time1.toString()));
        assertTrue(empresaBefore.toString().contains(time2.toString()));
        assertTrue(empresaBefore.toString().contains(IP_CRIACAO));
        assertTrue(empresaBefore.toString().contains(IP_ALTERACAO));
        assertTrue(empresaBefore.toString().contains(CNPJ));
    }
    
}
