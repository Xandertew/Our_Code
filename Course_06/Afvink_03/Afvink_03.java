package Course_06.Afvink_03;
import java.io.IOException;

public class Afvink_03 {
    public static void main(String[] args) throws IOException {
        Theoretische_opdracht();
        // voor opdracht 1 run <BracketChecker.java>
//        Opdracht_02.main();
    }
    public static void Theoretische_opdracht(){
        System.out.println("Theoretische opdracht 1");
        System.out.println("Push(5)");
        System.out.println("\t\t[5]");
        System.out.println("Push(3)");
        System.out.println("\t\t[5, 3]");
        System.out.println("Pop()");
        System.out.println("\t\t[5]");
        System.out.println("Push(2)");
        System.out.println("\t\t[5, 2]");
        System.out.println("Push(8)");
        System.out.println("\t\t[5, 2, 8]");
        System.out.println("Pop()");
        System.out.println("\t\t[5, 8]");
        System.out.println("Pop()");
        System.out.println("\t\t[5]");
        System.out.println("Push(9)");
        System.out.println("\t\t[5, 9]");
        System.out.println("Push(1)");
        System.out.println("\t\t[5, 9, 1]");

        System.out.println("\nTheoretische opdracht 2");
        System.out.println("Doordat het LIFO is dus als de haakjes niet op volgorde staat gaat het fout");
    }
}
