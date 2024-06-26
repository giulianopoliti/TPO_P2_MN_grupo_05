package org.example.tdas;

public class Region {
    private double lado;

    public Region(double lado) {
        this.lado = lado;
    }

    public boolean estaDentro(Coordenada coord) {
        return coord.getX() >= 0.0 && coord.getX() <= this.lado && coord.getY() >= 0.0 && coord.getY() <= this.lado;
    }
}