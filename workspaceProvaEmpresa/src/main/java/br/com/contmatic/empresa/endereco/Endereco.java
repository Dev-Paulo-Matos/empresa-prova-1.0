package br.com.contmatic.empresa.endereco;

import static br.com.contmatic.empresa.constants.Constants.CEP_TAMANHO_FIXO;
import static br.com.contmatic.empresa.constants.Constants.NUMERO_ENDERECO_TAMANHO_MAXIMO;
import static br.com.contmatic.empresa.constants.Constants.NUMERO_ENDERECO_TAMANHO_MINIMO;
import static br.com.contmatic.empresa.constants.Constants.RUA_TAMANHO_MAXIMO;
import static br.com.contmatic.empresa.constants.Constants.RUA_TAMANHO_MINIMO;
import static br.com.contmatic.empresa.constants.Mensagens.CEP_CONTEM_O_NUMERO_DE_DIGITOS_INVALIDO;
import static br.com.contmatic.empresa.constants.Mensagens.NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES;
import static br.com.contmatic.empresa.constants.Mensagens.NUMERO_DA_CASA_CONTEM_A_QUANTIDADE_DE_DIGITOS_INVALIDA;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarCaracteresLetrasENumerosEEspacosEAcentos;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarCaracteresNumeros;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarSeESequencial;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarTamanhoString;

import java.util.Objects;

public class Endereco {
	
	private Cidade cidade;
	
	private String cep;
	
	private String numero;
	
	private String bairro;
	
	private String logradouro;
	
	private String tipoLogradouro;

	public Endereco(String cep, String numero) {
		setCep(cep);
		setNumero(numero);
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		validarNulo(cidade);
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		validarNulo(cep);
		validarCaracteresNumeros(cep);
		validarTamanhoString(cep, CEP_TAMANHO_FIXO, CEP_TAMANHO_FIXO, CEP_CONTEM_O_NUMERO_DE_DIGITOS_INVALIDO);
		validarSeESequencial(cep, CEP_TAMANHO_FIXO);
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		validarNulo(numero);
		validarCaracteresNumeros(numero);
		validarTamanhoString(numero, NUMERO_ENDERECO_TAMANHO_MINIMO, NUMERO_ENDERECO_TAMANHO_MAXIMO, NUMERO_DA_CASA_CONTEM_A_QUANTIDADE_DE_DIGITOS_INVALIDA);
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		validarNulo(logradouro);
		validarCaracteresLetrasENumerosEEspacosEAcentos(logradouro);
		validarTamanhoString(logradouro, RUA_TAMANHO_MINIMO, RUA_TAMANHO_MAXIMO, NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES);
		this.logradouro = logradouro;
	}
	
	public String getBairro() {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		return bairro;
	}

	public void setBairro(String bairro) {
		validarNulo(bairro);
		validarCaracteresLetrasENumerosEEspacosEAcentos(bairro);
		validarTamanhoString(bairro, RUA_TAMANHO_MINIMO, RUA_TAMANHO_MAXIMO, NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES);
		this.bairro = bairro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		validarNulo(tipoLogradouro);
		validarCaracteresLetrasENumerosEEspacosEAcentos(tipoLogradouro);
		validarTamanhoString(tipoLogradouro, RUA_TAMANHO_MINIMO, RUA_TAMANHO_MAXIMO, NOME_DEVE_POSSUIR_DE_3_A_60_CARACTERES);
		this.tipoLogradouro = tipoLogradouro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Endereco [cidade=" + cidade + ", cep=" + cep + ", numero=" + numero + ", bairro=" + bairro
				+ ", logradouro=" + logradouro + ", tipoLogradouro=" + tipoLogradouro + "]";
	}
	
}
