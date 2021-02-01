package br.com.mstech.escola.dominio;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDeEventos {
    
    private List<Ouvinte> ouvintes = new ArrayList<>();

    public void adicionar(Ouvinte ouvinte) {
        ouvintes.add(ouvinte);
    }

    public void publicar(Evento evento) {
        ouvintes.forEach(o -> o.processar(evento));
    }

    
}
