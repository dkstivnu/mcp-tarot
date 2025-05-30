package com.tarot.model;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Tarot {

    //Atributos

    private LinkedList<CartaAstral> cartas;
    private LinkedList<String> significado;
    private Random random;

    //Constructores

    public Tarot() {
        this.cartas = new LinkedList<CartaAstral>();
        this.significado = new LinkedList<>();
        this.random = new Random();
    }

    //Metodos get y set

    public List<CartaAstral> getCartas() {
        return cartas;
    }

    public void setCartas(LinkedList<CartaAstral> cartas) {
        this.cartas = cartas;
    }

    public List<String> getSignificado() {
        return significado;
    }

    public void setSignificado(LinkedList<String> significado) {
        this.significado = significado;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    //Metodos propios

    public String obtenerSignificadoCarta(CartaAstral carta) {
        return "=== Significado de “" + carta.getNombre() + "” ===\n" +
                "General       : " + carta.obtenerSignificadoGeneral();
    }

}
