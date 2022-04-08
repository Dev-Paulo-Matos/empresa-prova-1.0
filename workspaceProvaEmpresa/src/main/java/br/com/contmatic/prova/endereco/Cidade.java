package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.constants.CidadeConstants.CODIGO_IBGE_DEVE_CONTER_APENAS_NUMEROS;
import static br.com.contmatic.prova.constants.CidadeConstants.CODIGO_IBGE_DEVE_POSSUIR_5_CARACTERES;
import static br.com.contmatic.prova.constants.CidadeConstants.CODIGO_IBGE_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.CidadeConstants.CODIGO_IBGE_TAMNHO_FIXO;
import static br.com.contmatic.prova.constants.CidadeConstants.NOME_CIDADE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.CidadeConstants.NOME_CIDADE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.CidadeConstants.NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES;
import static br.com.contmatic.prova.constants.CidadeConstants.NOME_NAO_PODE_CONTER_NUMEROS_E_NEM_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.CidadeConstants.NOME_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.CidadeConstants.UF_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresNumeros;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;

import java.util.Objects;

public class Cidade {

	private String codigoIbge;
	
	private String nome;
	
	private Uf uf;
	
	public Cidade(String codigoIbge) {
		setCodigoIbge(codigoIbge);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome,NOME_NAO_PODE_ESTAR_VAZIO);
		validarCaracteresLetrasEspacosEAcentos(nome,NOME_NAO_PODE_CONTER_NUMEROS_E_NEM_CARACTERES_ESPECIAIS);
		validarTamanhoString(nome, NOME_CIDADE_TAMANHO_MINIMO, NOME_CIDADE_TAMANHO_MAXIMO, NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES);
		this.nome = nome;
	}

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		validarNulo(codigoIbge,CODIGO_IBGE_NAO_PODE_ESTAR_VAZIO);
		validarCaracteresNumeros(codigoIbge,CODIGO_IBGE_DEVE_CONTER_APENAS_NUMEROS);
		validarTamanhoString(codigoIbge, CODIGO_IBGE_TAMNHO_FIXO, CODIGO_IBGE_TAMNHO_FIXO, CODIGO_IBGE_DEVE_POSSUIR_5_CARACTERES);
		this.codigoIbge = codigoIbge;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		validarNulo(uf,UF_NAO_PODE_ESTAR_VAZIO);
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
		StringBuilder builder = new StringBuilder();
		builder.append("Cidade [nome=");
		builder.append(nome);
		builder.append(", codigoIbge=");
		builder.append(codigoIbge);
		builder.append(", uf=");
		builder.append(uf);
		builder.append("]");
		return builder.toString();
	}
}
