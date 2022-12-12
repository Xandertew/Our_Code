package Course_06.Afvink_05.Opdracht2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class trippleletter {
    public static HashMap<String, ArrayList<String>> AminoAcid;
    public static void createHashTreeLetter(){
        AminoAcid = new HashMap<>();

        AminoAcid.put("ALA", new ArrayList<>(Arrays.asList("A", "Alanine")));
        AminoAcid.put("ARG", new ArrayList<>(Arrays.asList("R", "Arginine")));
        AminoAcid.put("ASN", new ArrayList<>(Arrays.asList("N", "Asparagine")));
        AminoAcid.put("ASP", new ArrayList<>(Arrays.asList("D", "Aspartic acid")));
        AminoAcid.put("CYS", new ArrayList<>(Arrays.asList("C", "Cysteine")));
        AminoAcid.put("GLN", new ArrayList<>(Arrays.asList("Q", "Glutamine")));
        AminoAcid.put("GLU", new ArrayList<>(Arrays.asList("E", "Glutamic acid")));
        AminoAcid.put("GLY", new ArrayList<>(Arrays.asList("G", "Glycine")));
        AminoAcid.put("HIS", new ArrayList<>(Arrays.asList("H", "Histidine")));
        AminoAcid.put("ILE", new ArrayList<>(Arrays.asList("I", "Isoleucine")));
        AminoAcid.put("LEU", new ArrayList<>(Arrays.asList("L", "Leucine")));
        AminoAcid.put("LYS", new ArrayList<>(Arrays.asList("K", "Lysine")));
        AminoAcid.put("MET", new ArrayList<>(Arrays.asList("M", "Methionine")));
        AminoAcid.put("PHE", new ArrayList<>(Arrays.asList("F", "Phenylalanine")));
        AminoAcid.put("PRO", new ArrayList<>(Arrays.asList("P", "Proline")));
        AminoAcid.put("SER", new ArrayList<>(Arrays.asList("S", "Serine")));
        AminoAcid.put("THR", new ArrayList<>(Arrays.asList("T", "Threonine")));
        AminoAcid.put("TRP", new ArrayList<>(Arrays.asList("W", "Tryptophan")));
        AminoAcid.put("TYR", new ArrayList<>(Arrays.asList("Y", "Tyrosine")));
        AminoAcid.put("VAL", new ArrayList<>(Arrays.asList("V", "Valine")));
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
        System.out.println("One letter code:    " + list[0]);
        System.out.println("Full name:          " + list[1] + "\n");

        Afvink_04_2.Start();
    }
}
