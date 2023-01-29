package Tentamen_Bi6a_O;

import java.util.*;

public class HashMaker {
    static HashMap<String, List<String>> authorHash = new HashMap<>();
    static HashMap<String, List<String>> titleHash = new HashMap<>();
    static HashMap<String, List<String>> journalHash = new HashMap<>();
    static void mainMap(){
        // Roept de drie functies aan die ieders een hashmap maken van de eerder gefilterde auteurs, titles en journals.
        authorMap();
        titleMap();
        journalMap();
    }
    static void authorMap(){
        // Voegt de naam van de auteur toe als key in de HashMap "authorHash" als deze nog niet bestaat m.b.v. een for loop.
        for (String author2 : FileReader.Authors){
            if (!authorHash.containsKey(author2)) {
                authorHash.put(author2, new ArrayList<String>());
            }
        }

        // Voegt de titel toe als value aan de key van de auteur die hem geschreven heeft. Als deze auteur deze titel al
        // heeft, word deze niet toegevoegd.
        String temp;
        for (String author : FileReader.Authors){
            for (String tit: FileReader.Titles){
                temp = tit;
                if (!authorHash.get(author).contains(temp)) {
                    authorHash.get(author).add(temp);
                }
            }
        }
    }
    static void titleMap(){
        // Voegt de titel van het onderzoek toe als key in de HashMap "titelHash" als deze nog niet bestaat m.b.v. een for loop.
        for (String title2 : FileReader.Titles){
            if (!titleHash.containsKey(title2)) {
                titleHash.put(title2, new ArrayList<String>());
            }
        }

        // Voegt de auteur toe als value aan de key van het onderzoek die hij of zij geschreven heeft. Als deze titel
        // deze auteur al heeft, word deze niet toegevoegd.
        String temp;
        for (String title : FileReader.Titles){
            for (String author: FileReader.Authors){
                temp = author;
                if (!titleHash.get(title).contains(temp)) {
                    titleHash.get(title).add(temp);
                }
            }
        }
    }
    static void journalMap(){
        // Voegt de naam van de auteur toe als key in de HashMap "journalHash" als deze nog niet bestaat m.b.v. een for loop.
        for (String author2 : FileReader.Authors){
            if (!journalHash.containsKey(author2)) {
                journalHash.put(author2, new ArrayList<String>());
            }
        }

        // Voegt de journal toe als value aan de key van de auteur die hem geschreven heeft. Als deze auteur dit journal al
        // heeft, word deze niet toegevoegd.
        String temp;
        for (String author : FileReader.Authors){
            for (String jour: FileReader.Journals){
                temp = jour;

                if (!journalHash.get(author).contains(temp)) {
                    journalHash.get(author).add(temp);
                }
            }
        }
    }
}
