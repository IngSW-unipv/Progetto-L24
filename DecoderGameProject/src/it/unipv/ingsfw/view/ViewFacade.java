package it.unipv.ingsfw.view;

import java.awt.event.ActionListener;

public class ViewFacade {

    private MainView mainview;
    private DecoderNameDialog decoderNameDialog;

    public ViewFacade() {
        this.mainview = new MainView();
        this.decoderNameDialog = new DecoderNameDialog(this.mainview);
        System.out.println("View is ready!");
    }

    public void createView() {
        mainview = new MainView();
    }

    public void showMainView() {
        mainview.setVisible(true);
    }

    public void hideMainView() {
        mainview.setVisible(false);
    }

    public void createNameDialog() {
        decoderNameDialog = new DecoderNameDialog(this.mainview);
    }

    public void showDecoderNameDialog() {
        decoderNameDialog.setVisible(true);
    }

    public void hideDecoderNameDialog() {
        decoderNameDialog.setVisible(false);
    }

    public String getDecoderName() {
        return decoderNameDialog.getDecoderName();
    }

    public void addConfirmNameButtonListener(ActionListener listener) {
        decoderNameDialog.addConfirmButtonListener(listener);
    }

    public void updateMainView(int gameID, String decoderName, int decoderPoints) {
        mainview.addTextInfo(gameID,decoderName,decoderPoints);
    }

    public MainView getMainView() {
        return mainview;
    }

}
