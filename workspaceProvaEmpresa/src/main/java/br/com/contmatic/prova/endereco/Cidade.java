package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.constants.CidadeConstantes.CODIGO_IBGE_DEVE_POSSUIR_5_DIGITOS;
import static br.com.contmatic.prova.constants.CidadeConstantes.CODIGO_IBGE_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.CidadeConstantes.NOME_CIDADE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.CidadeConstantes.NOME_CIDADE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.CidadeConstantes.NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES;
import static br.com.contmatic.prova.constants.CidadeConstantes.NOME_NAO_PODE_CONTER_NUMEROS_E_NEM_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.CidadeConstantes.NOME_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.CidadeConstantes.NOME_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.CidadeConstantes.NUMERO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.CidadeConstantes.NUMERO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.CidadeConstantes.UF_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNumero;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import java.util.Objects;

public class Cidade {

	private Integer codigoIbge;
	
	private String nome;
	
	private Uf uf;
	
	public Cidade(Integer codigoIbge) {
		setCodigoIbge(codigoIbge);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, NOME_NAO_PODE_ESTAR_NULO);
		validarVazio(nome, NOME_NAO_PODE_ESTAR_VAZIO);
		validarCaracteresLetrasEspacosEAcentos(nome, NOME_NAO_PODE_CONTER_NUMEROS_E_NEM_CARACTERES_ESPECIAIS);
		validarTamanhoString(nome, NOME_CIDADE_TAMANHO_MINIMO, NOME_CIDADE_TAMANHO_MAXIMO, NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES);
		this.nome = nome;
	}

	public Integer getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(Integer codigoIbge) {
		validarNulo(codigoIbge,CODIGO_IBGE_NAO_PODE_ESTAR_NULO);
		validarNumero(codigoIbge, NUMERO_TAMANHO_MINIMO, NUMERO_TAMANHO_MAXIMO, CODIGO_IBGE_DEVE_POSSUIR_5_DIGITOS);
		this.codigoIbge = codigoIbge;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		validarNulo(uf,UF_NAO_PODE_ESTAR_NULO);
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
