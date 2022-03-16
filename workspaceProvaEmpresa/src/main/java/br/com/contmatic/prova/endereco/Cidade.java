package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.constants.CidadeConstants.CODIGO_IBGE_TAMNHO_FIXO;
import static br.com.contmatic.prova.constants.CidadeConstants.NOME_CIDADE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.CidadeConstants.NOME_CIDADE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.CidadeConstants.UF_CIDADE_TAMANHO_FIXO;
import static br.com.contmatic.prova.constants.CidadeConstants.CODIGO_IBGE_DEVE_POSSUIR_5_CARACTERES;
import static br.com.contmatic.prova.constants.CidadeConstants.NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES;
import static br.com.contmatic.prova.constants.CidadeConstants.UF_CONTEM_O_NUMERO_DE_DIGITOS_INVALIDO;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresNumeros;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;

import java.util.Objects;

public class Cidade {
	
	private String nome;
	
	private String codigoIbge;
	
	private String uf;

	public Cidade(String codigoIbge) {
		setCodigoIbge(codigoIbge);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome);
		validarCaracteresLetrasEspacosEAcentos(nome);
		validarTamanhoString(nome, NOME_CIDADE_TAMANHO_MINIMO, NOME_CIDADE_TAMANHO_MAXIMO, NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES);
		this.nome = nome;
	}

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		validarNulo(codigoIbge);
		validarCaracteresNumeros(codigoIbge);
		validarTamanhoString(codigoIbge, CODIGO_IBGE_TAMNHO_FIXO, CODIGO_IBGE_TAMNHO_FIXO, CODIGO_IBGE_DEVE_POSSUIR_5_CARACTERES);
		this.codigoIbge = codigoIbge;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		validarNulo(uf);
		validarCaracteresLetrasEAcentos(uf);
		validarTamanhoString(uf, UF_CIDADE_TAMANHO_FIXO, UF_CIDADE_TAMANHO_FIXO, UF_CONTEM_O_NUMERO_DE_DIGITOS_INVALIDO);
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoIbge);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(codigoIbge, other.codigoIbge);
	}

	@Override
	public String toString() {
		return "Cidade [nome=" + nome + ", codigoIbge=" + codigoIbge + ", uf=" + uf + "]";
	}

	
	
	
}
