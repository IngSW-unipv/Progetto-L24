package it.unipv.ingsfw.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Dialog che permette all'utente di inserire il nome per il Decoder.
 */

public class DecoderNameDialog extends JDialog {

    private final JTextField nameField;
    private final JButton confirmButton;

    /**
     * Costruttore che inizializza il dialog con il titolo e i componenti necessari.
     *
     * @param parent il frame genitore su cui il dialog è posizionato.
     */

    public DecoderNameDialog(JFrame parent) {
        super(parent, "Insert your name", true);
//        Definizione della dimensione della finestra
        setSize(400, 100);
//        Impostazione della visibilità
        setVisible(false);
//        Definizione del Layout della finestra
        setLayout(new BorderLayout());
//        Creazione nuovo pannello
        JPanel panel = new JPanel();
//        Definizione Layout del pannello
        panel.setLayout(new GridLayout(1,2));
//        Inizializzazioni
        nameField = new JTextField();
        confirmButton = new JButton("Confirm name");
//        Aggiunte dei component nei container
        panel.add(new JLabel("Insert a name for Decoder: "));
        panel.add(nameField);
        add(panel, BorderLayout.CENTER);
        add(confirmButton, BorderLayout.PAGE_END);
//        Definizione posizionamento finestra
        setLocationRelativeTo(null);
    }

    /**
     * Restituisce il nome inserito dall'utente nel campo di testo.
     *
     * @return il nome inserito per il Decoder.
     */

    public String getDecoderName() {
        return nameField.getText();
    }

    /**
     * Mostra un messaggio di errore riguardante l'assenza del nome del decoder.
     */

    public void showErrorNameNotValid() {
        JOptionPane.showMessageDialog(this, "Error: Decoder name not valid!");
    }

    /**
     * Aggiunge un listener al pulsante di conferma per gestire l'evento di click.
     *
     * @param listener l'oggetto ActionListener da aggiungere al pulsante.
     */

    public void addConfirmButtonListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

}
