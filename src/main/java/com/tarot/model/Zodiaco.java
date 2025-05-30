package com.tarot.model;

import java.time.LocalDate;
import java.time.MonthDay;

public enum Zodiaco {
    ARIES,
    TAURO,
    GEMINIS,
    CANCER,
    LEO,
    VIRGO,
    LIBRA,
    ESCORPIO,
    SAGITARIO,
    CAPRICORNIO,
    ACUARIO,
    PISCIS;

    // Método para obtener signo a partir de la fecha de nacimiento
    public static Zodiaco leerSigno(LocalDate fechaNacimiento) {
        MonthDay nacimiento = MonthDay.from(fechaNacimiento);

        if (isBetween(nacimiento, MonthDay.of(3, 21), MonthDay.of(4, 19))) return ARIES;
        if (isBetween(nacimiento, MonthDay.of(4, 20), MonthDay.of(5, 20))) return TAURO;
        if (isBetween(nacimiento, MonthDay.of(5, 21), MonthDay.of(6, 20))) return GEMINIS;
        if (isBetween(nacimiento, MonthDay.of(6, 21), MonthDay.of(7, 22))) return CANCER;
        if (isBetween(nacimiento, MonthDay.of(7, 23), MonthDay.of(8, 22))) return LEO;
        if (isBetween(nacimiento, MonthDay.of(8, 23), MonthDay.of(9, 22))) return VIRGO;
        if (isBetween(nacimiento, MonthDay.of(9, 23), MonthDay.of(10, 22))) return LIBRA;
        if (isBetween(nacimiento, MonthDay.of(10, 23), MonthDay.of(11, 21))) return ESCORPIO;
        if (isBetween(nacimiento, MonthDay.of(11, 22), MonthDay.of(12, 21))) return SAGITARIO;
        if (isBetween(nacimiento, MonthDay.of(12, 22), MonthDay.of(12, 31)) || isBetween(nacimiento, MonthDay.of(1, 1), MonthDay.of(1, 19))) return CAPRICORNIO;
        if (isBetween(nacimiento, MonthDay.of(1, 20), MonthDay.of(2, 18))) return ACUARIO;
        if (isBetween(nacimiento, MonthDay.of(2, 19), MonthDay.of(3, 20))) return PISCIS;

        throw new RuntimeException("No se ha podido leer el signo correctamente");
    }

    // Método para obtener signo a partir de su nombre
    public static Zodiaco leerSigno(String nombreSigno) {
        if (nombreSigno == null || nombreSigno.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del signo no puede estar vacío.");
        }
        String buscado = nombreSigno.trim().toUpperCase();
        for (Zodiaco z : values()) {
            if (z.name().equalsIgnoreCase(buscado)) {
                return z;
            }
        }
        throw new IllegalArgumentException("Signo zodiacal desconocido: " + nombreSigno);
    }

    // Helper para comprobar si una fecha está entre dos MonthDay, incluyendo los extremos
    private static boolean isBetween(MonthDay date, MonthDay start, MonthDay end) {
        if (start.isBefore(end) || start.equals(end)) {
            return (date.equals(start) || date.equals(end) || (date.isAfter(start) && date.isBefore(end)));
        } else { // Rango que cruza el año (ejemplo Capricornio)
            return (date.equals(start) || date.equals(end) || date.isAfter(start) || date.isBefore(end));
        }
    }
}