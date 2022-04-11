package br.com.contmatic.prova.contato;

import static br.com.contmatic.prova.util.ContatoValidatorUtil.validarEmail;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;

import java.util.Objects;

public class Contato {
	
	private Celular celular;
	
	private String email;

	public Contato(Celular celular, String email) {
		setCelular(celular);
		setEmail(email);
	}
	
	public Celular getCelular() {
		return celular;
	}

	public void setCelular(Celular celular) {
		validarNulo(celular, "Celular não pode ser nulo");
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		validarEmail(email);
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
		builder.append("Contato [celular=");
		builder.append(celular);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}

	
}
