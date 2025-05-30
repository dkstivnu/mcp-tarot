package com.tarot.model;

import java.time.LocalDate;

public class Persona {

    // Atributos

    private String nombre;
    private LocalDate fechaNacimiento;
    private Zodiaco signoZodiaco;
    private Tarot tarot;

    // Constructores

    public Persona(LocalDate fechaNacimiento, String nombre) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.signoZodiaco = Zodiaco.leerSigno(fechaNacimiento);
        this.tarot = new Tarot();
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
