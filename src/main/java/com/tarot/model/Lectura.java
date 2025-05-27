package com.tarot.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lectura {
    private String tipoLectura;
    private Date fecha;
    private Persona persona;
    private List<String> cartasSeleccionadas;
    private String interpretacion;
    private List<Prediccion> predicciones;

    public Lectura(String tipoLectura, Date fecha, Persona persona) {
        this.tipoLectura = tipoLectura;
        this.fecha = fecha;
        this.persona = persona;
        this.cartasSeleccionadas = new ArrayList<>();
        this.predicciones = new ArrayList<>();
        this.interpretacion = "";
    }

    public void agregarCarta(String carta) {
        cartasSeleccionadas.add(carta);
    }

    public void agregarPrediccion(Prediccion prediccion) {
        predicciones.add(prediccion);
    }

    public void realizarLectura() {
        interpretacion = "Lectura realizada para " + persona.getNombre() + " con " + cartasSeleccionadas.size() + " carta(s).";
    }

    public String getTipoLectura() {
        return tipoLectura;
    }

    public void setTipoLectura(String tipoLectura) {
        this.tipoLectura = tipoLectura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getCartasSeleccionadas() {
        return cartasSeleccionadas;
    }

    public String getInterpretacion() {
        return interpretacion;
    }

    public List<Prediccion> getPredicciones() {
        return predicciones;
    }
}
