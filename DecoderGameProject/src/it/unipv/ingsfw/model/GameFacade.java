package it.unipv.ingsfw.model;

public class GameFacade {

    private Encoder encoder;
    private Decoder decoder;
    private Game game;

    public GameFacade() {
        System.out.println("Model is ready!");
    }

    public void createGame(String decoderName, SecretCodeStrategy strategy, Observer observer) {
        encoder = new Encoder();
        encoder.setSecretCodeStrategy(strategy);
        encoder.addObserver(observer);

        decoder = new Decoder(decoderName);
        decoder.addObserver(observer);

        game = new Game();
    }
    /*
    public void initializeDecoder(String name, Observer observer) {
        decoder = new Decoder(name);
        decoder.addObserver(observer);
    }

    public void initializeEncoder(String name, Observer observer) {
        encoder = new Encoder(name);
        encoder.addObserver(observer);
    }

    public void initializeEncoder(Observer observer) {
        encoder = new Encoder();
        encoder.addObserver(observer);
    }

    public void initializeGame(Encoder encoder, Decoder decoder) {
        game = new Game(encoder,decoder);
    }
    */
    public void startGame() {
        encoder.generateSecretCode();
        game.start();
        System.out.println(game.getState());
        System.out.println(encoder.getSecretCode());
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
}
