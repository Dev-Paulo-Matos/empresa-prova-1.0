package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constants.CnpjConstantes.CNPJ_INVALIDO_CNPJ_NAO_PODE_SER_UM_NUMERO_SEQUENCIAL;
import static br.com.contmatic.prova.constants.CnpjConstantes.CNPJ_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.CnpjConstantes.CNPJ_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.CnpjConstantes.CNPJ_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.CnpjConstantes.	CNPJ_NAO_PODE_TER_TAMANHO_DIFERENTE_DE_14;
import static br.com.contmatic.prova.constants.CnpjConstantes.CNPJ_POSSUI_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.constants.CnpjConstantes.TAMANHO_CNPJ;
import static br.com.contmatic.prova.constants.ContatoConstantes.A_LISTA_DE_CONTATO_DEVE_POSSUIR_ENTRE_1_A_20_CONTATO;
import static br.com.contmatic.prova.constants.ContatoConstantes.CONTATO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.ContatoConstantes.CONTATO_TAMANHO_MAXIMO_LISTA;
import static br.com.contmatic.prova.constants.ContatoConstantes.CONTATO_TAMANHO_MINIMO_LISTA;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.LISTA_DEVE_POSSUIR_DE_2_A_20_DEPARTAMENTOS;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.LISTA_DE_DEPARTAMENTO_NAO_PODE_ESTAR_VAZIA;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.TAMANHO_MAX_LISTA_DEPARTAMENTO;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.TAMANHO_MIN_LISTA_DEPARTAMENTO;
import static br.com.contmatic.prova.constants.EmpresaConstantes.NOME_FANTASIA_CONTEM_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.constants.EmpresaConstantes.NOME_FANTASIA_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.EmpresaConstantes.NOME_FANTASIA_NAO_PODE_CONTER_MENOS_QUE_5_E_MAIS_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.EmpresaConstantes.NOME_FANTASIA_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.EmpresaConstantes.NOME_FANTASIA_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.EmpresaConstantes.RAZAO_SOCIAL_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.EmpresaConstantes.RAZAO_SOCIAL_NAO_PODE_CONTER_MENOS_QUE_5_E_NEM_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.EmpresaConstantes.RAZAO_SOCIAL_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.EmpresaConstantes.RAZAO_SOCIAL_NAO_PODE_ESTAR_VAZIA;
import static br.com.contmatic.prova.constants.EmpresaConstantes.RAZAO_SOCIAL_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.EmpresaConstantes.RAZAO_SOCIAL_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.EmpresaConstantes.RAZAO_SOCIAL_POSSUI_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.constants.EnderecoConstantes.ENDERECO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.LISTA_DEVE_POSSUIR_DE_1_A_20_ENDERECOS;
import static br.com.contmatic.prova.constants.EnderecoConstantes.TAMANHO_MAX_ENDERECO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.TAMANHO_MIN_ENDERECO;
import static br.com.contmatic.prova.util.CnpjUtil.validarCnpj;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasENumerosEEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresNumeros;
import static br.com.contmatic.prova.util.ValidatorUtil.validarEspacos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarSeESequencial;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoList;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.auditoria.Auditoria;
import br.com.contmatic.prova.contato.Contato;
import br.com.contmatic.prova.endereco.Endereco;

public class Empresa extends Auditoria {

	private String cnpj;
	
	private String razaoSocial;
	
	private List<Contato> contatos;
	
	private List<Departamento> departamentos;
	
	private List<Endereco> enderecos;

	private String nomeFantasia;
	
	public Empresa(String cnpj) {
		setCnpj(cnpj);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		validarNulo(cnpj, CNPJ_NAO_PODE_ESTAR_NULO);
		validarVazio(cnpj, CNPJ_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(cnpj, CNPJ_POSSUI_ESPACOS_INVALIDOS);
		validarTamanhoString(cnpj, TAMANHO_CNPJ, TAMANHO_CNPJ,CNPJ_NAO_PODE_TER_TAMANHO_DIFERENTE_DE_14);
		validarCaracteresNumeros(cnpj, CNPJ_NAO_DEVE_CONTER_LETRAS_E_NEM_CARACTERES_ESPECIAIS);
		validarSeESequencial(cnpj, TAMANHO_CNPJ, CNPJ_INVALIDO_CNPJ_NAO_PODE_SER_UM_NUMERO_SEQUENCIAL);
		validarCnpj(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		validarNulo(razaoSocial, RAZAO_SOCIAL_NAO_PODE_ESTAR_NULO);
		validarVazio(razaoSocial, RAZAO_SOCIAL_NAO_PODE_ESTAR_VAZIA);
		validarEspacos(razaoSocial, RAZAO_SOCIAL_POSSUI_ESPACOS_INVALIDOS);
		validarTamanhoString(razaoSocial, RAZAO_SOCIAL_NOME_TAMANHO_MINIMO, RAZAO_SOCIAL_NOME_TAMANHO_MAXIMO, RAZAO_SOCIAL_NAO_PODE_CONTER_MENOS_QUE_5_E_NEM_MAIOR_QUE_60_CARACTERES);
		validarCaracteresLetrasENumerosEEspacosEAcentos(razaoSocial, RAZAO_SOCIAL_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
		this.razaoSocial = razaoSocial;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		validarNulo(nomeFantasia, NOME_FANTASIA_NAO_PODE_ESTAR_NULO);
		validarVazio(nomeFantasia, NOME_FANTASIA_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(nomeFantasia, NOME_FANTASIA_CONTEM_ESPACOS_INVALIDOS);
		validarTamanhoString(nomeFantasia, RAZAO_SOCIAL_NOME_TAMANHO_MINIMO, RAZAO_SOCIAL_NOME_TAMANHO_MAXIMO, NOME_FANTASIA_NAO_PODE_CONTER_MENOS_QUE_5_E_MAIS_QUE_60_CARACTERES);
		validarCaracteresLetrasENumerosEEspacosEAcentos(nomeFantasia, NOME_FANTASIA_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
		this.nomeFantasia = nomeFantasia;
	}
	
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		validarNulo(departamentos, LISTA_DE_DEPARTAMENTO_NAO_PODE_ESTAR_VAZIA);
		validarTamanhoList(departamentos, TAMANHO_MIN_LISTA_DEPARTAMENTO, TAMANHO_MAX_LISTA_DEPARTAMENTO, LISTA_DEVE_POSSUIR_DE_2_A_20_DEPARTAMENTOS);
		this.departamentos = departamentos;
}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		validarNulo(contatos, CONTATO_NAO_PODE_ESTAR_VAZIO);
		validarTamanhoList(contatos, CONTATO_TAMANHO_MINIMO_LISTA, CONTATO_TAMANHO_MAXIMO_LISTA, A_LISTA_DE_CONTATO_DEVE_POSSUIR_ENTRE_1_A_20_CONTATO);
		this.contatos = contatos;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		validarNulo(enderecos, ENDERECO_NAO_PODE_ESTAR_NULO);
		validarTamanhoList(enderecos, TAMANHO_MIN_ENDERECO, TAMANHO_MAX_ENDERECO, LISTA_DEVE_POSSUIR_DE_1_A_20_ENDERECOS);
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
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
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empresa [cnpj=");
		builder.append(cnpj);
		builder.append(", razaoSocial=");
		builder.append(razaoSocial);
		builder.append(", contatos=");
		builder.append(contatos);
		builder.append(", departamentos=");
		builder.append(departamentos);
		builder.append(", enderecos=");
		builder.append(enderecos);
		builder.append(", nomeFantasia=");
		builder.append(nomeFantasia);
		builder.append("]");
		return builder.toString();
	}

}
