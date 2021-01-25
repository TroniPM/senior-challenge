package com.pmateus.questoes.q1;

import com.pmateus.utils.IO;
import com.pmateus.utils.Mensagem;
import com.pmateus.utils.Tokens;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author Paulo Mateus
 *
 * Exibir gráfico as palavras mais frequentes em toda a base de dados (Ex.:
 * gráfico de barras, nuvem de palavras, etc)
 */
public class Questao1 {

    public Questao1() {
        ArrayList<Mensagem> arr = IO.read();

        ArrayList<Questao1Aux> array = new ArrayList<>();
        //Inicializando.
        for (String token : Tokens.WORDS) {
            if (token.equals("Full_Text")
                    || token.equals("Common_Word_Count")
                    || token.equals("Word_Count")
                    || token.equals("Date")
                    || token.equals("IsSpam")) {
                continue;
            }//Ignorando atributos que não são palavras.
            array.add(new Questao1Aux(token));
        }

        for (Mensagem msg : arr) {
            for (Map.Entry<String, Integer> entry : msg.words.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();

                Questao1Aux obj = encontrarItem(array, key);
                if (obj != null) {
                    obj.repeticoes += value;
                }
            }
        }
        Collections.sort(array);
        imprimirArray(array);
    }

    public Questao1Aux encontrarItem(ArrayList<Questao1Aux> array, String palavra) {
        for (Questao1Aux questao1Token : array) {
            if (questao1Token.palavra.equals(palavra)) {
                return questao1Token;
            }
        }
        return null;
    }

    public void imprimirArray(ArrayList<Questao1Aux> array) {
        System.out.print("Palavra\t");
        System.out.println("Repetições");
        for (Questao1Aux a : array) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        new Questao1();
    }
}
