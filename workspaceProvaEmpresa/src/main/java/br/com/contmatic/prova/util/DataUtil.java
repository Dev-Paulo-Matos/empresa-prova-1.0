package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constants.FuncionarioConstantes.IDADE_MINIMA;
import static org.joda.time.LocalDate.now;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

public final class DataUtil {

    private DataUtil() {
    }

    public static void validarDataPassado(LocalDate data, String mensagem) {
        if (data.isBefore(now().plusYears(-90))) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarDataFuturo(LocalDate data, String mensagem) {
        if (now().isBefore(data)) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarDataMenorDezoito(LocalDate data, String mensagem) {
        if ((now().getYear() - IDADE_MINIMA) < data.getYear()) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarDataFuturoAuditoria(LocalDateTime data, String mensagem) {
        if (LocalDateTime.now().isBefore(data)) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarDataPassadoAuditoria(LocalDateTime data, String mensagem) {
        if (data.plusMinutes(1).isBefore(LocalDateTime.now())) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarDataAlteracaoAnteriorADataCriacao(LocalDateTime dataCriacao, LocalDateTime dateAlteracao, String mensagem) {
        if (dateAlteracao.isBefore(dataCriacao)) {
            throw new IllegalStateException(mensagem);
        }
    }
}
