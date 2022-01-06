package br.com.contmatic.empresa.empresa;

import static br.com.contmatic.empresa.constants.Constants.DEPARTAMENTO_COD_TAMANHO_FIXO;
import static br.com.contmatic.empresa.constants.Constants.DEPARTAMENTO_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.empresa.constants.Constants.DEPARTAMENTO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.empresa.constants.Constants.TAMANHO_MAX_LISTA_FUNCIONARIO;
import static br.com.contmatic.empresa.constants.Constants.TAMANHO_MIN_LISTA_FUNCIONARIO;
import static br.com.contmatic.empresa.constants.Mensagens.COD_DEPARTAMENTO_DEVE_POSSUIR_5_CARACTERES;
import static br.com.contmatic.empresa.constants.Mensagens.LISTA_DEVE_POSSUIR_DE_2_A_100_FUNCIONARIOS;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarCaracteresLetrasENumerosEAcentos;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarCaracteresLetrasEspacosEAcentos;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarTamanhoList;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarTamanhoString;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.empresa.funcionario.Funcionario;

public class Departamento {

	private String nome;
	
	private String codigo;
	
	private List<Funcionario> funcionarios;
	
	private Empresa empresa;
	
	public Departamento(String nome, String codigo) {
		setNome(nome);
		setCodigo(codigo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome);
		validarTamanhoString(nome, DEPARTAMENTO_NOME_TAMANHO_MINIMO, DEPARTAMENTO_NOME_TAMANHO_MAXIMO);
		validarCaracteresLetrasEspacosEAcentos(nome);
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		validarNulo(codigo);
		validarTamanhoString(codigo, DEPARTAMENTO_COD_TAMANHO_FIXO, DEPARTAMENTO_COD_TAMANHO_FIXO, COD_DEPARTAMENTO_DEVE_POSSUIR_5_CARACTERES);
		validarCaracteresLetrasENumerosEAcentos(codigo);
		this.codigo = codigo;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> list) {
		validarNulo(list);
		validarTamanhoList(list, TAMANHO_MIN_LISTA_FUNCIONARIO, TAMANHO_MAX_LISTA_FUNCIONARIO, LISTA_DEVE_POSSUIR_DE_2_A_100_FUNCIONARIOS);
		this.funcionarios = list;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		validarNulo(empresa);
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Departamento [nome=" + nome + ", codigo=" + codigo + ", funcionarios=" + funcionarios + ", empresa="
				+ empresa + "]";
	}

	

}
