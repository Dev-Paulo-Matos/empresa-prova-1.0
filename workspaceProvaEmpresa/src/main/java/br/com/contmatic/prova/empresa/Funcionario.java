package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constants.ContatoConstantes.CONTATO_NULO;
import static br.com.contmatic.prova.constants.DepartamentoConstantes.DEPARTAMENTO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.EnderecoConstantes.ENDERECO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.CARGO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.CARGO_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.CARGO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.CARGO_NAO_PODE_SER_MENOR_QUE_5_E_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.DATA_NULA;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.FUNCIONARIO_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.FUNCIONARIO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.NOME_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.NOME_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.NOME_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.NOME_NAO_PODE_SER_MENOR_QUE_5_E_NEM_MAIOR_QUE_60_CARACTERES;
import static br.com.contmatic.prova.util.CpfUtil.validarCpf;
import static br.com.contmatic.prova.util.DataUtil.validarDataNascimento;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import java.util.Objects;

import org.joda.time.DateTime;

import br.com.contmatic.prova.auditoria.Auditoria;
import br.com.contmatic.prova.contato.Contato;
import br.com.contmatic.prova.endereco.Endereco;


public class Funcionario extends Auditoria {

	private String cpf;

	private String nomeCompleto;
	
	private DateTime dataNascimento;

	private String cargo;

	private Contato contato;
	
	private Departamento departamento;
	
	private Endereco endereco;
	
	public Funcionario(String cpf) {
		setCpf(cpf);
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		validarNulo(nomeCompleto, NOME_NAO_PODE_ESTAR_NULO);
		validarVazio(nomeCompleto, NOME_NAO_PODE_ESTAR_VAZIO);
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
	
	public DateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(DateTime dataNascimento) {
		validarNulo(dataNascimento, DATA_NULA);
		validarDataNascimento(dataNascimento);
		this.dataNascimento = dataNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		validarNulo(cargo, CARGO_NAO_PODE_ESTAR_NULO);
		validarVazio(cargo, CARGO_NAO_PODE_ESTAR_VAZIO);
		validarTamanhoString(cargo, FUNCIONARIO_NOME_TAMANHO_MINIMO, FUNCIONARIO_NOME_TAMANHO_MAXIMO, CARGO_NAO_PODE_SER_MENOR_QUE_5_E_MAIOR_QUE_60_CARACTERES);
		validarCaracteresLetrasEspacosEAcentos(cargo, CARGO_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
		this.cargo = cargo;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		validarNulo(contato, CONTATO_NULO);
		this.contato = contato;
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

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return  Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nomeCompleto=");
		builder.append(nomeCompleto);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", cargo=");
		builder.append(cargo);
		builder.append(", contato=");
		builder.append(contato);
		builder.append(", departamento=");
		builder.append(departamento);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append("]");
		return builder.toString();
	}
	
}
