package Course_06.Afvink_05.Opdracht1;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUser {
    public static void choices() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Wou je anders de default text meenemen?");
        if (dialogResult == 0) {
            CreateGui.BottomText.setText("");
            fillTextArea();
        } else {
            CreateGui.Area1.setText("Dan moet je Hier nog wat invullen");
            CreateGui.Area2.setText("Dan moet je Hier ook nog wat invullen");
            CreateGui.Area3.setText("Dan moet je zelfs Hier nog wat invullen");
            CreateGui.BottomText.setText("Dan heb je ze nu zelf ingevuld neem ik aan");
        }
    }
    public static void fillTextArea() {
        int FileCount = 3;
        int fileNR = 1;
        CreateGui.Area1.setText("");
        CreateGui.Area2.setText("");
        CreateGui.Area3.setText("");
        try {
            for(int i = 0;i < FileCount; i++){
                BufferedReader File = new BufferedReader(new FileReader("src/Course_06/Files/File_0" + fileNR));
                String line;
                if(fileNR==1){
                    while ((line = File.readLine()) != null) {
                        CreateGui.Area1.append(line + "\n");
                    }
                }if(fileNR==2){
                    while ((line = File.readLine()) != null) {
                        CreateGui.Area2.append(line + "\n");
                    }
                }
                if(fileNR==3){
                    while ((line = File.readLine()) != null) {
                        CreateGui.Area3.append(line + "\n");
                    }
                }
                File.close();
                fileNR ++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File Error");
        }
    }
}
