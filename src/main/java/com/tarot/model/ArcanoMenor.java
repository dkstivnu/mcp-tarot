package com.tarot.model;

import java.util.Objects;

public class ArcanoMenor extends AbstractCartaAstral {
    private final String palo; // Bastos, Copas, Espadas, Oros
    private final int valor;   // 1–14

    public ArcanoMenor(String palo, int valor) {
        if (palo == null || palo.trim().isEmpty())
            throw new IllegalArgumentException("Palo de arcano menor no válido.");
        if (valor < 1 || valor > 14)
            throw new IllegalArgumentException("Valor de arcano menor inválido (1–14).");
        this.palo = palo;
        this.valor = valor;
    }

    @Override
    public String generarInterpretacionGeneral() {
        return "Arcano Menor " + palo + " " + valor;
    }

    @Override
    public String generarInterpretacionPorAreas() {
        return "Interpretación por áreas para " + palo + " " + valor;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArcanoMenor)) return false;
        ArcanoMenor a = (ArcanoMenor) o;
        return this.palo.equals(a.palo) && this.valor == a.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(palo, valor);
    }
}