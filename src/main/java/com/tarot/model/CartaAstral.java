package com.tarot.model;

import java.util.Date;
import java.util.List;

public interface CartaAstral {
    void establecerDatosPersonales(String nombre, Date fechaNacimiento, String lugarNacimiento);
    void calcularPosicionesPlanetarias();
    String obtenerSignoSolar();
    String obtenerSignoLunar();
    String obtenerAscendente();
    void calcularCasasAstrologicas();
    List<String> obtenerAspectosPlanetarios();
    String generarInterpretacionGeneral();
    String generarInterpretacionPorAreas();
    boolean validarDatos();
}

