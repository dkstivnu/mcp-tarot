package com.tarot.model;

import java.util.List;

public class ArcanoMenor implements CartaAstral {
    @Override
    public void establecerDatosPersonales() {

    }

    @Override
    public void calcularPosicionesPlanetarias() {

    }

    @Override
    public String obtenerSignoSolar() {
        return "";
    }

    @Override
    public String obtenerSignoLunar() {
        return "";
    }

    @Override
    public String obtenerAscendente() {
        return "";
    }

    @Override
    public void calcularCasasAstrologicas() {

    }

    @Override
    public List<String> obtenerAspectosPlanetarios() {
        return List.of();
    }

    @Override
    public String generarInterpretacionGeneral() {
        return "";
    }

    @Override
    public String generarInterpretacioporAreas() {
        return "";
    }

    @Override
    public boolean validarDatos() {
        return false;
    }
}
