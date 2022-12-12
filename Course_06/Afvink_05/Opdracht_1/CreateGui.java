package Course_06.Afvink_05.Opdracht1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CreateGui extends JFrame {
    public static JTextArea Area1;
    public static JTextArea Area2;
    public static JTextArea Area3;
    public static JTextArea BottomText;
    public static JComboBox<String> dropDownMenu;
    public static void firstStep() {
        CreateGui frame = new CreateGui();
        frame.setSize(400, 450);
        frame.secondStep();
        frame.setVisible(true);

    }
    private void secondStep() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // 3 Labels voor duidelijkheid
        JLabel LabelA1 = new JLabel("Text Area 1");
        JLabel LabelA2 = new JLabel("Text Area 2");
        JLabel LabelA3 = new JLabel("Text Area 3");

        Dimension LabelGrootte = new Dimension(112,25);
        LabelA1.setPreferredSize(LabelGrootte);
        LabelA2.setPreferredSize(LabelGrootte);
        LabelA3.setPreferredSize(LabelGrootte);

        // De 3 Area's voor de text
        Area1 = new JTextArea();
        Area2 = new JTextArea();
        Area3 = new JTextArea();

        Dimension AreaGrootte = new Dimension(112,175);
        Area1.setPreferredSize(AreaGrootte);
        Area2.setPreferredSize(AreaGrootte);
        Area3.setPreferredSize(AreaGrootte);

        Area1.setLineWrap(true);
        Area1.setWrapStyleWord(true);
        Area2.setLineWrap(true);
        Area2.setWrapStyleWord(true);
        Area3.setLineWrap(true);
        Area3.setWrapStyleWord(true);

        // De onderste textArea en de Button
        // Bottom text
        BottomText = new JTextArea();
        BottomText.setPreferredSize(new Dimension(346,100));
        BottomText.setLineWrap(true);
        BottomText.setWrapStyleWord(true);
        BottomText.setEditable(false);

        // Button
        JButton CalculateBtn = new JButton("Calculate");
        CalculateBtn.setPreferredSize(new Dimension(346,25));
        CalculateBtn.addActionListener(this::calculate);

        // Dropdown menu
        String[] choices = { "Overeenkomt 1,2 & 3","Overeenkomt 1 & 2", "Overeenkomt 1 & 3","Overeenkomt 2 & 3"};
        dropDownMenu = new JComboBox<String>(choices);

        // Lekker alles aan de Gui toevoegen
        window.add(LabelA1);
        window.add(LabelA2);
        window.add(LabelA3);

        window.add(Area1);
        window.add(Area2);
        window.add(Area3);

        window.add(dropDownMenu);

        window.add(CalculateBtn);
        window.add(BottomText);
    }
    private void calculate(ActionEvent event) {
        GeneFinder.selectedOvereenkomsten();
    }
}
