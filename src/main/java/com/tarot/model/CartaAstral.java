package com.tarot.model;

public interface CartaAstral {
    int getID();
    String getNombre();
    String obtenerSignificadoGeneral();

    String obtenerArea();

    String obtenerSignificadoAlDerecho();
    String obtenerSignificadoAlReves();

    String obtenerElemento();
    String obtenerPalabrasClave();
}
