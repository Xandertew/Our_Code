package Course_06.Afvink_06.Opdracht_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Opdracht1 {

    public static void main(String[] args) throws FileNotFoundException{

        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> sequence = new ArrayList<String>();

        Scanner ScanLine = new Scanner(new File("src/Course_06/Files/Rosalind"));

        String seq = "";
        while(ScanLine.hasNextLine()){

            String temp = ScanLine.nextLine();
            if(temp.charAt(0) == '>'){

                sequence.add(seq);
                name.add(temp.substring(1));
                seq = "";

            } else {
                seq += temp;
            }
        }

        ScanLine.close();

        sequence.remove(0);
        sequence.add(seq);

        int Len = name.size();
        for(int i=0; i<Len; i++){

            System.out.println(name.get(i) +": " + sequence.get(i));
        }

        ArrayList<String> overLaps = linkOverlaps(name, sequence);

        System.out.println("\nResultaten: ");
        for (String overLap : overLaps) {
            System.out.println(overLap);
        }

    }//end main();

    private static ArrayList<String> linkOverlaps(ArrayList<String> name, ArrayList<String> sequence) {
        ArrayList<String> overLap = new ArrayList<String>();
        int size = name.size();

        for(int i=0; i<size; i++){
            int Len1 = sequence.get(i).length();

            for(int j=0; j<size; j++){

                if(i!=j && sequence.get(i).substring(Len1-3).equals(sequence.get(j).substring(0, 3))){
                    String linked = name.get(i) + " " + name.get(j);
                    overLap.add(linked);
                }
            }
        }

        return overLap;
    }
}