package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constants.EmpresaConstants.RAZAO_SOCIAL_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.EmpresaConstants.RAZAO_SOCIAL_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.UtilsConstants.TAMANHO_MAX_ENDERECO;
import static br.com.contmatic.prova.constants.UtilsConstants.TAMANHO_MAX_LISTA_DEPARTAMENTO;
import static br.com.contmatic.prova.constants.UtilsConstants.TAMANHO_MIN_ENDERECO;
import static br.com.contmatic.prova.constants.UtilsConstants.TAMANHO_MIN_LISTA_DEPARTAMENTO;
import static br.com.contmatic.prova.constants.UtilsConstants.LISTA_DEVE_POSSUIR_DE_1_A_20_ENDERECOS;
import static br.com.contmatic.prova.constants.UtilsConstants.LISTA_DEVE_POSSUIR_DE_2_A_20_DEPARTAMENTOS;
import static br.com.contmatic.prova.util.CnpjUtil.validarCnpj;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasENumerosEEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoList;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.auditoria.Auditoria;
import br.com.contmatic.prova.contato.Contato;
import br.com.contmatic.prova.endereco.Endereco;

public class Empresa extends Auditoria {
	
	private String cnpj;
	
	private String razaoSocial;
	
	private Contato contato;
	
	private List<Departamento> departamentos;
	
	private List<Endereco> enderecos;

	private String nomeFantasia;
	
	public Empresa(String cnpj, String razaoSocial) {
		setCnpj(cnpj);
		setRazaoSocial(razaoSocial);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		validarCnpj(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		validarNulo(razaoSocial);
		validarTamanhoString(razaoSocial, RAZAO_SOCIAL_NOME_TAMANHO_MINIMO, RAZAO_SOCIAL_NOME_TAMANHO_MAXIMO);
		validarCaracteresLetrasENumerosEEspacosEAcentos(razaoSocial);
		this.razaoSocial = razaoSocial;
	}
	
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		validarNulo(departamentos);
		validarTamanhoList(departamentos, TAMANHO_MIN_LISTA_DEPARTAMENTO, TAMANHO_MAX_LISTA_DEPARTAMENTO, LISTA_DEVE_POSSUIR_DE_2_A_20_DEPARTAMENTOS);
		this.departamentos = departamentos;
}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		validarNulo(nomeFantasia);
		validarTamanhoString(nomeFantasia,RAZAO_SOCIAL_NOME_TAMANHO_MINIMO,RAZAO_SOCIAL_NOME_TAMANHO_MAXIMO);
		validarCaracteresLetrasENumerosEEspacosEAcentos(nomeFantasia);
		this.nomeFantasia = nomeFantasia;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		validarNulo(contato);
		this.contato = contato;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		validarNulo(enderecos);
		validarTamanhoList(enderecos, TAMANHO_MIN_ENDERECO, TAMANHO_MAX_ENDERECO, LISTA_DEVE_POSSUIR_DE_1_A_20_ENDERECOS);
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", contato=" + contato + ", departamentos="
				+ departamentos + ", enderecos=" + enderecos + ", nomeFantasia=" + nomeFantasia + "]";
	}

	

	
}
