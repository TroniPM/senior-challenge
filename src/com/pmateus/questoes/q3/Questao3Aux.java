/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.questoes.q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Paulo Mateus
 */
public class Questao3Aux {

    public Date date = null;
    public int min = 0;
    public int max = 0;
    public double media = 0;
    public double mediana = 0;
    public double desvioPadrao = 0;
    public double variancia = 0;
    ArrayList<Integer> valores = new ArrayList<>();

    public Questao3Aux(Date date) {
        this.date = date;
    }

    public void add(int value) {
        valores.add(value);
    }

    public void doScheme() {
        Collections.sort(valores);
        calcMinimo();
        calcMaximo();
        calcMedia();
        calcMediana();
        calcDesvioPadrao();
        calcVariancia();
    }

    public void calcMinimo() {
        this.min = valores.get(0);
    }

    public void calcMaximo() {
        this.max = valores.get(valores.size() - 1);
    }

    public void calcMedia() {
        int value = 0;
        for (Integer valor : valores) {
            value += valor;
        }

        this.media = value * 1.0 / valores.size() * 1.0;
    }

    public void calcMediana() {
        int index = valores.size() / 2;
        if (valores.size() % 2 == 0) {
            this.mediana = (valores.get(index) + valores.get(index - 1)) * 1.0 / 2.0;
        } else {
            this.mediana = valores.get(index);
        }
    }

    public void calcDesvioPadrao() {
        for (double valor : valores) {
            this.desvioPadrao += Math.pow(valor - this.media, 2);
        }

        this.desvioPadrao = Math.sqrt(this.desvioPadrao / valores.size());
    }

    public void calcVariancia() {
        double sumDiffQuadrada = 0.0;

        for (int valor : valores) {
            double diff = valor - this.media;
            diff *= diff;
            sumDiffQuadrada += diff;
        }
        this.variancia = sumDiffQuadrada / (valores.size() - 1);
    }

    @Override
    public String toString() {
        return normalizeDate(date.getMonth() + 1) + "/" + normalizeDate(date.getYear() + 1900) + "\t"
                + br(max) + "\t"
                + br(min) + "\t"
                + br(media) + "\t"
                + br(mediana) + "\t"
                + br(desvioPadrao) + "\t"
                + br(variancia);
    }

    public String normalizeDate(int value) {
        if (value < 10) {
            return "0" + value;
        } else {
            return "" + value;
        }
    }

    public String br(double value) {
        return ("" + value).replace(".", ",");
    }

    public String br(int value) {
        return "" + value;
    }
}
