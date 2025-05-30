package com.tarot.model;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Tarot {

    //Atributos

    private LinkedList<String> cartas;
    private LinkedList<String> significado;
    private Random random;

    //Constructores

    public Tarot() {
        this.cartas = new LinkedList<>();
        this.significado = new LinkedList<>();
        this.random = new Random();
    }

    //Metodos get y set

    public List<String> getCartas() {
        return cartas;
    }

    public void setCartas(LinkedList<String> cartas) {
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
    public String seleccionarCartaAleatoria() {
        return cartas.get(random.nextInt(cartas.size()));
    }
    public void inicializarCartas() {

        // Arcanos Mayores

        cartas.add("El Loco");
        cartas.add("El Mago");
        cartas.add("La Papisa");
        cartas.add("La Emperatriz");
        cartas.add("El Emperador");
        cartas.add("El Papa");
        cartas.add("Los Enamorados");
        cartas.add("El Carro");
        cartas.add("La Justicia");
        cartas.add("El Ermitaño");
        cartas.add("La Rueda de la Fortuna");
        cartas.add("La Fuerza");
        cartas.add("El Colgado");
        cartas.add("La Muerte");
        cartas.add("La Templanza");
        cartas.add("El Diablo");
        cartas.add("La Torre");
        cartas.add("La Estrella");
        cartas.add("La Luna");
        cartas.add("El Sol");
        cartas.add("El Juicio");
        cartas.add("El Mundo");

        // Arcanos Menores - Copas
        cartas.add("As de Copas");
        cartas.add("Dos de Copas");
        cartas.add("Tres de Copas");
        cartas.add("Cuatro de Copas");
        cartas.add("Cinco de Copas");
        cartas.add("Seis de Copas");
        cartas.add("Siete de Copas");
        cartas.add("Ocho de Copas");
        cartas.add("Nueve de Copas");
        cartas.add("Diez de Copas");
        cartas.add("Sota de Copas");
        cartas.add("Caballo de Copas");
        cartas.add("Reina de Copas");
        cartas.add("Rey de Copas");

        // Arcanos Menores - Espadas
        cartas.add("As de Espadas");
        cartas.add("Dos de Espadas");
        cartas.add("Tres de Espadas");
        cartas.add("Cuatro de Espadas");
        cartas.add("Cinco de Espadas");
        cartas.add("Seis de Espadas");
        cartas.add("Siete de Espadas");
        cartas.add("Ocho de Espadas");
        cartas.add("Nueve de Espadas");
        cartas.add("Diez de Espadas");
        cartas.add("Sota de Espadas");
        cartas.add("Caballo de Espadas");
        cartas.add("Reina de Espadas");
        cartas.add("Rey de Espadas");

        // Arcanos Menores - Bastos
        cartas.add("As de Bastos");
        cartas.add("Dos de Bastos");
        cartas.add("Tres de Bastos");
        cartas.add("Cuatro de Bastos");
        cartas.add("Cinco de Bastos");
        cartas.add("Seis de Bastos");
        cartas.add("Siete de Bastos");
        cartas.add("Ocho de Bastos");
        cartas.add("Nueve de Bastos");
        cartas.add("Diez de Bastos");
        cartas.add("Sota de Bastos");
        cartas.add("Caballo de Bastos");
        cartas.add("Reina de Bastos");
        cartas.add("Rey de Bastos");

        // Arcanos Menores - Oros
        cartas.add("As de Oros");
        cartas.add("Dos de Oros");
        cartas.add("Tres de Oros");
        cartas.add("Cuatro de Oros");
        cartas.add("Cinco de Oros");
        cartas.add("Seis de Oros");
        cartas.add("Siete de Oros");
        cartas.add("Ocho de Oros");
        cartas.add("Nueve de Oros");
        cartas.add("Diez de Oros");
        cartas.add("Sota de Oros");
        cartas.add("Caballo de Oros");
        cartas.add("Reina de Oros");
        cartas.add("Rey de Oros");

    }

}
