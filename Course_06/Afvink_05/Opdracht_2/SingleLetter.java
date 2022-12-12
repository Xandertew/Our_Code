package Course_06.Afvink_05.Opdracht2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SingleLetter {
    public static HashMap<String, ArrayList<String>> AminoAcid;
    public static void createHashOneLetter(){
        AminoAcid = new HashMap<>();

        AminoAcid.put("A", new ArrayList<>(Arrays.asList("Ala", "Alanine")));
        AminoAcid.put("R", new ArrayList<>(Arrays.asList("Arg", "Arginine")));
        AminoAcid.put("N", new ArrayList<>(Arrays.asList("Asn", "Asparagine")));
        AminoAcid.put("D", new ArrayList<>(Arrays.asList("Asp", "Aspartic acid")));
        AminoAcid.put("C", new ArrayList<>(Arrays.asList("Cys", "Cysteine")));
        AminoAcid.put("Q", new ArrayList<>(Arrays.asList("Gln", "Glutamine")));
        AminoAcid.put("E", new ArrayList<>(Arrays.asList("Glu", "Glutamic acid")));
        AminoAcid.put("G", new ArrayList<>(Arrays.asList("Gly", "Glycine")));
        AminoAcid.put("H", new ArrayList<>(Arrays.asList("His", "Histidine")));
        AminoAcid.put("I", new ArrayList<>(Arrays.asList("Ile", "Isoleucine")));
        AminoAcid.put("L", new ArrayList<>(Arrays.asList("Leu", "Leucine")));
        AminoAcid.put("K", new ArrayList<>(Arrays.asList("Lys", "Lysine")));
        AminoAcid.put("M", new ArrayList<>(Arrays.asList("Met", "Methionine")));
        AminoAcid.put("F", new ArrayList<>(Arrays.asList("Phe", "Phenylalanine")));
        AminoAcid.put("P", new ArrayList<>(Arrays.asList("Pro", "Proline")));
        AminoAcid.put("S", new ArrayList<>(Arrays.asList("Ser", "Serine")));
        AminoAcid.put("T", new ArrayList<>(Arrays.asList("Thr", "Threonine")));
        AminoAcid.put("W", new ArrayList<>(Arrays.asList("Trp", "Tryptophan")));
        AminoAcid.put("Y", new ArrayList<>(Arrays.asList("Tyr", "Tyrosine")));
        AminoAcid.put("V", new ArrayList<>(Arrays.asList("Val", "Valine")));
    }
    public static void printStatement(String input) {
        String search = input.toUpperCase();

        String[] list = new String[2];
        try {
            list = AminoAcid.get(search).toArray(new String[0]);
        } catch (NullPointerException e) {
            list[0] = "Geen aminozuur";
            list[1] = "Geen aminozuur";
        }

        System.out.println("Input:              " + search);
        System.out.println("Three letter code:  " + list[0]);
        System.out.println("Full name:          " + list[1] + "\n");

        Afvink_04_2.Start();
    }
}
