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

    public void crearMazo() {
        ArcanoMenor.Palo[] palos = ArcanoMenor.Palo.values();
        String[] elementos = new String[]{"Fuego", "Tierra", "Agua", "Aire"};
        String[] areas = new String[]{"General", "Amor", "Riqueza", "Sentimientos"};

        for (int i = 0; i <= 3; i++) {
            switch (random.nextInt(0, 1)) {
                case 0: { //Se crea un arcano menor
                    cartas.add(new ArcanoMenor(random.nextInt(1, 13), palos[random.nextInt(0, palos.length)]));
                }
                break;
                case 1: { //Se crea un arcano mayor
                    cartas.add(new ArcanoMayor(random.nextInt(0,21),
                            elementos[random.nextInt(0, elementos.length)],
                            areas[random.nextInt(0, areas.length)]));
                }
                break;
                default:
            }
        }
    }

}
