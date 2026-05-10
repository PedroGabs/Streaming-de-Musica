package br.com.streaming.modelo;

import br.com.streaming.servico.Reproduzivel;

public abstract class ItemReproducao implements Reproduzivel {

    protected String titulo;

    protected int duracaoSegundos;

    public ItemReproducao(String titulo, int duracaoSegundos) {

        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public void pausar() {

        System.out.println("⏸ Reprodução pausada");
    }

    @Override
    public void parar() {

        System.out.println("⏹ Reprodução parada");
    }

    @Override
    public int getDuracaoTotal() {

        return duracaoSegundos;
    }
}