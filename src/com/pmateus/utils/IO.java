/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Mateus
 */
public class IO {

    private static final String fileName = ".\\data\\sms_senior.csv";

    public static ArrayList<Mensagem> read() {
        ArrayList<Mensagem> response = new ArrayList<>();

        List<String[]> r = null;
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            r = reader.readAll();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (CsvException ex) {
            ex.printStackTrace();
        }

        int listIndex = 0;
        for (int i = 1; i < r.size(); i++) {//ignorando a linha 1
            String[] arrays = r.get(i);
            Mensagem msg = Mensagem.parse(arrays);
            response.add(msg);
        }

        return response;
    }
}
