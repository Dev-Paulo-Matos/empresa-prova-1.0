package br.com.contmatic.prova.auditoria;

import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_ALTERACAO_NAO_PODE_ESTAR_NO_FUTURO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_ALTERACAO_NAO_PODE_ESTAR_NO_PASSADO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_ALTERACAO_NAO_PODE_ESTAR_NULA;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_ALTERACAO_NAO_PODE_SER_ANTERIOR_A_DATA_CRIACAO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_CRIACAO_NAO_PODE_ESTAR_NO_FUTURO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_CRIACAO_NAO_PODE_ESTAR_NO_PASSADO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_CRIACAO_NAO_PODE_ESTAR_NULA;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_ALTERACAO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_ALTERACAO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_CRIACAO_NAO_ESTA_VALIDO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_CRIACAO_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_CRIACAO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_CRIACAO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_ULTIMA_ALTERACAO_IP_INVALIDO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_ULTIMA_ALTERACAO_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_DO_USUARIO_ALTERACAO_NAO_PODE_POSSUIR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_DO_USUARIO_CRIACAO_NAO_PODE_POSSUIR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_MAXIMO_USUARIO_CRIACAO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_MINIMO_USUARIO_CRIACAO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_USUARIO_CRIACAO_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_USUARIO_ULTIMA_ALTERACAO_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_USUARIO_ULTIMA_ALTERACAO_NAO_PODE_SER_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_USUARIO_ULTIMA_CRIACAO_NAO_PODE_SER_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.USUARIO_DE_ALTERACAO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.USUARIO_DE_ALTERACAO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.USUARIO_DE_CRIACAO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.USUARIO_DE_CRIACAO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.util.DataUtil.validarDataAlteracaoAnteriorADataCriacao;
import static br.com.contmatic.prova.util.DataUtil.validarDataFuturoAuditoria;
import static br.com.contmatic.prova.util.DataUtil.validarDataPassadoAuditoria;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetras;
import static br.com.contmatic.prova.util.ValidatorUtil.validarEspacos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarIp;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import org.joda.time.LocalDateTime;

public abstract class Auditoria {

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private String nomeUsuarioCriacao;

    private String nomeUsuarioUltimaAlteracao;

    private String ipUsuarioCriacao;

    private String ipUsuarioUltimaAlteracao;

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        validarNulo(dataCriacao, DATA_CRIACAO_NAO_PODE_ESTAR_NULA);
        validarDataPassadoAuditoria(dataCriacao, DATA_CRIACAO_NAO_PODE_ESTAR_NO_PASSADO);
        validarDataFuturoAuditoria(dataCriacao, DATA_CRIACAO_NAO_PODE_ESTAR_NO_FUTURO);
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        validarNulo(dataAlteracao, DATA_ALTERACAO_NAO_PODE_ESTAR_NULA);
        validarNulo(dataCriacao, DATA_CRIACAO_NAO_PODE_ESTAR_NULA);
        validarDataFuturoAuditoria(dataAlteracao, DATA_ALTERACAO_NAO_PODE_ESTAR_NO_FUTURO);
        validarDataPassadoAuditoria(dataAlteracao, DATA_ALTERACAO_NAO_PODE_ESTAR_NO_PASSADO);
        validarDataAlteracaoAnteriorADataCriacao(dataCriacao, dataAlteracao, DATA_ALTERACAO_NAO_PODE_SER_ANTERIOR_A_DATA_CRIACAO);
        this.dataAlteracao = dataAlteracao;
    }

    public String getNomeUsuarioCriacao() {
        return nomeUsuarioCriacao;
    }

    public void setNomeUsuarioCriacao(String nomeUsuarioCriacao) {
        validarNulo(nomeUsuarioCriacao, USUARIO_DE_CRIACAO_NAO_PODE_SER_NULO);
        validarVazio(nomeUsuarioCriacao, USUARIO_DE_CRIACAO_NAO_PODE_ESTAR_VAZIO);
        validarEspacos(nomeUsuarioCriacao, NOME_USUARIO_CRIACAO_NAO_PODE_CONTER_ESPACOS);
        validarTamanhoString(nomeUsuarioCriacao, NOME_MINIMO_USUARIO_CRIACAO, NOME_MAXIMO_USUARIO_CRIACAO, NOME_USUARIO_ULTIMA_CRIACAO_NAO_PODE_SER_MAIOR_QUE_60_CARACTERES);
        validarCaracteresLetras(nomeUsuarioCriacao, NOME_DO_USUARIO_CRIACAO_NAO_PODE_POSSUIR_CARACTERES_ESPECIAIS);
        this.nomeUsuarioCriacao = nomeUsuarioCriacao;
    }

    public String getNomeUsuarioUltimaAlteracao() {
        return nomeUsuarioUltimaAlteracao;
    }

    public void setNomeUsuarioUltimaAlteracao(String nomeUsuarioUltimaAlteracao) {
        validarNulo(nomeUsuarioUltimaAlteracao, USUARIO_DE_ALTERACAO_NAO_PODE_SER_NULO);
        validarVazio(nomeUsuarioUltimaAlteracao, USUARIO_DE_ALTERACAO_NAO_PODE_ESTAR_VAZIO);
        validarEspacos(nomeUsuarioUltimaAlteracao, NOME_USUARIO_ULTIMA_ALTERACAO_NAO_PODE_CONTER_ESPACOS);
        validarTamanhoString(nomeUsuarioUltimaAlteracao, NOME_MINIMO_USUARIO_CRIACAO, NOME_MAXIMO_USUARIO_CRIACAO, NOME_USUARIO_ULTIMA_ALTERACAO_NAO_PODE_SER_MAIOR_QUE_60_CARACTERES);
        validarCaracteresLetras(nomeUsuarioUltimaAlteracao, NOME_DO_USUARIO_ALTERACAO_NAO_PODE_POSSUIR_CARACTERES_ESPECIAIS);
        this.nomeUsuarioUltimaAlteracao = nomeUsuarioUltimaAlteracao;
    }

    public String getIpUsuarioCriacao() {
        return ipUsuarioCriacao;
    }

    public void setIpUsuarioCriacao(String ipUsuarioCriacao) {
        validarNulo(ipUsuarioCriacao, IP_USUARIO_CRIACAO_NAO_PODE_ESTAR_NULO);
        validarVazio(ipUsuarioCriacao, IP_USUARIO_CRIACAO_NAO_PODE_ESTAR_VAZIO);
        validarEspacos(ipUsuarioCriacao, IP_USUARIO_CRIACAO_NAO_PODE_CONTER_ESPACOS);
        validarIp(ipUsuarioCriacao, IP_USUARIO_CRIACAO_NAO_ESTA_VALIDO);
        this.ipUsuarioCriacao = ipUsuarioCriacao;
    }

    public String getIpUsuarioUltimaAlteracao() {
        return ipUsuarioUltimaAlteracao;
    }

    public void setIpUsuarioUltimaAlteracao(String ipUsuarioUltimaAlteracao) {
        validarNulo(ipUsuarioUltimaAlteracao, IP_USUARIO_ALTERACAO_NAO_PODE_ESTAR_NULO);
        validarVazio(ipUsuarioUltimaAlteracao, IP_USUARIO_ALTERACAO_NAO_PODE_ESTAR_VAZIO);
        validarEspacos(ipUsuarioUltimaAlteracao, IP_USUARIO_ULTIMA_ALTERACAO_NAO_PODE_CONTER_ESPACOS);
        validarIp(ipUsuarioUltimaAlteracao, IP_USUARIO_ULTIMA_ALTERACAO_IP_INVALIDO);
        this.ipUsuarioUltimaAlteracao = ipUsuarioUltimaAlteracao;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Auditoria [dataCriacao=");
        builder.append(dataCriacao);
        builder.append(", dataAlteracao=");
        builder.append(dataAlteracao);
        builder.append(", nomeUsuarioCriacao=");
        builder.append(nomeUsuarioCriacao);
        builder.append(", nomeUsuarioUltimaAlteracao=");
        builder.append(nomeUsuarioUltimaAlteracao);
        builder.append(", ipUsuarioCriacao=");
        builder.append(ipUsuarioCriacao);
        builder.append(", ipUsuarioUltimaAlteracao=");
        builder.append(ipUsuarioUltimaAlteracao);
        builder.append("]");
        return builder.toString();
    }

}
