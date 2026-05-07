package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils {

    public static String formatar(LocalDateTime dt, String padrao){
        return dt.format(DateTimeFormatter.ofPattern(padrao));
    }

    public static String formatarDataHoraPadrao(LocalDateTime dt){
        return formatar(dt, "dd/MM/YY HH:mm");
    }

    public static long calcularMinutosEntreData(LocalDateTime inicio, LocalDateTime fim){
        return ChronoUnit.MINUTES.between(inicio, fim);
    }

    public static LocalDateTime adicionarTempoEmMinutos(LocalDateTime dataOriginal, int minutos){
        return dataOriginal.plusMinutes(minutos);
    }
}
