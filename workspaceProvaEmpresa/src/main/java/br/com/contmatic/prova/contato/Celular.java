package br.com.contmatic.prova.contato;

import static br.com.contmatic.prova.constants.CelularConstantes.DDI_DEVE_POSSUIR_APENAS_NUMEROS;
import static br.com.contmatic.prova.constants.CelularConstantes.DDI_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_DEVE_POSSUIR_APENAS_NUMEROS;
import static br.com.contmatic.prova.constants.CelularConstantes.DDI_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.CelularConstantes.DDI_NAO_PODE_SER_MENOR_QUE_1_E_MAIOR_QUE_999;
import static br.com.contmatic.prova.constants.CelularConstantes.DDI_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constants.CelularConstantes.DDD_DEVE_CONTER_APENAS_NUMEROS;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_DEVE_POSSUIR_DE_7_A_9_CARACTERES;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_TAMAMANHO_MINIMO;
import static br.com.contmatic.prova.constants.CelularConstantes.TELEFONE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.CelularConstantes.DDD_NAO_PODE_CONTER_ESPACOS;
import static br.com.contmatic.prova.constants.CelularConstantes.DDD_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.CelularConstantes.DDD_NAO_PODE_SER_MENOR_QUE_1_E_MAIOR_QUE_999;
import static br.com.contmatic.prova.constants.CelularConstantes.DDD_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constants.CelularConstantes.DDD_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constants.CelularConstantes.DDD_TAMANHO_MINIMO;
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
    
    private String ddd;

    private String telefone;

    public Celular(String ddi, String ddd, String telefone) {
        setDdi(ddi);
        setDdd(ddd);
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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        validarNulo(ddd, DDD_NAO_PODE_SER_NULO);
        validarVazio(ddd, DDD_NAO_PODE_ESTAR_VAZIO);
        validarEspacos(ddd, DDD_NAO_PODE_CONTER_ESPACOS);
        validarTamanhoString(ddd, DDD_TAMANHO_MINIMO, DDD_TAMANHO_MAXIMO, DDD_NAO_PODE_SER_MENOR_QUE_1_E_MAIOR_QUE_999);
        validarCaracteresNumeros(ddd, DDD_DEVE_CONTER_APENAS_NUMEROS);
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        validarNulo(telefone, TELEFONE_NAO_PODE_SER_NULO);
        validarVazio(telefone, TELEFONE_NAO_PODE_ESTAR_VAZIO);
        validarEspacos(telefone, TELEFONE_NAO_PODE_CONTER_ESPACOS);
        validarTamanhoString(telefone, TELEFONE_TAMAMANHO_MINIMO, TELEFONE_TAMANHO_MAXIMO, TELEFONE_DEVE_POSSUIR_DE_7_A_9_CARACTERES);
        validarCaracteresNumeros(telefone, TELEFONE_DEVE_POSSUIR_APENAS_NUMEROS);
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, ddi, telefone);
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
        return Objects.equals(ddd, other.ddd) && Objects.equals(ddi, other.ddi) && Objects.equals(telefone, other.telefone);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Celular = [ddi=");
        builder.append(ddi);
        builder.append(", dd=");
        builder.append(ddd);
        builder.append(", telefone=");
        builder.append(telefone);
        builder.append("]");
        builder.append(super.toString());
        return builder.toString();
    }

}
