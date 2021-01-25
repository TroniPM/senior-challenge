package com.pmateus.questoes.q3;

import com.pmateus.utils.IO;
import com.pmateus.utils.Mensagem;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Paulo Mateus
 *
 * Calcular o máximo, o mínimo, a média, a mediana, o desvio padrão e a
 * variância da quantidade total de palavras (Word_Count) para cada mês;
 */
public class Questao3 {

    public Questao3() {
        ArrayList<Mensagem> arr = IO.read();
        ArrayList<Questao3Aux> arrayRepeticoes = new ArrayList<>();

        for (Mensagem mensagem : arr) {
            Questao3Aux q = encontrarItem(arrayRepeticoes, mensagem.date);
            q.add(mensagem.word_count);
        }

        for (Questao3Aux mes : arrayRepeticoes) {
            mes.doScheme();
        }

        imprimirArray(arrayRepeticoes);
    }

    public Questao3Aux encontrarItem(ArrayList<Questao3Aux> arr, Date date) {
        for (Questao3Aux q : arr) {
            if (q.date.getMonth() == date.getMonth() && q.date.getYear() == date.getYear()) {
                return q;
            }
        }

        //se não encontrar, já cria
        Questao3Aux q = new Questao3Aux(date);
        arr.add(q);
        return q;
    }

    public void imprimirArray(ArrayList<Questao3Aux> arr) {
        System.out.print("Mês\t");
        System.out.print("Max\t");
        System.out.print("Mín\t");
        System.out.print("Média\t");
        System.out.print("Mediana\t");
        System.out.print("DesvioPadrão\t");
        System.out.println("Variância");

        for (Questao3Aux q : arr) {
            System.out.println(q);
        }
    }

    public static void main(String[] args) {
        new Questao3();
    }
}
