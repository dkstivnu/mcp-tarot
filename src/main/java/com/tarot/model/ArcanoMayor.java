package com.tarot.model;

import java.util.Objects;

public class ArcanoMayor extends AbstractCartaAstral {
    private final int numero;       // 0–21
    private final String nombreArc; // p.ej. "El Loco"

    public ArcanoMayor(int numero, String nombreArc) {
        if (numero < 0 || numero > 21)
            throw new IllegalArgumentException("Número de arcano mayor inválido (0–21).");
        if (nombreArc == null || nombreArc.trim().isEmpty())
            throw new IllegalArgumentException("Nombre de arcano mayor no válido.");
        this.numero = numero;
        this.nombreArc = nombreArc;
    }

    @Override
    public String generarInterpretacionGeneral() {
        return "Arcano Mayor " + numero + ": " + nombreArc;
    }

    @Override
    public String generarInterpretacionPorAreas() {
        return "Interpretación por áreas para " + nombreArc;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArcanoMayor)) return false;
        return this.numero == ((ArcanoMayor) o).numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}