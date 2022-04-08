package br.com.contmatic.prova.auditoria;

import static br.com.contmatic.prova.util.DataUtil.validarDataFutura;
import static br.com.contmatic.prova.util.DataUtil.validarDataPassada;
import static br.com.contmatic.prova.util.ValidatorUtil.validarIp;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import org.joda.time.DateTime;

import br.com.contmatic.prova.util.ValidatorUtil;

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

	public DateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public String getNomeUsuarioCriacao() {
		return nomeUsuarioCriacao;
	}

	public String getNomeUsuarioUltimaAlteracao() {
		return nomeUsuarioUltimaAlteracao;
	}
	
	public void setDataCriacao(DateTime dataCriacao) {
		validarNulo(dataCriacao, "Data criação não pode estar nula");
		validarDataFutura(dataCriacao,"Data não pode estar no futuro");
		validarDataPassada(dataCriacao,"Data não pode estar no Passado");
		this.dataCriacao = dataCriacao;
	}

	public void setDataAlteracao(DateTime dataAlteracao) {
		validarNulo(dataAlteracao, "Data Alteração não pode estar nula");
		validarDataFutura(dataAlteracao,"Data não pode estar no futuro");
		validarDataPassada(dataAlteracao,"Data não pode estar no Passado");
		this.dataAlteracao = dataAlteracao;
	}

	public void setNomeUsuarioCriacao(String nomeUsuarioCriacao) {
		this.nomeUsuarioCriacao = nomeUsuarioCriacao;
	}

	public void setNomeUsuarioUltimaAlteracao(String nomeUsuarioUltimaAlteracao) {
		this.nomeUsuarioUltimaAlteracao = nomeUsuarioUltimaAlteracao;
	}
	
	public String getIpUsuarioCriacao() {
		return ipUsuarioCriacao;
	}

	public void setIpUsuarioCriacao(String ipUsuarioCriacao) {
		validarNulo(ipUsuarioCriacao,"Ip do usuario Criação não pode estar nulo");
		validarVazio(ipUsuarioCriacao,"ipUsuarioCriacao não pode estar vazio");
		validarIp(ipUsuarioCriacao,"Ip do usuario Criação não pode estar nulo");
		this.ipUsuarioCriacao = ipUsuarioCriacao;
	}

	public String getIpUsuarioUltimaAlteracao() {
		return ipUsuarioUltimaAlteracao;
	}

	public void setIpUsuarioUltimaAlteracao(String ipUsuarioUltimaAlteracao) {
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
