package com.gioco.thehuntress.adventure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public static Set<String> loadFileListInSet(File file) throws IOException {
        Set<String> set = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            set.add(reader.readLine().trim().toLowerCase());
        }
        reader.close();
        return set;
    }

        //restituisce una lista composta da comando oggetto oggetto senza stopwords
    public static List<String> parseString(String string, Set<String> stopwords) { //string= stringa composta da comando-stopword-oggetto-stopword-oggetto
        List<String> tokens = new ArrayList<>();
        String[] split = string.toLowerCase().trim().split("\\s+"); //prendo string, la suddivido, la metto in minuscolo e la inserisco in un array
        for (String t : split) {
            if (!stopwords.contains(t)) {  //se la stringa non è una parola vuota la aggiungo in una lista
                tokens.add(t);
            }
        }
        return tokens;  //tokens è la lista di Stringhe composta soltanto da comando-oggetto-oggetto
    }
}
