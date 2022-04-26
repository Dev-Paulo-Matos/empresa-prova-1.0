package br.com.contmatic.prova.contato;

import static br.com.contmatic.prova.constants.CelularConstantes.CELULAR_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constants.ContatoConstantes.EMAIL_INVALIDO;
import static br.com.contmatic.prova.constants.ContatoConstantes.EMAIL_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.ContatoConstantes.EMAIL_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.ContatoConstantes.EMAIL_NAO_PODE_SER_MENOR_QUE_8_E_MAIOR_QUE_60;
import static br.com.contmatic.prova.constants.ContatoConstantes.EMAIL_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constants.ContatoConstantes.EMAIL_TAMANHO_MAX;
import static br.com.contmatic.prova.constants.ContatoConstantes.EMAIL_TAMANHO_MIN;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresEmail;
import static br.com.contmatic.prova.util.ValidatorUtil.validarEspacos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import java.util.Objects;

public class Contato {

	private Celular celular;
	
	private String email;

	public Contato(Celular celular) {
		setCelular(celular);
	}
	
	public Celular getCelular() {
		return celular;
	}

	public void setCelular(Celular celular) {
		validarNulo(celular, CELULAR_NAO_PODE_SER_NULO);
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		validarNulo(email, EMAIL_NAO_PODE_SER_NULO);
		validarVazio(email, EMAIL_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(email, EMAIL_NAO_PODE_CONTER_ESPACOS);
		validarTamanhoString(email, EMAIL_TAMANHO_MIN, EMAIL_TAMANHO_MAX, EMAIL_NAO_PODE_SER_MENOR_QUE_8_E_MAIOR_QUE_60);
		validarCaracteresEmail(email, EMAIL_INVALIDO);
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(celular);
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
		Contato other = (Contato) obj;
		return Objects.equals(celular, other.celular);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contato [");
		builder.append(celular);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}

	
}
