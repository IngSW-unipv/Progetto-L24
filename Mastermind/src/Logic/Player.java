package Logic;

public class Player {
    public int attempts;
    private int[][] sequences;

    public Player(int attempts) {
        this.attempts = attempts;
        sequences = new int[attempts][4];
    }

    public void setSequence(int tryN, int[] sequence) {
        System.arraycopy(sequence, 0, sequences[tryN], 0, sequence.length);
    }

    public int[] getSequence(int tryN) {
        return sequences[tryN];
    }
}
