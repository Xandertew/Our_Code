package Course_06.Afvink_02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Random;
public class Afvink_02 extends JFrame{
    public static int size;
    public static Color color;
    int Hsize = size;
    int Ysize = size;
    boolean cellsMap[][];
    JButton cells[][];
    public static boolean partyMode = false;
    public Afvink_02() {
        Random rnd = new Random();
        cellsMap = new boolean[Hsize][Hsize];
        cells = new JButton[Hsize][Hsize];
        setSize(750,750);
        setLayout(new GridLayout(Hsize, Hsize));
        for(int i = 0; i< Hsize; i++) {
            for(int j = 0; j< Ysize; j++) {
                cellsMap[i][j] = rnd.nextInt(100)<30;
                JButton temp = new JButton();
                if(cellsMap[i][j])
                    temp.setBackground(Color.white);
                else
                    temp.setBackground(Color.white);
                add(temp);
                cells[i][j] = temp;
            }
        }

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Timer timer = new Timer(5, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                boolean[][] temp = new boolean[Hsize][Hsize];
                for(int i = 0; i< Hsize; i++) {
                    for (int j = 0; j < Ysize; j++) {
                        int count = countNeigbours(i,j);
                        if(cellsMap[i][j]) {
                            if (count < 2)
                                temp[i][j]=false;
                            if (count == 3 || count == 2)
                                temp[i][j]=true;
                            if (count > 3)
                                temp[i][j]=false;
                        }else {
                            if(count ==3)
                                temp[i][j]=true;
                        }
                    }
                }

                cellsMap = temp;
                for(int i = 0; i< Hsize; i++) {
                    for (int j = 0; j < Ysize; j++) {
                        if(cellsMap[i][j]) {
                            if(partyMode){
                                //random kleurtjes
                                cells[i][j].setBackground(new Color(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255)));
                            }else {
                                cells[i][j].setBackground(color);
                            }
                        }else
                            cells[i][j].setBackground(Color.lightGray);
                    }
                }
            }
        });
        timer.start();
    }
    int countNeigbours(int x, int y) {
        int count = 0;
        for(int i=x-1;i<=x+1;i++) {
            for (int j=y-1; j <= y + 1; j++) {

                try {
                    if(cellsMap[i][j]) {
                        count++;
                    }

                }catch(Exception ignored) {
                }
            }
        }

        if(cellsMap[x][y])
            count--;
        return count;
    }
    static Color getColor(String col) {
        switch (col.toLowerCase()) {
            case "black":
                color = Color.BLACK;
                break;
            case "blue":
                color = Color.BLUE;
                break;
            case "cyan":
                color = Color.CYAN;
                break;
            case "darkgray":
                color = Color.DARK_GRAY;
                break;
            case "gray":
                color = Color.GRAY;
                break;
            case "green":
                color = Color.GREEN;
                break;

            case "yellow":
                color = Color.YELLOW;
                break;
            case "lightgray":
                color = Color.LIGHT_GRAY;
                break;
            case "magneta":
                color = Color.MAGENTA;
                break;
            case "orange":
                color = Color.ORANGE;
                break;
            case "pink":
                color = Color.PINK;
                break;
            case "red":
                color = Color.RED;
                break;
            case "white":
                color = Color.WHITE;
                break;

            case "rainbow":
                partyMode = true;
                break;
        }
        return color;
    }
    public static void keuzeStress(){
        String sizeStr = JOptionPane.showInputDialog(null, "What size do you want?\nChoose between 10 & 150");
        size = Integer.parseInt(sizeStr);

        if (size>150){
            JOptionPane.showMessageDialog(null, "BETWEEN 10 AND 150!",
                    "YOU STUPID!", JOptionPane.ERROR_MESSAGE);
            keuzeStress();
        } if (size<10){
            JOptionPane.showMessageDialog(null, "BETWEEN 10 AND 150!",
                    "YOU STUPID!", JOptionPane.ERROR_MESSAGE);
            keuzeStress();
        }
    }
    public static void main(String[] args) {
        keuzeStress();
        String kleurStr = JOptionPane.showInputDialog(null, "What color do you want");
        getColor(kleurStr);
        new Afvink_02();
    }
}