package com.tarot.model;

import java.util.List;

public interface CartaAstral {

    void establecerDatosPersonales();
    void calcularPosicionesPlanetarias();

    String obtenerSignoSolar();
    String obtenerSignoLunar();
    String obtenerAscendente();

    void calcularCasasAstrologicas();
    List<String> obtenerAspectosPlanetarios();

    String generarInterpretacionGeneral();
    String generarInterpretacioporAreas();
    
    boolean validarDatos();




}
