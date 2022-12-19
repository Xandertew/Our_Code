package Course_06.Afvink_05.Opdracht2;

import javax.swing.*;
import java.util.Scanner;

public class Afvink_04_2 {

    public static void main(String[] args) {
        Start();
    }
    public static void Start(){
        String input = JOptionPane.showInputDialog(null, "What amino acid would you like to know");
//      Scanner myObj = new Scanner(System.in);
//      System.out.println("Enter The amino acid");
//      String input = myObj.nextLine();
        
        if (input == null) {
            System.out.println("Exiting program");
            System.exit(0);
        }

        dissisionTime(input);
    }
    public static void dissisionTime(String str){
        int lengthInput = str.length();
        if (lengthInput == 1){
            SingleLetter.createHashOneLetter();
            SingleLetter.printStatement(str);

        } else if (lengthInput == 3){
            trippleletter.createHashTreeLetter();
            trippleletter.printStatement(str);

        } else {
            fullName.createHashFullName();
            fullName.printStatement(str);
        }
    }
}
