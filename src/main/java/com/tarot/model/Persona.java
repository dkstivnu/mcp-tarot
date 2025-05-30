package com.tarot.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Persona {
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final String signoZodiacal;
    private final Tarot tarot;
    private final CartaAstral cartaAstral;

    // Constructor actualizado para recibir lugarNacimiento
    public Persona(LocalDate fechaNacimiento, String nombre, String lugarNacimiento) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (fechaNacimiento == null)
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria.");
        if (lugarNacimiento == null || lugarNacimiento.trim().isEmpty())
            throw new IllegalArgumentException("El lugar de nacimiento no puede estar vacío.");

        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.signoZodiacal = Zodiaco.determineSigno(fechaNacimiento);
        this.tarot = new Tarot();
        this.cartaAstral = new ArcanoMayor(0, "Carta Natal");

        // Convertir LocalDate a Date para la carta astral
        Date fechaUtil = Date.from(
                fechaNacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant()
        );
        // Ahora pasamos también el lugarNacimiento
        cartaAstral.establecerDatosPersonales(nombre, fechaUtil, lugarNacimiento);
    }

    public String getNombre() { return nombre; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getSignoZodiacal() { return signoZodiacal; }
    public Tarot getTarot() { return tarot; }
    public CartaAstral getCartaAstral() { return cartaAstral; }
}

    // Metodos getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Zodiaco getSignoZodiaco() {
        return signoZodiaco;
    }

    public void setSignoZodiaco(Zodiaco signoZodiaco) {
        this.signoZodiaco = signoZodiaco;
    }

    public Tarot getTarot() {
        return tarot;
    }

    public void setTarot(Tarot tarot) {
        this.tarot = tarot;
    }


}
