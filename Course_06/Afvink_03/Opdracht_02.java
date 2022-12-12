package Course_06.Afvink_03;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Opdracht_02 extends Component {
    private static String chromosome = "";
    private static List<List<String>> topList;

    public static void main(String[] args) {
        System.out.println("\nOpdracht 2 LinkedList");

        readFile();

        System.out.println("\nDe lijst met lijsten met dezelfde chromosoom nummers:\n" + topList);

    }
    public static void readFile(){
        Opdracht_02 test = new Opdracht_02();
        try {
            BufferedReader inFile = new BufferedReader(new FileReader("src/Course_06/Files/testFile"));
            //Homo_sapiens.gene_info
            String line;
            String line1=null;

            while ((line1 = inFile.readLine()) != null){
                while ((line = inFile.readLine()) != null) {
                    String[] cut = line.split("\t");
                    chromosome += cut[6] + " ";
                }
            }
            inFile.close();
            test.lijsteMaken();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File Error");
        }
    }
    public void lijsteMaken(){
        String[] words = chromosome.split(" ");
        HashSet<String> uniqueWords = new HashSet<String>(Arrays.asList(words));

        List<String> strListChromo = List.of(chromosome.split(" "));

        // Print voor alle chromosoom nr's en nog een voor de unieke
        System.out.println("Alle chromosoom nummers:\n" + chromosome);
        System.out.println("\nAlle unieke chromosoom nummers:\n" + uniqueWords);

        topList = new ArrayList<List<String>>();
        for(String s:uniqueWords){
            ArrayList<String> bottomList = new ArrayList<String>();

            int i;
            for (i = 0; i < strListChromo.size(); i++)
            {
                if (s.equals(strListChromo.get(i))){
                    bottomList.add(s);
                }
            }
            topList.add(bottomList);
        }
    }
}
