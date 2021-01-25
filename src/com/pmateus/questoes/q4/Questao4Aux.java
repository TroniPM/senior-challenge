/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.questoes.q4;

import java.util.Date;

/**
 *
 * @author Paulo Mateus
 */
public class Questao4Aux {

    public Date date = null;
    public int dia = 0;
    public int sequencia = 0;

    public Questao4Aux(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return normalizeDate(date.getMonth() + 1) + "/" + normalizeDate(date.getYear() + 1900) + "\t"
                + (dia < 10 ? "0" + dia : dia) + "\t"
                + sequencia;
    }

    public String normalizeDate(int value) {
        if (value < 10) {
            return "0" + value;
        } else {
            return "" + value;
        }
    }

}
