package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.constants.UfConstantes.CODIGO_DEVE_SER_UM_NUMERO_ENTRE_11_E_53;
import static br.com.contmatic.prova.constants.UfConstantes.NOME_NAO_PODE_CONTER_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.constants.UfConstantes.NOME_NAO_PODE_CONTER_MENOS_QUE_2_CARACTERES_E_MAIS_QUE_60_CARACTERES;
import static br.com.contmatic.prova.constants.UfConstantes.NOME_NAO_PODE_ESTAR_NULO;
import static br.com.contmatic.prova.constants.UfConstantes.NOME_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constants.UfConstantes.NOME_POSSUI_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.constants.UfConstantes.NOME_UF_MAXIMO;
import static br.com.contmatic.prova.constants.UfConstantes.NOME_UF_MINIMO;
import static br.com.contmatic.prova.constants.UfConstantes.NUMERO_MAXIMO;
import static br.com.contmatic.prova.constants.UfConstantes.NUMERO_MINIMO;
import static br.com.contmatic.prova.constants.UfConstantes.SIGLA_DEVE_POSSUIR_2_CARACTERES;
import static br.com.contmatic.prova.constants.UfConstantes.SIGLA_DEVE_POSSUIR_APENAS_CARACTERES;
import static br.com.contmatic.prova.constants.UfConstantes.SIGLA_NAO_PODE_ESTAR_NULA;
import static br.com.contmatic.prova.constants.UfConstantes.SIGLA_NAO_PODE_ESTAR_VAZIA;
import static br.com.contmatic.prova.constants.UfConstantes.SIGLA_POSSUI_ESPACOS_INVALIDOS;
import static br.com.contmatic.prova.constants.UfConstantes.SIGLA_TAMANHO_FIXO;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetras;
import static br.com.contmatic.prova.util.ValidatorUtil.validarCaracteresLetrasEspacosEAcentos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarEspacos;
import static br.com.contmatic.prova.util.ValidatorUtil.validarNulo;
import static br.com.contmatic.prova.util.ValidatorUtil.validarIntervaloMinMax;
import static br.com.contmatic.prova.util.ValidatorUtil.validarTamanhoString;
import static br.com.contmatic.prova.util.ValidatorUtil.validarVazio;

import java.util.Objects;

public class Uf {

    private Integer codigoIbge;

    private String nome;

    private String sigla;

    public Uf(Integer codigoIbge) {
        setCodigoIbge(codigoIbge);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNulo(nome, NOME_NAO_PODE_ESTAR_NULO);
        validarVazio(nome, NOME_NAO_PODE_ESTAR_VAZIO);
        validarEspacos(nome, NOME_POSSUI_ESPACOS_INVALIDOS);
        validarTamanhoString(nome, NOME_UF_MINIMO, NOME_UF_MAXIMO, NOME_NAO_PODE_CONTER_MENOS_QUE_2_CARACTERES_E_MAIS_QUE_60_CARACTERES);
        validarCaracteresLetrasEspacosEAcentos(nome, NOME_NAO_PODE_CONTER_CARACTERES_ESPECIAIS);
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigoIbge;
    }

    public void setCodigoIbge(Integer codigoIbge) {
        validarNulo(codigoIbge, NOME_NAO_PODE_ESTAR_NULO);
        validarIntervaloMinMax(codigoIbge, NUMERO_MINIMO, NUMERO_MAXIMO, CODIGO_DEVE_SER_UM_NUMERO_ENTRE_11_E_53);
        this.codigoIbge = codigoIbge;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        validarNulo(sigla, SIGLA_NAO_PODE_ESTAR_NULA);
        validarVazio(sigla, SIGLA_NAO_PODE_ESTAR_VAZIA);
        validarEspacos(sigla, SIGLA_POSSUI_ESPACOS_INVALIDOS);
        validarTamanhoString(sigla, SIGLA_TAMANHO_FIXO, SIGLA_TAMANHO_FIXO, SIGLA_DEVE_POSSUIR_2_CARACTERES);
        validarCaracteresLetras(sigla, SIGLA_DEVE_POSSUIR_APENAS_CARACTERES);
        this.sigla = sigla;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoIbge);
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
        Uf other = (Uf) obj;
        return Objects.equals(codigoIbge, other.codigoIbge);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Uf [nome=");
        builder.append(nome);
        builder.append(", codigoIbge=");
        builder.append(codigoIbge);
        builder.append(", sigla=");
        builder.append(sigla);
        builder.append("]");
        builder.append(super.toString());
        return builder.toString();
    }

}
