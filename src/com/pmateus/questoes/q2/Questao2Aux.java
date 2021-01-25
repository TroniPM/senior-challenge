/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.questoes.q2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Mateus
 */
public class Questao2Aux {

    public Date date = null;
    public int comuns = 0;
    public int spams = 0;
    public static final SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Questao2Aux(Date date) {
        this.date = date;
    }

    public Questao2Aux(String date) {
        try {
            this.date = dateFormat1.parse(date);
        } catch (ParseException ex) {
            try {
                this.date = dateFormat2.parse(date);
            } catch (ParseException ex1) {
                ex1.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return normalizeDate(date.getMonth() + 1) + "/" + normalizeDate(date.getYear() + 1900)
                + "\t" + comuns
                + "\t" + spams;
    }

    public String normalizeDate(int value) {
        if (value < 10) {
            return "0" + value;
        } else {
            return "" + value;
        }
    }
}
