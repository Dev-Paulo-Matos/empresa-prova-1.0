package br.com.contmatic.prova.auditoria;

import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_ALTERACAO_NAO_PODE_ESTAR_NO_FUTURO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_ALTERACAO_NAO_PODE_ESTAR_NO_PASSADO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_ALTERACAO_NAO_PODE_ESTAR_NULA;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_CRIACAO_NAO_PODE_ESTAR_NO_FUTURO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_CRIACAO_NAO_PODE_ESTAR_NO_PASSADO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.DATA_CRIACAO_NAO_PODE_ESTAR_NULA;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_ALTERACAO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_ALTERACAO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_CRIACAO_NAO_ESTA_VALIDO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_CRIACAO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_CRIACAO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.IP_USUARIO_ULTIMA_ALTERACAO_IP_INVALIDO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_DO_USUARIO_ALTERACAO_NAO_PODE_POSSUIR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_DO_USUARIO_CRIACAO_NAO_PODE_POSSUIR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_MAXIMO_USUARIO_CRIACAO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_MINIMO_USUARIO_CRIACAO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_USUARIO_ULTIMA_ALTERACAO_NAO_PODE_SER_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.NOME_USUARIO_ULTIMA_CRIACAO_NAO_PODE_SER_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.USUARIO_DE_ALTERACAO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.USUARIO_DE_ALTERACAO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.USUARIO_DE_CRIACAO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.AuditoriaConstantes.USUARIO_DE_CRIACAO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.util.AuditoriaUtils.validarDataAlteracaoMaiorQueDataCriacao;
import static br.com.contmatic.prova.util.AuditoriaUtils.validarIp;
import static br.com.contmatic.prova.util.DataUtil.validarDataFutura;
import static br.com.contmatic.prova.util.DataUtil.validarDataPassada;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasENumerosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import org.joda.time.DateTime;

public abstract class Auditoria {

	private DateTime dataCriacao;
	
	private DateTime dataAlteracao;
	
	private String nomeUsuarioCriacao;
	
	private String nomeUsuarioUltimaAlteracao;
	
	private String ipUsuarioCriacao;
	
	private String ipUsuarioUltimaAlteracao;

	public DateTime getDataCriacao() {
		return dataCriacao;
	} 

	public void setDataCriacao(DateTime dataCriacao) {
		validarNulo(dataCriacao, DATA_CRIACAO_NAO_PODE_ESTAR_NULA);
		validarDataFutura(dataCriacao, DATA_CRIACAO_NAO_PODE_ESTAR_NO_FUTURO);
		validarDataPassada(dataCriacao, DATA_CRIACAO_NAO_PODE_ESTAR_NO_PASSADO);
		this.dataCriacao = dataCriacao;
	}
	
	public DateTime getDataAlteracao() {
		return dataAlteracao;
	}
	
	public void setDataAlteracao(DateTime dataAlteracao) {
		validarNulo(dataAlteracao, DATA_ALTERACAO_NAO_PODE_ESTAR_NULA);
		validarDataFutura(dataAlteracao, DATA_ALTERACAO_NAO_PODE_ESTAR_NO_FUTURO);
		validarDataPassada(dataAlteracao,  DATA_ALTERACAO_NAO_PODE_ESTAR_NO_PASSADO);
		validarDataAlteracaoMaiorQueDataCriacao(dataCriacao, dataAlteracao);
		this.dataAlteracao = dataAlteracao;
	}

	public String getNomeUsuarioCriacao() {
		return nomeUsuarioCriacao;
	}

	public void setNomeUsuarioCriacao(String nomeUsuarioCriacao) {
		validarNulo(nomeUsuarioCriacao, USUARIO_DE_CRIACAO_NAO_PODE_SER_NULO);
		validarVazio(nomeUsuarioCriacao, USUARIO_DE_CRIACAO_NAO_PODE_ESTAR_VAZIO);
		validarTamanhoString(nomeUsuarioCriacao, NOME_MINIMO_USUARIO_CRIACAO, NOME_MAXIMO_USUARIO_CRIACAO, NOME_USUARIO_ULTIMA_CRIACAO_NAO_PODE_SER_MAIOR_QUE_60_CARACTERES);
		validarCaracteresLetrasENumerosEAcentos(nomeUsuarioCriacao, NOME_DO_USUARIO_CRIACAO_NAO_PODE_POSSUIR_CARACTERES_ESPECIAIS);
		this.nomeUsuarioCriacao = nomeUsuarioCriacao;
	}
	
	public String getNomeUsuarioUltimaAlteracao() {
		return nomeUsuarioUltimaAlteracao;
	}

	public void setNomeUsuarioUltimaAlteracao(String nomeUsuarioUltimaAlteracao) {
		validarNulo(nomeUsuarioUltimaAlteracao, USUARIO_DE_ALTERACAO_NAO_PODE_SER_NULO);
		validarVazio(nomeUsuarioUltimaAlteracao, USUARIO_DE_ALTERACAO_NAO_PODE_ESTAR_VAZIO);
		validarTamanhoString(nomeUsuarioUltimaAlteracao, NOME_MINIMO_USUARIO_CRIACAO, NOME_MAXIMO_USUARIO_CRIACAO, NOME_USUARIO_ULTIMA_ALTERACAO_NAO_PODE_SER_MAIOR_QUE_60_CARACTERES);
		validarCaracteresLetrasENumerosEAcentos(nomeUsuarioUltimaAlteracao, NOME_DO_USUARIO_ALTERACAO_NAO_PODE_POSSUIR_CARACTERES_ESPECIAIS);
		this.nomeUsuarioUltimaAlteracao = nomeUsuarioUltimaAlteracao;
	}
	
	public String getIpUsuarioCriacao() {
		return ipUsuarioCriacao;
	}

	public void setIpUsuarioCriacao(String ipUsuarioCriacao) {
		validarNulo(ipUsuarioCriacao, IP_USUARIO_CRIACAO_NAO_PODE_ESTAR_NULO);
		validarVazio(ipUsuarioCriacao, IP_USUARIO_CRIACAO_NAO_PODE_ESTAR_VAZIO);
		validarIp(ipUsuarioCriacao, IP_USUARIO_CRIACAO_NAO_ESTA_VALIDO);
		this.ipUsuarioCriacao = ipUsuarioCriacao;
	}


	public String getIpUsuarioUltimaAlteracao() {
		return ipUsuarioUltimaAlteracao;
	}

	public void setIpUsuarioUltimaAlteracao(String ipUsuarioUltimaAlteracao) {
		validarNulo(ipUsuarioUltimaAlteracao, IP_USUARIO_ALTERACAO_NAO_PODE_ESTAR_NULO);
		validarVazio(ipUsuarioUltimaAlteracao, IP_USUARIO_ALTERACAO_NAO_PODE_ESTAR_VAZIO);
		validarIp(ipUsuarioUltimaAlteracao, IP_USUARIO_ULTIMA_ALTERACAO_IP_INVALIDO);
		this.ipUsuarioUltimaAlteracao = ipUsuarioUltimaAlteracao;
	}
	
}
