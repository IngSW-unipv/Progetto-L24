package it.unipv.ingsfw.view;

import java.awt.event.ActionListener;

public class ViewFacade {

    private MainView mainview;
    private DecoderNameDialog decoderNameDialog;

    public ViewFacade() {
        System.out.println("View is ready!");
    }

    public void createView() {
        mainview = new MainView();
    }

    public void showMainView() {

        mainview.setVisible(true);
    }

    public void createNameDialog() {
        decoderNameDialog = new DecoderNameDialog(this.mainview);
    }

    public void showDecoderNameDialog() {
        decoderNameDialog.setVisible(true);
    }

    public void hideDecoderNameDialog() {
        decoderNameDialog.setVisible(false);
        mainview.getOptionBar().setEnabled(true);
    }

    public String getDecoderName() {
        return decoderNameDialog.getDecoderName();
    }

    public String getDifficultyChosen() {
        return mainview.getOptionBar().getDifficulty();
    }

    public void applyDifficulty(int attempts) {
        mainview.setupAttemptsTable(attempts);
    }

    public void addConfirmNameButtonListener(ActionListener listener) {
        decoderNameDialog.addConfirmButtonListener(listener);
    }

    public void addDifficultySetButtonListener(ActionListener listener) {
        mainview.getOptionBar().addDifficultyButtonListener(listener);
    }

    public void addCheckSequenceButtonListener(ActionListener listener) {
        mainview.getCheckButton().addActionListener(listener);
    }

    public void showGameInfo(int gameID, String decoderName, int decoderPoints) {
        mainview.addTextInfo(gameID,decoderName,decoderPoints);
    }

    public MainView getMainView() {
        return mainview;
    }

}
