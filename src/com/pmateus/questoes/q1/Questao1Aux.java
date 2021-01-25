/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.questoes.q1;

import java.util.Objects;

/**
 *
 * @author Paulo Mateus
 */
public class Questao1Aux implements Comparable< Questao1Aux> {

    public String palavra = null;
    public int repeticoes = 0;

    public Questao1Aux(String palavra, int repeticoes) {
        this.palavra = palavra;
        this.repeticoes = repeticoes;
    }

    public Questao1Aux(String palavra) {
        this.palavra = palavra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.palavra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questao1Aux other = (Questao1Aux) obj;
        if (!Objects.equals(this.palavra, other.palavra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return palavra + "\t" + repeticoes;
    }

    @Override
    public int compareTo(Questao1Aux t) {
        if (this.repeticoes < t.repeticoes) {
            return -1;
        } else if (this.repeticoes > t.repeticoes) {
            return 1;
        } else {
            return 0;
        }
    }

}
