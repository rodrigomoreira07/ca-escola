package br.com.mstech.escola.dominio;

public abstract class Ouvinte {
    
    public void processar(Evento evento) {
        if (this.deveProcessar(evento)) {
            this.reagirAo(evento);
        }
    }

    protected abstract boolean deveProcessar(Evento evento);
    protected abstract void reagirAo(Evento evento);
}
