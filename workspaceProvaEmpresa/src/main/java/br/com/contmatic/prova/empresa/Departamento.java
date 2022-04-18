package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constants.DepartamentoConstantes.CODIGO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.CODIGO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.CODIGO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.NOME_CONTEM_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.CODIGO_POSSUI_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.COD_DEPARTAMENTO_DEVE_POSSUIR_5_CARACTERES;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.DEPARTAMENTO_COD_TAMANHO_FIXO;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.DEPARTAMENTO_NAO_PODE_TER_UM_NOME_MENOR_QUE_5_E_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.DEPARTAMENTO_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.DEPARTAMENTO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.NOME_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.NOME_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.NOME_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.EmpresaConstantes.EMPRESA_NAO_PODE_ESTAR_VAZIA;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.LISTA_DE_FUNCIONARIO_DEVE_POSSUIR_DE_2_A_100_FUNCIONARIO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.LISTA_DE_FUNCIONARIO_NAO_PODE_ESTAR_VAZIA;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.TAMANHO_MAX_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.TAMANHO_MIN_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasENumerosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarEspacos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoList;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.auditoria.Auditoria;

public class Departamento extends Auditoria {

	private String nome;
	
	private String codigo;
	
	private List<Funcionario> funcionarios;
	
	private Empresa empresa;
	
	public Departamento(String codigo, Empresa empresa) {
		setCodigo(codigo);
		setEmpresa(empresa);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, NOME_NAO_PODE_ESTAR_NULO);
		validarVazio(nome, NOME_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(nome, NOME_CONTEM_ESPACOS_INVALIDOS);
		validarTamanhoString(nome, DEPARTAMENTO_NOME_TAMANHO_MINIMO, DEPARTAMENTO_NOME_TAMANHO_MAXIMO, DEPARTAMENTO_NAO_PODE_TER_UM_NOME_MENOR_QUE_5_E_MAIOR_QUE_60_CARACTERES);
		validarCaracteresLetrasEspacosEAcentos(nome, NOME_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		validarNulo(codigo, CODIGO_NAO_PODE_ESTAR_NULO);
		validarVazio(codigo, CODIGO_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(codigo, CODIGO_POSSUI_ESPACOS_INVALIDOS);
		validarTamanhoString(codigo, DEPARTAMENTO_COD_TAMANHO_FIXO, DEPARTAMENTO_COD_TAMANHO_FIXO, COD_DEPARTAMENTO_DEVE_POSSUIR_5_CARACTERES);
		validarCaracteresLetrasENumerosEAcentos(codigo, CODIGO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
		this.codigo = codigo;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> list) {
		validarNulo(list, LISTA_DE_FUNCIONARIO_NAO_PODE_ESTAR_VAZIA);
		validarTamanhoList(list, TAMANHO_MIN_LISTA_FUNCIONARIO, TAMANHO_MAX_LISTA_FUNCIONARIO, LISTA_DE_FUNCIONARIO_DEVE_POSSUIR_DE_2_A_100_FUNCIONARIO);
		this.funcionarios = list;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		validarNulo(empresa, EMPRESA_NAO_PODE_ESTAR_VAZIA);
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, empresa);
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
		Departamento other = (Departamento) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(empresa, other.empresa);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Departamento [nome=");
		builder.append(nome);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", funcionarios=");
		builder.append(funcionarios);
		builder.append(", empresa=");
		builder.append(empresa);
		builder.append("]");
		return builder.toString();
	}

}
