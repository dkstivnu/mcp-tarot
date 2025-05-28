package com.tarot.model;

import java.time.LocalDate;
import java.time.MonthDay;

public enum Zodiaco {

    Aries(Zodiaco.valueOf("Aries")),
    Tauro(Zodiaco.valueOf("Tauro")),
    Geminis(Zodiaco.valueOf("Géminis")),
    Cancer(Zodiaco.valueOf("Cáncer")),
    Leo(Zodiaco.valueOf("Leo")),
    Libra(Zodiaco.valueOf("Libra")),
    Escorpio(Zodiaco.valueOf("Escorpio")),
    Sagitario(Zodiaco.valueOf("Sagitario")),
    Capricornio(Zodiaco.valueOf("Capricornio")),
    Acuario(Zodiaco.valueOf("Acuario")),
    Piscis(Zodiaco.valueOf("Piscis"));

    private final Zodiaco name;

    Zodiaco(Zodiaco nombre) {
        this.name = nombre;
    }

    Zodiaco(LocalDate fechaNacimiento) {
        this.name = leerSigno(fechaNacimiento);
    }

    public Zodiaco getName() {
        return name;
    }

    // Metodos propios

    public static Zodiaco leerSigno(LocalDate fechaNacimiento) throws RuntimeException {
        MonthDay nacimientoMD = MonthDay.from(fechaNacimiento);

        MonthDay[] startFechas = new MonthDay[]{
                MonthDay.from(LocalDate.of(0, 3, 21)), // Aries
                MonthDay.from(LocalDate.of(0, 4, 20)), // Tauro
                MonthDay.from(LocalDate.of(0, 5, 21)), // Geminis
                MonthDay.from(LocalDate.of(0, 6, 21)), // Cancer
                MonthDay.from(LocalDate.of(0, 7, 23)), // Leo
                MonthDay.from(LocalDate.of(0, 8, 23)), // Virgo
                MonthDay.from(LocalDate.of(0, 9, 23)), // Libra
                MonthDay.from(LocalDate.of(0, 10, 23)),// Escorpio
                MonthDay.from(LocalDate.of(0, 11, 22)),// Sagitario
                MonthDay.from(LocalDate.of(0, 12, 22)),// Capricornio
                MonthDay.from(LocalDate.of(0, 1, 1)),  // Capricornio
                MonthDay.from(LocalDate.of(0, 1, 20)), // Acuario
                MonthDay.from(LocalDate.of(0, 2, 19)), // Piscis
        };
        MonthDay[] endFechas = new MonthDay[]{
                MonthDay.from(LocalDate.of(0, 4, 19)), // Aries
                MonthDay.from(LocalDate.of(0, 5, 20)), // Tauro
                MonthDay.from(LocalDate.of(0, 6, 20)), // Geminis
                MonthDay.from(LocalDate.of(0, 7, 22)), // Cancer
                MonthDay.from(LocalDate.of(0, 8, 22)), // Leo
                MonthDay.from(LocalDate.of(0, 9, 22)), // Virgo
                MonthDay.from(LocalDate.of(0, 10, 22)),// Libra
                MonthDay.from(LocalDate.of(0, 11, 21)),// Escorpio
                MonthDay.from(LocalDate.of(0, 12, 21)),// Sagitario
                MonthDay.from(LocalDate.of(0, 12, 31)),// Capricornio
                MonthDay.from(LocalDate.of(0, 1, 19)), // Capricornio
                MonthDay.from(LocalDate.of(0, 2, 18)), // Acuario
                MonthDay.from(LocalDate.of(0, 3, 20)), // Piscis
        };

        Zodiaco[] signos = new Zodiaco[]{
                Aries,
                Tauro,
                Geminis,
                Cancer,
                Leo,
                Libra,
                Escorpio,
                Sagitario,
                Capricornio,
                Capricornio,
                Acuario,
                Piscis
        };

        int i;
        for (i = 0; i <= 13; i++) {
            if (nacimientoMD.equals(startFechas[i]) || nacimientoMD.equals(endFechas[i])) {
                return signos[i];
            }
            if (nacimientoMD.isAfter(startFechas[i]) || nacimientoMD.isBefore(endFechas[i])) {
                return signos[i];
            }
        }

        throw new RuntimeException("No se ha podido leer el signo correctamente");
    }
}
