package Tentamen_Bi6a_O;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Bi6a_O_Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Opent de class FileFinder om de bestanden die ingelezen moeten worden te vinden. Waarna deze worden een voor
        // een worden ingelezen en worden de Auteur, titel en journal toegevoegd in een hashmap.
        FileFinder.start();

        // Geeft een voorbeeld van een auteur waarop de gebruiker kan zoeken. Dit door de eerste key van de HashMap auteurHash
        // te printen.
        Optional<String> firstKey = HashMaker.authorHash.keySet().stream().findFirst();
        String key = null;
        if (firstKey.isPresent()) {
            key = firstKey.get();
        }
        System.out.println("Example of a author you can search about");
        System.out.println(key);

        // De functie die vraagt om input van de gebruiker.
        userInput();
    }
    static void userInput(){
        // Vraagt naar of de auteur of de titel waar de gebruiker naar zou willen zoeken.
        System.out.println("\nOf wich author or title would you like to see the values");
        String input = sc.nextLine();

        // Gebruikt de input van de gebruiker voor alle prints in de terminal.
        print(input);
    }
    static void print(String input){
        // Drie if statements die kijken of de meegegeven input van de gebruiker een key is in een van de drie hashMaps.
        // En als dat zo is alle opgeslagen informatie laat zien. Als de meegegeven inpaut van de gebruiker niet een key
        // is of niks heeft ingevuld dan vraagt hij de gebruiker of hij het programma wil sluiten.
        if (HashMaker.titleHash.get(input) != null){
            // Gebruikt de input van de gebruiker als key en print de opgeslagen informatie.
            System.out.println("\nResults for Authors from: " + input);
            for (String value : HashMaker.titleHash.get(input)){
                System.out.println(value);
            }

            // Gaat weer terug naar de functie userInput zodat meerdere dingen gevraagd kunnen worden.
            userInput();
        }
        else if (HashMaker.authorHash.get(input) != null){
            // Gebruikt de input van de gebruiker als key en print de opgeslagen informatie.
            System.out.println("\nResults for Titles from: " + input);
            for (String value : HashMaker.authorHash.get(input)){
                System.out.println(value);
            }

            // Gebruikt de input van de gebruiker als key en print de opgeslagen informatie.
            System.out.println("\nResults for Journals from: " + input);
            for (String value : HashMaker.journalHash.get(input)){
                System.out.println(value);
            }

            // Vraagt aan de gebruiker of die de gedisplayde informatie wilt opslaan in een bestand.
            System.out.println("\nWould you like to save this entry?\t(Y/N)");
            String save = sc.nextLine();
            save = save.toUpperCase(Locale.ROOT);

            // Als de gebruiker hier "Y" op antwoord word de functie saveEntry aangeroepen.
            if (save.equals("Y")){
                // Roept de Functie saveEntry aan.
                saveEntry(input);
            } else {
                // Gaat weer terug naar de functie userInput zodat meerdere dingen gevraagd kunnen worden.
                userInput();
            }
        }
        else {
            // Als de gebruiker niks of iets onbekends opvraagt dan word er gevraagd of de gebruiker misschien het
            // programma wilt afsluiten.
            System.out.println("\nDo you want to quit?\t(Y/N)");
            String exit = sc.nextLine();
            exit = exit.toUpperCase(Locale.ROOT);

            // Als de gebruiker hier "Y" op antwoord word de functie exit aangeroepen.
            if (exit.equals("Y")){
                // Roept de Functie exit aan.
                exit();
            }
            else {
                // Gaat weer terug naar de functie userInput zodat meerdere dingen gevraagd kunnen worden.
                userInput();
            }
        }
    }
    static void saveEntry(String input){
        // De funtie die word aangeroepen als de gebruiker de gedisplayde informatie wilt opslaan.

        // Maakt een nieuw bestand aan met in de naam de naam van de gegeven input van de gebruiker.
        File file = new File("Output_" +  input +"_.txt");
        try {
            // Maakt een filewriter aan zodat er in het nieuwe bestand geschreven kan worden
            FileWriter writer = new FileWriter(file);

            // De eerste regel van het nieuwe bestand met de naam van de input en een kleine divider voor een makkelijk
            // overzicht.
            writer.write("All the results for entry: " + input + "\n");

            // Alle informatie over de titels van de auteur onder elkaar geschreven m.b.v een for loop.
            writer.write("#####################################################################################");
            writer.write("\n\nResults for Titles from: " + input);
            for (String value : HashMaker.authorHash.get(input)){
                writer.write("\n" + value);
            }

            // Alle informatie over de journals van de auteur onder elkaar geschreven m.b.v een for loop.
            writer.write("\n\n#####################################################################################");
            writer.write("\n\nResults for Journals from: " + input);
            for (String value : HashMaker.journalHash.get(input)){
                writer.write("\n" + value);
            }

            // Sluit het bestand en laat met een print statement weten dat het wegschrijven gelukt is.
            writer.close();
            System.out.println("File " + file + " created Successfully");

        // De exeption die komt als het niet gelukt is om het bestand te schrijven.
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file");
            throw new RuntimeException(e);
        }

        // Gaat weer terug naar de functie userInput zodat meerdere dingen gevraagd kunnen worden.
        userInput();
    }
    static void exit(){
        // Sluit het programma met een laatste print statement.
        System.out.println("\nExiting program...");
        System.exit(0);
    }
}
