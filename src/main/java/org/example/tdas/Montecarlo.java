package org.example.tdas;

import java.util.ArrayList;
import java.util.List;

public class Montecarlo {
    private List<Coordenada> coordenadas = new ArrayList();
    private Region region;

    public Montecarlo(Region region) {
        this.region = region;
    }

    public int getCantidadDePuntos() {
        return this.coordenadas.size();
    }

    public void addCoordenada(Coordenada coord) {
        if (this.region.estaDentro(coord)) {
            this.coordenadas.add(coord);
        }

    }

    public List<Coordenada> getCoordenadas() {
        return this.coordenadas;
    }
}

