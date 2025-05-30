
package com.tarot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractCartaAstral implements CartaAstral {
    protected String nombrePersona;
    protected Date fechaNacimiento;
    protected String lugarNacimiento;

    @Override
    public void establecerDatosPersonales(String nombre, Date fecha, String lugar) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (fecha == null)
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria.");
        if (lugar == null || lugar.trim().isEmpty())
            throw new IllegalArgumentException("El lugar de nacimiento no puede estar vacío.");
        this.nombrePersona = nombre;
        this.fechaNacimiento = new Date(fecha.getTime());
        this.lugarNacimiento = lugar;
    }

    @Override public void calcularPosicionesPlanetarias() { /* stub */ }
    @Override public String obtenerSignoSolar() { return ""; }
    @Override public String obtenerSignoLunar() { return ""; }
    @Override public String obtenerAscendente() { return ""; }
    @Override public void calcularCasasAstrologicas() { /* stub */ }
    @Override public List<String> obtenerAspectosPlanetarios() { return new ArrayList<>(); }
    @Override public String generarInterpretacionGeneral() { return ""; }
    @Override public String generarInterpretacionPorAreas() { return ""; }
    @Override public boolean validarDatos() {
        return nombrePersona != null && fechaNacimiento != null && lugarNacimiento != null;
    }
}