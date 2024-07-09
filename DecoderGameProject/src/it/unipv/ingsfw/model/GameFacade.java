package it.unipv.ingsfw.model;

public class GameFacade {

    private Encoder encoder;
    private Decoder decoder;
    private Game game;
    private int attemptsLeft;
    private String[] colorList;

    public GameFacade() {
        colorList = new String[Colors.values().length];
        for(int i = 0; i < Colors.values().length; i++) {
            colorList[i] = Colors.values()[i].getColorName();
        }
        System.out.println("Model is ready!");
    }

    public void createGame(String decoderName, EncoderStrategy strategy, Observer observer) {
        encoder = new Encoder();
        encoder.setStrategy(strategy);
        encoder.addObserver(observer);

        decoder = new Decoder(decoderName);
        decoder.addObserver(observer);

        game = new Game();
    }

    public void startGame() {
        encoder.generateSecretCode();
        game.start();
        System.out.println(game.getState());
        System.out.println(encoder.getSecretCode());
    }

    public int setDifficulty(String difficultyName) {
        game.defineTotalAttempts(difficultyName);
        game.initializeHints(game.getTotAttempts());
        return game.getTotAttempts();
    }

    public void endGame() {
        game.end();
    }

    public Encoder getEncoder() {
        return encoder;
    }

    public Decoder getDecoder() {
        return decoder;
    }

    public Game getGame() {
        return game;
    }

    public String[] getColorList() {
        return colorList;
    }

    public boolean hasAttemptsLeft() {
        return attemptsLeft > 0;
    }

    public void evaluateSequence() {

    }
}
