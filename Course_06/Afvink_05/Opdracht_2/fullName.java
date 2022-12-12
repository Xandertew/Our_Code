package Course_06.Afvink_05.Opdracht2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class fullName {
    public static HashMap<String, ArrayList<String>> AminoAcid;
    public static void createHashFullName(){
        AminoAcid = new HashMap<>();

        AminoAcid.put("ALANINE", new ArrayList<>(Arrays.asList("Ala", "A")));
        AminoAcid.put("ARGININE", new ArrayList<>(Arrays.asList("Arg", "R")));
        AminoAcid.put("ASPARAGINE", new ArrayList<>(Arrays.asList("Asn", "N")));
        AminoAcid.put("ASPARTIC ACID", new ArrayList<>(Arrays.asList("Asp", "D")));
        AminoAcid.put("CYSTEINE", new ArrayList<>(Arrays.asList("Cys", "C")));
        AminoAcid.put("GLUTAMINE", new ArrayList<>(Arrays.asList("Gln", "Q")));
        AminoAcid.put("GLUTAMIC ACID", new ArrayList<>(Arrays.asList("Glu", "E")));
        AminoAcid.put("GLYCINE", new ArrayList<>(Arrays.asList("Gly", "G")));
        AminoAcid.put("HHISTIDINE", new ArrayList<>(Arrays.asList("His", "H")));
        AminoAcid.put("ISOLEUCINE", new ArrayList<>(Arrays.asList("Ile", "I")));
        AminoAcid.put("LEUCINE", new ArrayList<>(Arrays.asList("Leu", "L")));
        AminoAcid.put("LYSINE", new ArrayList<>(Arrays.asList("Lys", "K")));
        AminoAcid.put("METHIONINE", new ArrayList<>(Arrays.asList("Met", "M")));
        AminoAcid.put("PHENYLALANINE", new ArrayList<>(Arrays.asList("Phe", "F")));
        AminoAcid.put("PROLINE", new ArrayList<>(Arrays.asList("Pro", "P")));
        AminoAcid.put("SERINE", new ArrayList<>(Arrays.asList("Ser", "S")));
        AminoAcid.put("THREONINE", new ArrayList<>(Arrays.asList("Thr", "T")));
        AminoAcid.put("TRYPTOPHAN", new ArrayList<>(Arrays.asList("Trp", "W")));
        AminoAcid.put("TYROSINE", new ArrayList<>(Arrays.asList("Tyr", "Y")));
        AminoAcid.put("VALINE", new ArrayList<>(Arrays.asList("Val", "V")));
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

        System.out.println("Input:              " + input);
        System.out.println("Three letter code:  " + list[0]);
        System.out.println("One letter code:    " + list[1] + "\n");

        Afvink_04_2.Start();
    }
}
