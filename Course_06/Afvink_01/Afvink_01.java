package Course_06.Afvink_01;

import java.util.*;

public class Afvink_01 {
    private static List<Integer> list;
    public static void main(String[] args){
        opdracht1();
        opdracht2();
        opdracht3();
        opdracht4();
    }
    public static void opdracht1(){
        System.out.println("Afvink 1.1");
        System.out.println("* a: o(n)");
        System.out.println("* b: o(n^2)");
        System.out.println("* c: o(n^3)");
        System.out.println("* d: o(n)");
        System.out.println("* e: o(n^2)");
        System.out.println("* f: o(n)");
        System.out.println("* g: o(log(n))");
        System.out.println("* h: o(n!)");
        System.out.println("* i: o(n)");
    }
    public static void opdracht2(){
        System.out.println("\nAfvink 1.2");
        Random rand = new Random();
        list = new ArrayList<>();
        int aantalNummers = 30;

        for (int i = 0; i < aantalNummers; i++){
            int willekeurigGetal = rand.nextInt(1, 1000);
            list.add(willekeurigGetal);
        }

        //Making list (ArrayList0 into arr (int array)
        int [] arr = new int [aantalNummers];
        int temp = 0;
        for (int j = 0; j < aantalNummers; j++){
            arr[j] = list.get(j);
        }

        //Displaying elements of original array
        System.out.println("Ongesorteerde lijst: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }

        //Sort the array in ascending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        //Displaying elements of array after sorting
        System.out.println("\nGesorteerde lijst:   ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static void opdracht3(){
        System.out.println("\n\nAfvink 1.3");
        final long startTimeOp3 = System.currentTimeMillis();

        Random rand = new Random();
        list = new ArrayList<>();
        int aantalNummers = 1000000;

        for (int i = 0; i < aantalNummers; i++){
            int willekeurigGetal = rand.nextInt(1, 1000000000);
            list.add(willekeurigGetal);
        }
        System.out.println("Sorting ...");
        Collections.sort(list);
        System.out.println("Sorted");

        final long duration = System.currentTimeMillis() - startTimeOp3;
        System.out.println("Totale duratie in miliseconds: " + duration);
    }
    public static void opdracht4(){
        System.out.println("\nAfvink 1.4");

        Random rand = new Random();
        list = new ArrayList<>();
        int aantalNummers = 10;
        int aantalKeren = 10;
        String duraties = "";
        String[] dd = {};

        String keren = "";
        String[] ee = {};

        for (int j = 1; j < aantalKeren; j ++){

            int willekeurigGetal = rand.nextInt(1, 1000000000);
            list.add(willekeurigGetal);

            keren += aantalNummers+" ";
            ee = keren.split("\\s");

            aantalNummers = aantalNummers * 10;

            final long startTime = System.nanoTime();
            System.out.println("Keer nr: " + j);
            System.out.println("Sorting ...");
            Collections.sort(list);
            System.out.println("Sorted");
            final long duration = System.nanoTime() - startTime;

            System.out.println("Totale duratie in nanoseconds: " + duration + "\n");
            duraties += duration+" ";
            dd = duraties.split("\\s");

        }
        System.out.println("Hoeveelheid getallen:");
        for (String value : ee) {
            System.out.print(value + " ");
        }
        System.out.println("\n\nTijd in nanoseconden:");
        for (String s : dd) {
            System.out.print(s + " ");
        }
    }
}
