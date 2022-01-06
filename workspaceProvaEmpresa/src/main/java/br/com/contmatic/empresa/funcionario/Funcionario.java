package br.com.contmatic.empresa.funcionario;

import static br.com.contmatic.empresa.constants.Constants.FUNCIONARIO_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.empresa.constants.Constants.FUNCIONARIO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.empresa.constants.Mensagens.CONTATO_NULO;
import static br.com.contmatic.empresa.constants.Mensagens.DATA_NULA;
import static br.com.contmatic.empresa.util.CpfUtil.validarCpf;
import static br.com.contmatic.empresa.util.DataUtil.validarDataNascimento;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarCaracteresLetrasEspacosEAcentos;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.empresa.util.ValidatorUtil.validarTamanhoString;

import java.util.Objects;

import org.joda.time.DateTime;

import br.com.contmatic.empresa.contato.Contato;
import br.com.contmatic.empresa.empresa.Departamento;
import br.com.contmatic.empresa.endereco.Endereco;


public class Funcionario {

	private String nomeCompleto;

	private String cpf;
	
	private DateTime dataNascimento;

	private String cargo;

	private Contato contato;
	
	private Departamento departamento;
	
	private Endereco endereco;
	
	public Funcionario(String cpf) {
		setCpf(cpf);
	}
	
	public Funcionario(String nome, String cpf, DateTime dataNascimento, String cargo) {
		setNomeCompleto(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setCargo(cargo);
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		validarNulo(nomeCompleto);
		validarTamanhoString(nomeCompleto, FUNCIONARIO_NOME_TAMANHO_MINIMO, FUNCIONARIO_NOME_TAMANHO_MAXIMO);
		validarCaracteresLetrasEspacosEAcentos(nomeCompleto);
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
		validarNulo(dataNascimento,DATA_NULA);
		validarDataNascimento(dataNascimento);
		this.dataNascimento = dataNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargoFuncionario) {
		validarNulo(cargoFuncionario);
		validarTamanhoString(cargoFuncionario, FUNCIONARIO_NOME_TAMANHO_MINIMO, FUNCIONARIO_NOME_TAMANHO_MAXIMO);
		validarCaracteresLetrasEspacosEAcentos(cargoFuncionario);
		this.cargo = cargoFuncionario;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		validarNulo(contato,CONTATO_NULO);
		this.contato = contato;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		validarNulo(departamento);
		this.departamento = departamento;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		validarNulo(endereco);
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
		return "Funcionario [nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", cargo=" + cargo + ", contato=" + contato + ", departamento=" + departamento + ", endereco="
				+ endereco + "]";
	}

	
	
}
