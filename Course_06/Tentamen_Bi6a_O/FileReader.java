package Tentamen_Bi6a_O;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    public static String[] Titles;
    public static String[] Authors;
    public static String[] Journals;
    static void fileReader(String name, String path) {
        // Een paar print statements om te laten zien welke file er word ingelezen en de path wie daar bij hoort.
        System.out.println("\nReading file");
        System.out.println("File name: "+name);
        System.out.println("File path: "+path);
        System.out.println(" ");

        // Leest het bestand regel voor regel uit en kijkt waar de auteurs, titels en journals staan.
        try {
            // Gebruikt het de variabele path uit FileFinder als bestandsnaam.
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));

            // Drie variabelen voor de huidige line en de totale tekst van de auteurs, titles en journals.
            String line;
            String totalAuthors = "";
            String totalTitels = "";
            String totalJournal = "";

            // Drie variable die gebruikt worden voor het bepalen wanneer die tekst de auteurs, titles en journals bevatten.
            boolean saveAuthorLines = false;
            boolean saveTitleLines = false;
            boolean saveJournalLines = false;

            // Leest de regel van het bestand wanneer deze niet leeg is.
            while ((line = reader.readLine()) != null) {

                // Het vinden van de auteurs naam.
                // Kijkt in de huidige regel of het woord "AUTHORS" er in voorkomt. Als dat zo is gaat de variabele
                // saveAuthorLines naar true en worden de gelezen regels opgeslagen in de variable totalAuthors. Die
                // wanneer het woord "TITLE" in de regel voorkomt word meegegeven aan de functie divideAuthors
                // samen met dat de variable saveAuthorLines weer naar false gaat todat er weer het woord "AUTHORS" voorkomt.
                if (line.contains("AUTHORS")) {
                    saveAuthorLines = true;
                }if (line.contains("TITLE")) {
                    saveAuthorLines = false;
                    divideAuthors(totalAuthors);
                    totalAuthors = "";
                }if (saveAuthorLines) {
                    totalAuthors = totalAuthors +  " " + line;
                }

                // Het vinden van de title naam.
                // Kijkt in de huidige regel of het woord "TITLE" er in voorkomt. Als dat zo is gaat de variabele
                // saveTitleLines naar true en worden de gelezen regels opgeslagen in de variable totalTitle. Die
                // wanneer het woord "JOURNAL" in de regel voorkomt word meegegeven aan de functie divideTitles
                // samen met dat de variable saveTitleLines weer naar false gaat todat er weer het woord "TITLE" voorkomt.
                if (line.contains("TITLE")) {
                    saveTitleLines = true;
                }if (line.contains("JOURNAL")) {
                    saveTitleLines = false;
                    divideTitles(totalTitels);
                    totalTitels = "";
                }if (saveTitleLines) {
                    totalTitels = totalTitels +  " " + line;
                }

                // Het vinden van de Journals.
                // Kijkt in de huidige regel of het woord "JOURNAL" er in voorkomt. Als dat zo is gaat de variabele
                // saveJournalLines naar true en worden de gelezen regels opgeslagen in de variable totalJournal. Die
                // wanneer het woord "PUBMED" of "COMMENT" in de regel voorkomt word meegegeven aan de functie divideJournals
                // samen met dat de variable saveJournalLines weer naar false gaat todat er weer het woord "JOURNAL" voorkomt.
                if (line.contains("JOURNAL")) {
                    saveJournalLines = true;
                } if (line.contains("PUBMED") || line.contains("COMMENT")) {
                    saveJournalLines = false;
                    divideJournal(totalJournal);
                    totalJournal = "";
                } if (saveJournalLines) {
                    totalJournal = totalJournal +  " " + line;
                }
            }

            // Sluit het bestand.
            reader.close();

        // Een exeption die optreed wanneer er wat fout gaat tijdens het lezen van het bestand.
        } catch (IOException e) {
            System.out.println("Error while reading file\n" + path);
            e.printStackTrace();
        }
    }

    // De functie die de String totalAuthors mee krijgt en deze verdeelt en het filterd.
    static void divideAuthors(String input){
        // Verwijdert de woorden "AUTHORS" en "and" van de string samen met overbodige spaties.
        input = input.replace("AUTHORS   ", "");
        input = input.replace("and", "");
        input = input.replace("   ", "");

        // Verdeelt de string by het gebruik van een regex.
        Authors = input.split("\\s* \\s*");
    }

    // De functie die de String totalTitle mee krijgt en deze verdeelt en het filterd.
    static void divideTitles(String input){
        // Verwijdert het woord "TITLE" samen met wat overbodige spaties.
        input = input.replace("TITLE   ", "");
        input = input.replace("     ", "");
        input = input.replace("  ", "");

        // Verdeelt de string op enters.
        Titles = input.split("\n");
    }

    // De functie die de String totalJournal mee krijgt en deze verdeelt en het filterd.
    static void divideJournal(String input){
        // Verwijdert het woord "JOURNAL" samen met wat overbodige spaties en vervangt de komma's.
        input = input.replace("JOURNAL   ", "");
        input = input.replace("     ", "");
        input = input.replace("   ", "");
        input = input.replace(",", " ");

        // Verdeelt de string op enters.
        Journals = input.split("\n");

        // Gaat naar de Functie mainMap in HashMaker die van alle gefilterde en verdeelde strings hashmaps maakt.
        HashMaker.mainMap();
    }
}