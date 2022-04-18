package br.com.contmatic.prova.contato;

import static br.com.contmatic.prova.constants.CelularConstantes.DDI_DEVE_POSSUIR_APENAS_NUMEROS;
import static br.com.contmatic.prova.constants.CelularConstantes.DDI_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_DEVE_POSSUIR_APENAS_NUMEROS;
import static br.com.contmatic.prova.constants.CelularConstantes.DDI_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.CelularConstantes.DDI_NAO_PODE_SER_MENOR_QUE_1_E_MAIOR_QUE_999;
import static br.com.contmatic.prova.constants.CelularConstantes.DDI_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constants.CelularConstantes.DD_DEVE_CONTER_APENAS_NUMEROS;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_DEVE_POSSUIR_DE_7_A_9_CARACTERES;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_TAMAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.CelularConstantes.DD_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.CelularConstantes.DD_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.CelularConstantes.DD_NAO_PODE_SER_MENOR_QUE_1_E_MAIOR_QUE_999;
import static br.com.contmatic.prova.constants.CelularConstantes.DD_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constants.CelularConstantes.DD_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.CelularConstantes.DD_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.CelularConstantes.NUMERO_MAXIMO_DDI;
import static br.com.contmatic.prova.constants.CelularConstantes.NUMERO_MINIMO_DDI;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresNumeros;
import static br.com.contmatic.prova.util.ValidatorUtil.validarEspacos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import java.util.Objects;

public class Celular {

	private String ddi;
	
	private String dd;
	
	private String telefone;
	
	public Celular(String ddi, String dd,String  telefone) {
		setDdi(ddi);
		setDd(dd);
		setTelefone(telefone);
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		validarNulo(ddi, DDI_NAO_PODE_SER_NULO);
		validarVazio(ddi, DDI_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(ddi, DDI_NAO_PODE_CONTER_ESPACOS);
		validarTamanhoString(ddi, NUMERO_MINIMO_DDI, NUMERO_MAXIMO_DDI, DDI_NAO_PODE_SER_MENOR_QUE_1_E_MAIOR_QUE_999);
		validarCaracteresNumeros(ddi, DDI_DEVE_POSSUIR_APENAS_NUMEROS);
		this.ddi = ddi;
	}

	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		validarNulo(dd, DD_NAO_PODE_SER_NULO);
		validarVazio(dd, DD_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(dd, DD_NAO_PODE_CONTER_ESPACOS);
		validarTamanhoString(dd, DD_TAMANHO_MINIMO , DD_TAMANHO_MAXIMO, DD_NAO_PODE_SER_MENOR_QUE_1_E_MAIOR_QUE_999);
		validarCaracteresNumeros(dd, DD_DEVE_CONTER_APENAS_NUMEROS);
		this.dd = dd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		validarNulo(telefone, TELEFONE_NAO_PODE_SER_NULO);
		validarVazio(telefone, TELEFONE_NAO_PODE_ESTAR_VAZIO);
		validarEspacos(telefone, TELEFONE_NAO_PODE_CONTER_ESPACOS);
		validarTamanhoString(telefone, TELEFONE_TAMAMANHO_MINIMO , TELEFONE_TAMANHO_MAXIMO, TELEFONE_DEVE_POSSUIR_DE_7_A_9_CARACTERES);
		validarCaracteresNumeros(telefone, TELEFONE_DEVE_POSSUIR_APENAS_NUMEROS);
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dd, ddi, telefone);
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
		Celular other = (Celular) obj;
		return Objects.equals(dd, other.dd) && Objects.equals(ddi, other.ddi)
				&& Objects.equals(telefone, other.telefone);
	}
	
}
