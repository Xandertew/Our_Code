package Tentamen_Bi6a_O;

import java.io.File;
import java.util.Scanner;

public class FileFinder {
    static int recursion = 0;
    static String input;

    public static void start() {
        // Vraagt de gebruiker om de naam van de map met bestanden zodat deze bestandsnamen kunnen worden opgehaald.
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the directory in which the files are located");
        input = myObj.nextLine();

        // Voor als die input leeg is gaat hij al meteen naar de functie die opnieuw deze aanroept.
        if (input.equals("")){
            fileLoop();
        }

        // Maakt een File object aan met de naam van de map waar de bestanden in staan.
        File directoryPath = new File("src/Tentamen_Bi6a_O/" + input);

        // Maakt een lijst van alle bestandsnamen in de map die net is aangemaakt.
        // En een String voor de naam van het bestand en de absolute path van het bestand.
        File[] filesList = directoryPath.listFiles();
        String path;
        String name;

        // Gaat door de lijst met bestanden als de ingevulde mapnaam bestaat, en geeft de naam van het bestand en
        // de absolute path van het bestand door aan de class FileReader zodat deze elk bestand een voor een in kan lezen.
        try {
            assert filesList != null;

            // Een for loop om voor elk bestand in de lijst met bestandsnamen de naam en path mee te geven aan de class
            // FileReader.
            for(File file : filesList) {

                name = file.getName();
                path = file.getAbsolutePath();

                // De call naar de class FileReader waaraan de naam en path worden meegegeven.
                FileReader.fileReader(name, path);
            }

        // De catch die je krijgt als de ingevulde mapnaam niet bestaat. En vervolgens weer vraagt om de map naam in de
        // functie fileloop.
        } catch (Exception e) {
            fileLoop();
        }
    }
    // De functie die 5 keer terug loopt naar de vorige functie en anders naar de functie exit in Bi6a_O_Main zit die
    // het programma stopt
    static void fileLoop() {
        System.out.println("File directory '" + input + "' does not exist\n");

        // Een for loop die ervoor zorgt dat de user niet in een oneindige loop vastzit wanneer de directory niet bestaat.
        recursion++;
        if (recursion<5){
            FileFinder.start();
        } else {

            // Na 5 keer word het programma beindigd met de functie exit in Bi6a_O_Main.
            System.out.println("Entered the wrong directory 5x");
            Bi6a_O_Main.exit();
        }
    }
}
