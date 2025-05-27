package com.tarot.model;

import java.time.LocalDate;

public enum Zodiaco {

    Aries("Aries"),
    Tauro("Tauro"),
    Geminis("Géminis"),
    Cancer("Cáncer"),
    Leo("Leo"),
    Libra("Libra"),
    Escorpio("Escorpio"),
    Sagitario("Sagitario"),
    Capricornio("Capricornio"),
    Acuario("Acuario"),
    Piscis("Piscis");

    private String name;

    Zodiaco(String nombre) {
        this.name = nombre;
    }

    Zodiaco(LocalDate fechaNacimiento) {
        this.name = leerSigno(fechaNacimiento);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Metodos propios

    private static String leerSigno(LocalDate fechaNacimiento) {
        LocalDate[] startFechas = new LocalDate[]{

        };
        LocalDate[] endFechas = new LocalDate[]{

        };

        return fechaNacimiento.toString();
    }
}
