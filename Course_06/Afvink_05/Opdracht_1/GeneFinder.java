package Course_06.Afvink_05.Opdracht1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GeneFinder {
    public static String[] list1;
    public static String[] list2;
    public static String[] list3;
    public static HashMap<String, ArrayList<String>> hashMapList;
    public static HashMap<String, ArrayList<String>> hashMapList1;
    public static void selectedOvereenkomsten() {
        getText();

        int keuze = CreateGui.dropDownMenu.getSelectedIndex();
        if (keuze == 0){
            overeenkomsten_0();
        } if (keuze == 1){
            overeenkomsten_1();
        } if (keuze == 2){
            overeenkomsten_2();
        } if (keuze == 3){
            overeenkomsten_3();
        }
    }
    public static void getText(){
        list1 = CreateGui.Area1.getText().split("\n");
        list2 = CreateGui.Area2.getText().split("\n");
        list3 = CreateGui.Area3.getText().split("\n");
    }
    public static void overeenkomsten_0(){
        // hier moet al die big o onzin als ik dat eens een keer goed begrijp
        CreateGui.BottomText.setText("Overeenkomsten tussen 1 / 2 & 3\n");
        hashMapList = new HashMap<>(10);
        hashMapList1 = new HashMap<>(10);

        for (int i = 0; i < list1.length; i++){
            hashMapList.put(list1[i], new ArrayList<>(List.of(list1[i])));
            hashMapList1.put(list2[i], new ArrayList<>(List.of(list2[i])));
        }
//        for (int i = 0; i < list2.length; i++){
//            if (hashMapList.get(list2[i]) != null){
//                CreateGui.BottomText.append(hashMapList.get(list2[i]) + "\n");
//            }
//        }
        for (String s : list3) {
            if (hashMapList.get(s) != null) {
                if (hashMapList1.get(s) != null) {
                    CreateGui.BottomText.append(hashMapList1.get(s) + "\n");
                }
            }
        }
    }
    public static void overeenkomsten_1(){
        // hier moet al die big o onzin als ik dat eens een keer goed begrijp
        CreateGui.BottomText.setText("Overeenkomsten tussen 1 & 3\n");

        hashMapList = new HashMap<>(10);

        for (String s : list1) {
            hashMapList.put(s, new ArrayList<>(List.of(s)));

        }
        for (String s : list2) {
            if (hashMapList.get(s) != null) {
                CreateGui.BottomText.append(hashMapList.get(s) + "\n");
            }
        }
    }
    public static void overeenkomsten_2(){
        // hier moet al die big o onzin als ik dat eens een keer goed begrijp
        CreateGui.BottomText.setText("Overeenkomsten tussen 1 & 3\n");

        hashMapList = new HashMap<>(10);

        for (String value : list1) {
            hashMapList.put(value, new ArrayList<>(List.of(value)));

        }
        for (String s : list3) {
            if (hashMapList.get(s) != null) {
                CreateGui.BottomText.append(hashMapList.get(s) + "\n");
            }
        }
    }
    public static void overeenkomsten_3(){
        // hier moet al die big o onzin als ik dat eens een keer goed begrijp
        CreateGui.BottomText.setText("Overeenkomsten tussen 2 & 3\n");

        hashMapList = new HashMap<>(10);

        for (String s : list2) {
            hashMapList.put(s, new ArrayList<>(List.of(s)));

        }
        for (String s : list3) {
            if (hashMapList.get(s) != null) {
                CreateGui.BottomText.append(hashMapList.get(s) + "\n");
            }
        }
    }
}
