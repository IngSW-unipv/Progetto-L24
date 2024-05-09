package Graphics;

import javax.swing.*;

public class OptionBar extends JMenuBar {

    JMenu firstMenu;
    JRadioButton difficultyEasy;
    JRadioButton difficultyNormal;
    JRadioButton difficultyHard;
    JCheckBox duplicateCheck;
    JMenuItem setButton;
//    int attempts = 0;
//    boolean duplicates = false;
    private AttemptsListener attemptsListener;


    public OptionBar() {

        firstMenu = new JMenu("File");
        firstMenu.getAccessibleContext().setAccessibleDescription("Impostazioni generali");
        this.add(firstMenu);
        ButtonGroup difficultyGroup = new ButtonGroup();
        JLabel difficultyLabel = new JLabel("Selezione difficoltà");
        firstMenu.add(difficultyLabel);
        difficultyEasy = new JRadioButton("Facile");
        difficultyEasy.setSelected(true);
//      inserire codice per la selezione numero tentativi
        difficultyGroup.add(difficultyEasy);
        firstMenu.add(difficultyEasy);
        difficultyNormal = new JRadioButton("Normale");
//      inserire codice per la selezione numero tentativi
        difficultyGroup.add(difficultyNormal);
        firstMenu.add(difficultyNormal);
        difficultyHard = new JRadioButton("Difficile");
//      inserire codice per la selezione numero tentativi
        difficultyGroup.add(difficultyHard);
        firstMenu.add(difficultyHard);
        firstMenu.addSeparator();
        JLabel duplicateLabel = new JLabel("Selezione duplicati");
        firstMenu.add(duplicateLabel);
        duplicateCheck = new JCheckBox("Ammetti duplicati");
//      inserire codice per il supporto ai duplicati
        duplicateCheck.setSelected(false);
        firstMenu.add(duplicateCheck);
        firstMenu.addSeparator();
        setButton = new JMenuItem("Conferma impostazioni");
        setButton.addActionListener(e -> {
            if(difficultyEasy.isSelected()) {
                attemptsListener.difficultyChoose(15);
            } else if (difficultyNormal.isSelected()) {
                attemptsListener.difficultyChoose(10);
            } else {
              attemptsListener.difficultyChoose(5);
            }
            if(duplicateCheck.isSelected()) {

            }


        });
        firstMenu.add(setButton);
    }

public void setAttemptsListener(AttemptsListener attemptsListener) {

        this.attemptsListener = attemptsListener;

}
}
