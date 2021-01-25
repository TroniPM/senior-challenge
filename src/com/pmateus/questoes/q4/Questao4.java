package com.pmateus.questoes.q4;

import com.pmateus.utils.IO;
import com.pmateus.utils.Mensagem;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Paulo Mateus
 *
 * Exibir o dia de cada mês que possui a maior sequência de mensagens comuns
 * (não spam).
 */
public class Questao4 {

    public Questao4() {
        ArrayList<Mensagem> arr = IO.read();
        ArrayList<Questao4Aux> arrayRepeticoes = new ArrayList<>();

        int dia = 0;
        int sequencia = 0;
        for (Mensagem msg : arr) {
            Questao4Aux q = encontrarItem(arrayRepeticoes, msg.date);

            if (dia == msg.date.getDate()) {
                if (!msg.isSpam) {
                    sequencia++;
                } else {
                    if (sequencia > q.sequencia) {
                        q.sequencia = sequencia;
                        q.dia = dia;
                    }
                    sequencia = 0;
                }
            } else {
                if (sequencia > q.sequencia) {
                    q.sequencia = sequencia;
                    q.dia = dia;
                }

                dia = msg.date.getDate();

                if (msg.isSpam) {
                    sequencia = 0;
                } else {
                    sequencia = 1;
                }
            }
        }

        imprimirArray(arrayRepeticoes);

    }

    public Questao4Aux encontrarItem(ArrayList<Questao4Aux> arr, Date date) {
        for (Questao4Aux q : arr) {
            if (q.date.getMonth() == date.getMonth() && q.date.getYear() == date.getYear()) {
                return q;
            }
        }

        //se não encontrar, já cria
        Questao4Aux q = new Questao4Aux(date);
        arr.add(q);
        return q;
    }

    public void imprimirArray(ArrayList<Questao4Aux> arr) {
        System.out.print("Mês\t");
        System.out.print("Dia\t");
        System.out.println("MaiorSequencia");

        for (Questao4Aux q : arr) {
            System.out.println(q);
        }
    }

    public static void main(String[] args) {
        new Questao4();
    }
}
