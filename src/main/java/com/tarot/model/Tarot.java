package com.tarot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tarot {
    private final List<String> carta;
    private final List<String> significado;
    private final Random random = new Random();

    public Tarot() {
        carta = new ArrayList<>();
        significado = new ArrayList<>();
        inicializarCartas();
        inicializarSignificados();
    }

    private void inicializarCartas() {
        String[] mayores = {
                "El Loco","El Mago","La Papisa","La Emperatriz","El Emperador","El Papa",
                "Los Enamorados","El Carro","La Justicia","El Ermitaño","La Rueda de la Fortuna",
                "La Fuerza","El Colgado","La Muerte","La Templanza","El Diablo","La Torre",
                "La Estrella","La Luna","El Sol","El Juicio","El Mundo"
        };
        for (String n : mayores) carta.add(n);

        String[] palos = {"Copas","Espadas","Bastos","Oros"};
        for (String palo : palos) {
            for (int v = 1; v <= 14; v++) {
                carta.add(v + " de " + palo);
            }
        }
    }

    private void inicializarSignificados() {
        // Ejemplo mínimo: deberías llenar 78 significados correspondientes
        for (int i = 0; i < carta.size(); i++) {
            significado.add("Significado genérico de " + carta.get(i));
        }
    }

    public String seleccionarCartaAleatoria() {
        return carta.get(random.nextInt(carta.size()));
    }

    public List<String> tirarCartas(int n) {
        List<String> salida = new ArrayList<>();
        while (salida.size() < n) {
            String c = seleccionarCartaAleatoria();
            if (!salida.contains(c)) salida.add(c);
        }
        return salida;
    }

    public String obtenerSignificadoCarta(String nombreCarta) {
        int idx = carta.indexOf(nombreCarta);
        return idx >= 0 ? significado.get(idx) : "Sin significado";
    }
}