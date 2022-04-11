package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constants.ContatoConstantes.CONTATO_NULO;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.DEPARTAMENTO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.EmpresaConstantes.EMPRESA_NAO_PODE_SER_NULA;
import static br.com.contmatic.prova.constants.EnderecoConstantes.ENDERECO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.CARGO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.CARGO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.CARGO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.CARGO_NAO_PODE_SER_MENOR_QUE_5_E_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.DATA_NULA;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.FUNCIONARIO_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.FUNCIONARIO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.CARGO_NAO_PODE_POSSUIR_ESPACOS;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.NOME_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.NOME_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.NOME_NAO_PODE_POSSUIR_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.NOME_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.NOME_NAO_PODE_SER_MENOR_QUE_5_E_NEM_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.util.CpfUtil.validarCpf;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarEspacos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import java.util.List;
import java.util.Objects;

import org.joda.time.LocalDate;

import br.com.contmatic.prova.auditoria.Auditoria;
import br.com.contmatic.prova.contato.Contato;
import br.com.contmatic.prova.endereco.Endereco;

public class Funcionario extends Auditoria {

	private String cpf;

	private Empresa empresa;
	
	private LocalDate dataNascimento;

	private String cargo;

	private List<Contato> contatos;
	
	private Departamento departamento;
	
	private Endereco endereco;
	
	private String nomeCompleto;
	
	public Funcionario(String cpf,Empresa empresa) {
		setCpf(cpf);
		setEmpresa(empresa);
	}
	
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		validarNulo(nomeCompleto, NOME_NAO_PODE_ESTAR_NULO);
		validarVazio(nomeCompleto, NOME_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(nomeCompleto, NOME_NAO_PODE_POSSUIR_ESPACOS_INVALIDOS);
		validarTamanhoString(nomeCompleto, FUNCIONARIO_NOME_TAMANHO_MINIMO, FUNCIONARIO_NOME_TAMANHO_MAXIMO, NOME_NAO_PODE_SER_MENOR_QUE_5_E_NEM_MAIOR_QUE_60_CARACTERES);
		validarCaracteresLetrasEspacosEAcentos(nomeCompleto, NOME_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getCpf() {
		return cpf;
	 }
	
	public void setCpf(String cpf) {
		validarCpf(cpf);
		this.cpf = cpf;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		validarNulo(dataNascimento, DATA_NULA);
		this.dataNascimento = dataNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		validarNulo(cargo, CARGO_NAO_PODE_ESTAR_NULO);
		validarVazio(cargo, CARGO_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(cargo, CARGO_NAO_PODE_POSSUIR_ESPACOS);
		validarTamanhoString(cargo, FUNCIONARIO_NOME_TAMANHO_MINIMO, FUNCIONARIO_NOME_TAMANHO_MAXIMO, CARGO_NAO_PODE_SER_MENOR_QUE_5_E_MAIOR_QUE_60_CARACTERES);
		validarCaracteresLetrasEspacosEAcentos(cargo, CARGO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
		this.cargo = cargo;
	}
	
	public List<Contato> getContato() {
		return contatos;
	}

	public void setContato(List<Contato> contato) {
		validarNulo(contato, CONTATO_NULO);
		this.contatos = contato;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		validarNulo(departamento, DEPARTAMENTO_NAO_PODE_ESTAR_VAZIO);
		this.departamento = departamento;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		validarNulo(endereco, ENDERECO_NAO_PODE_ESTAR_NULO);
		this.endereco = endereco;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		validarNulo(empresa, EMPRESA_NAO_PODE_SER_NULA);
		this.empresa = empresa;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, empresa);
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(empresa, other.empresa);
	}
	
}
