package com.cloudtech.pi.domain;

import javax.persistence.*;

@Entity
@Table(name = "CLIMA")
public class Previsao extends AbstractEntity<Long>{

    @Column(name = "cidade", nullable = false, unique = true, length = 60)
    private String cidade;
    @Column(name = "texto", nullable = false, unique = false, length = 200)
    private String texto;
    @Column(name = "seriedade", nullable = false, unique = false, length = 10)
    private long seriedade;
    @Column(name = "maxima", nullable = false, unique = false, length = 10)
    private int maxima;
    @Column(name = "minima", nullable = false, unique = false, length = 10)
    private int minima;

    public String getNome() {
        return cidade;
    }

    public void setNome(String nome) {
        this.cidade = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public long getSeriedade() {
        return seriedade;
    }

    public void setSeriedade(long seriedade) {
        this.seriedade = seriedade;
    }

    public int getMaxima() {
        return maxima;
    }

    public void setMaxima(int maxima) {
        this.maxima = maxima;
    }

    public int getMinima() {
        return minima;
    }

    public void setMinima(int minima) {
        this.minima = minima;
    }
}
