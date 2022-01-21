package br.com.contmatic.empresa.auditoria;

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
		this.dataCriacao = dataCriacao;
	}

	public void setDataAlteracao(DateTime dataAlteracao) {
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
		this.ipUsuarioCriacao = ipUsuarioCriacao;
	}

	public String getIpUsuarioUltimaAlteracao() {
		return ipUsuarioUltimaAlteracao;
	}

	public void setIpUsuarioUltimaAlteracao(String ipUsuarioUltimaAlteracao) {
		this.ipUsuarioUltimaAlteracao = ipUsuarioUltimaAlteracao;
	}

}
