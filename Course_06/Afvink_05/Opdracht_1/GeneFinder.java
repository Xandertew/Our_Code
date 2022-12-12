package Course_06.Afvink_05.Opdracht1;

public class GeneFinder {
    public static String[] list1;
    public static String[] list2;
    public static String[] list3;
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
        for (String s : list1) {
            for (String value : list2) {
                for (String item : list3) {

                    if (s.equals(value)) {
                        if (s.equals(item)) {
                            CreateGui.BottomText.append(s + "\n");
                        }
                    }
                }
            }
        }
    }
    public static void overeenkomsten_1(){
        // hier moet al die big o onzin als ik dat eens een keer goed begrijp
        CreateGui.BottomText.setText("Overeenkomsten tussen 1 & 2\n");
        for (String s : list1) {
            for (String value : list2) {

                if (s.equals(value)) {
                    CreateGui.BottomText.append(s + "\n");
                }
            }
        }
    }
    public static void overeenkomsten_2(){
        // hier moet al die big o onzin als ik dat eens een keer goed begrijp
        CreateGui.BottomText.setText("Overeenkomsten tussen 1 & 3\n");
        for (String s : list1) {
            for (String value : list3) {

                if (s.equals(value)) {
                    CreateGui.BottomText.append(s + "\n");
                }
            }
        }
    }
    public static void overeenkomsten_3(){
        // hier moet al die big o onzin als ik dat eens een keer goed begrijp
        CreateGui.BottomText.setText("Overeenkomsten tussen 2 & 3\n");
        for (int i = 0; i < list2.length; i++){
            for (int j = 0; j < list3.length; j++){

                String str1 = list2[i];
                String str2 = list3[j];

                if (str1.equals(str2)){
                    CreateGui.BottomText.append(str1 + "\n");
                }
            }
        }
    }
}
