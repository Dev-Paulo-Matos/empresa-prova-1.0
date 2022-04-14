package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.constants.CidadeConstantes.CIDADE_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.BAIRRO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.EnderecoConstantes.BAIRRO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.BAIRRO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.BAIRRO_NAO_PODE_SER_MENOR_QUE_3_E_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.EnderecoConstantes.CEP_CONTEM_O_NUMERO_DE_DIGITOS_INVALIDO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.CEP_DEVE_CONTER_APENAS_NUMEROS;
import static br.com.contmatic.prova.constants.EnderecoConstantes.CEP_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.CEP_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.CEP_NAO_PODE_POSSUIR_UM_VALOR_SEQUENCIAL;
import static br.com.contmatic.prova.constants.EnderecoConstantes.CEP_POSSUI_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.constants.EnderecoConstantes.CEP_TAMANHO_FIXO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.LOGRADOURO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.EnderecoConstantes.LOGRADOURO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.LOGRADOURO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.LOGRADOURO_NAO_PODE_SER_MENOR_QUE_3_E_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.EnderecoConstantes.NUMERO_MAIOR_QUE_9999;
import static br.com.contmatic.prova.constants.EnderecoConstantes.NUMERO_MENOR_QUE_1;
import static br.com.contmatic.prova.constants.EnderecoConstantes.NUMERO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.O_NUMERO_MAIOR_QUE_9999_E_MENOR_QUE_1;
import static br.com.contmatic.prova.constants.EnderecoConstantes.RUA_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.RUA_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.TIPO_DO_LOGRADOURO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.TIPO_DO_LOGRADOURO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.TIPO_DO_LOGRADOURO_PODE_CONTER_APENAS_LETRAS_E_ACENTOS;
import static br.com.contmatic.prova.constants.EnderecoConstantes.TIPO_LOGRADOURO_MAX;
import static br.com.contmatic.prova.constants.EnderecoConstantes.TIPO_LOGRADOURO_MIN;
import static br.com.contmatic.prova.constants.EnderecoConstantes.TIPO_LOGRADOURO_NAO_PODE_SER_MENOR_QUE_3_E_MAIOR_QUE_20_CARACTERES;
import static br.com.contmatic.prova.constants.EnderecoConstantes.TIPO_LOGRADOURO_POSSUI_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasENumerosEEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresNumeros;
import static br.com.contmatic.prova.util.ValidatorUtil.validarEspacos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNumero;
import static br.com.contmatic.prova.util.ValidatorUtil.validarSeESequencial;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import java.util.Objects;

import br.com.contmatic.prova.util.ValidatorUtil;

public class Endereco {

	private String cep;
	
	private Integer numero;
	
	private Cidade cidade;

	private String bairro;
	
	private String logradouro;
	
	private String tipoLogradouro;

	public Endereco(String cep, Integer numero) {
		setCep(cep);
		setNumero(numero);
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		validarNulo(cidade, CIDADE_NAO_PODE_ESTAR_NULO);
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		validarNulo(cep, CEP_NAO_PODE_ESTAR_NULO);
		validarVazio(cep, CEP_NAO_PODE_ESTAR_VAZIO);
		ValidatorUtil.validarEspacos(cep, CEP_POSSUI_ESPACOS_INVALIDOS);
		validarCaracteresNumeros(cep, CEP_DEVE_CONTER_APENAS_NUMEROS);
		validarTamanhoString(cep, CEP_TAMANHO_FIXO, CEP_TAMANHO_FIXO, CEP_CONTEM_O_NUMERO_DE_DIGITOS_INVALIDO);
		validarSeESequencial(cep, CEP_TAMANHO_FIXO, CEP_NAO_PODE_POSSUIR_UM_VALOR_SEQUENCIAL);
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		validarNulo(numero, NUMERO_NAO_PODE_ESTAR_VAZIO);
		validarNumero(numero, NUMERO_MENOR_QUE_1, NUMERO_MAIOR_QUE_9999, O_NUMERO_MAIOR_QUE_9999_E_MENOR_QUE_1);
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		validarNulo(logradouro, LOGRADOURO_NAO_PODE_ESTAR_NULO);
		validarVazio(logradouro, LOGRADOURO_NAO_PODE_ESTAR_VAZIO);
		validarCaracteresLetrasENumerosEEspacosEAcentos(logradouro, LOGRADOURO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
		validarTamanhoString(logradouro, RUA_TAMANHO_MINIMO, RUA_TAMANHO_MAXIMO, LOGRADOURO_NAO_PODE_SER_MENOR_QUE_3_E_MAIOR_QUE_60_CARACTERES);
		this.logradouro = logradouro;
	}
	
	public String getBairro() {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		return bairro;
	}

	public void setBairro(String bairro) {
		validarNulo(bairro, BAIRRO_NAO_PODE_ESTAR_NULO);
		validarVazio(bairro, BAIRRO_NAO_PODE_ESTAR_VAZIO);
		validarCaracteresLetrasENumerosEEspacosEAcentos(bairro, BAIRRO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
		validarTamanhoString(bairro, RUA_TAMANHO_MINIMO, RUA_TAMANHO_MAXIMO, BAIRRO_NAO_PODE_SER_MENOR_QUE_3_E_MAIOR_QUE_60_CARACTERES);
		this.bairro = bairro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		validarNulo(tipoLogradouro, TIPO_DO_LOGRADOURO_NAO_PODE_ESTAR_NULO);
		validarVazio(tipoLogradouro, TIPO_DO_LOGRADOURO_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(tipoLogradouro, TIPO_LOGRADOURO_POSSUI_ESPACOS_INVALIDOS);
		validarCaracteresLetrasEAcentos(tipoLogradouro, TIPO_DO_LOGRADOURO_PODE_CONTER_APENAS_LETRAS_E_ACENTOS);
		validarTamanhoString(tipoLogradouro, TIPO_LOGRADOURO_MIN, TIPO_LOGRADOURO_MAX, TIPO_LOGRADOURO_NAO_PODE_SER_MENOR_QUE_3_E_MAIOR_QUE_20_CARACTERES);
		this.tipoLogradouro = tipoLogradouro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {			
			return true;
		}
		if (obj == null) {			
			return false;
		}
		if (getClass() != obj.getClass()) {			
			return false;
		}
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Endereco [cidade=");
		builder.append(cidade);
		builder.append(", cep=");
		builder.append(cep);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", bairro=");
		builder.append(bairro);
		builder.append(", logradouro=");
		builder.append(logradouro);
		builder.append(", tipoLogradouro=");
		builder.append(tipoLogradouro);
		builder.append("]");
		return builder.toString();
	}
}
