package com.tarot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tarot {
    //Atributos
    private List<String> carta;
    private List<String> significado;
    private Random random;

    //Constructores
    public Tarot() {
        this.carta = new ArrayList<>();
        this.significado = new ArrayList<>();
        this.random = new Random();
    }
    //get y set


    public List<String> getCarta() {
        return carta;
    }

    public void setCarta(List<String> carta) {
        this.carta = carta;
    }

    public List<String> getSignificado() {
        return significado;
    }

    public void setSignificado(List<String> significado) {
        this.significado = significado;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    //Metodos propios
    public String seleccionarCartaAleatoria() {
        return carta.get(random.nextInt(carta.size()));
    }
    public void inicializarCartas() {

        // Arcanos Mayores
        carta.add("El Loco");
        carta.add("El Mago");
        carta.add("La Papisa");
        carta.add("La Emperatriz");
        carta.add("El Emperador");
        carta.add("El Papa");
        carta.add("Los Enamorados");
        carta.add("El Carro");
        carta.add("La Justicia");
        carta.add("El Ermitaño");
        carta.add("La Rueda de la Fortuna");
        carta.add("La Fuerza");
        carta.add("El Colgado");
        carta.add("La Muerte");
        carta.add("La Templanza");
        carta.add("El Diablo");
        carta.add("La Torre");
        carta.add("La Estrella");
        carta.add("La Luna");
        carta.add("El Sol");
        carta.add("El Juicio");
        carta.add("El Mundo");

        // Arcanos Menores - Copas
        carta.add("As de Copas");
        carta.add("Dos de Copas");
        carta.add("Tres de Copas");
        carta.add("Cuatro de Copas");
        carta.add("Cinco de Copas");
        carta.add("Seis de Copas");
        carta.add("Siete de Copas");
        carta.add("Ocho de Copas");
        carta.add("Nueve de Copas");
        carta.add("Diez de Copas");
        carta.add("Sota de Copas");
        carta.add("Caballo de Copas");
        carta.add("Reina de Copas");
        carta.add("Rey de Copas");

        // Arcanos Menores - Espadas
        carta.add("As de Espadas");
        carta.add("Dos de Espadas");
        carta.add("Tres de Espadas");
        carta.add("Cuatro de Espadas");
        carta.add("Cinco de Espadas");
        carta.add("Seis de Espadas");
        carta.add("Siete de Espadas");
        carta.add("Ocho de Espadas");
        carta.add("Nueve de Espadas");
        carta.add("Diez de Espadas");
        carta.add("Sota de Espadas");
        carta.add("Caballo de Espadas");
        carta.add("Reina de Espadas");
        carta.add("Rey de Espadas");

        // Arcanos Menores - Bastos
        carta.add("As de Bastos");
        carta.add("Dos de Bastos");
        carta.add("Tres de Bastos");
        carta.add("Cuatro de Bastos");
        carta.add("Cinco de Bastos");
        carta.add("Seis de Bastos");
        carta.add("Siete de Bastos");
        carta.add("Ocho de Bastos");
        carta.add("Nueve de Bastos");
        carta.add("Diez de Bastos");
        carta.add("Sota de Bastos");
        carta.add("Caballo de Bastos");
        carta.add("Reina de Bastos");
        carta.add("Rey de Bastos");

        // Arcanos Menores - Oros
        carta.add("As de Oros");
        carta.add("Dos de Oros");
        carta.add("Tres de Oros");
        carta.add("Cuatro de Oros");
        carta.add("Cinco de Oros");
        carta.add("Seis de Oros");
        carta.add("Siete de Oros");
        carta.add("Ocho de Oros");
        carta.add("Nueve de Oros");
        carta.add("Diez de Oros");
        carta.add("Sota de Oros");
        carta.add("Caballo de Oros");
        carta.add("Reina de Oros");
        carta.add("Rey de Oros");

    }





}
