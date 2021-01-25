package com.pmateus.questoes.q2;

import com.pmateus.utils.IO;
import com.pmateus.utils.Mensagem;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Paulo Mateus
 *
 * Exibir gráfico com as quantidades de mensagens comuns e spams para cada mês;
 */
public class Questao2 {

    public Questao2() {
        ArrayList<Mensagem> arr = IO.read();
        ArrayList<Questao2Aux> arrayRepeticoes = new ArrayList<>();

        for (Mensagem mensagem : arr) {
            Questao2Aux q = encontrarItem(arrayRepeticoes, mensagem.date);
            q.comuns += !mensagem.isSpam ? 1 : 0;
            q.spams += mensagem.isSpam ? 1 : 0;
        }

        imprimirArray(arrayRepeticoes);
    }

    public Questao2Aux encontrarItem(ArrayList<Questao2Aux> arr, Date date) {
        for (Questao2Aux q : arr) {
            if (q.date.getMonth() == date.getMonth() && q.date.getYear() == date.getYear()) {
                return q;
            }
        }

        //se não encontrar, já cria
        Questao2Aux q = new Questao2Aux(date);
        arr.add(q);
        return q;
    }

    public void imprimirArray(ArrayList<Questao2Aux> arr) {
        System.out.print("Mês\t");
        System.out.print("Comuns\t");
        System.out.println("Spams");

        for (Questao2Aux q : arr) {
            System.out.println(q);
        }
    }

    public static void main(String[] args) {
        new Questao2();
    }
}
