/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Mateus
 */
public class Mensagem {

    public String full_text = "";
    public int common_word_count = 0;
    public int word_count = 0;
    public String data = "";
    public Date date = null;
    public boolean isSpam = false;
    public HashMap<String, Integer> words = new HashMap();

    public static Mensagem parse(String[] arrays) {
        Mensagem m = new Mensagem();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (int i = 0; i < arrays.length; i++) {
            String value = arrays[i];

            switch (i) {
                case 0:
                    m.full_text = value;
                    break;
                case 150:
                    m.common_word_count = Integer.parseInt(value);
                    break;
                case 151:
                    m.word_count = Integer.parseInt(value);
                    break;
                case 152:
                    m.data = value;
                    try {
                        m.date = df1.parse(value);
                    } catch (ParseException ex) {
                        try {
                            m.date = df2.parse(value);
                        } catch (ParseException ex1) {
                            ex1.printStackTrace();
                        }
                    }
                    break;
                case 153:
                    m.isSpam = value.equals("yes");
                    break;
                default:
                    m.words.put(Tokens.WORDS[i], Integer.parseInt(value));
                    break;
            }
        }

        return m;
    }

    @Override
    public String toString() {
        return "Mensagem {" + "full_text=" + full_text + ", common_word_count=" + common_word_count + ", word_count=" + word_count + ", data=" + data + ", date=" + date + ", isSpam=" + isSpam + ", words=" + words + '}';
    }

}
