package Logic;

public class CodeEvaluation {

    private static int[] hints = new int[2];

    public static int[] codeConfront(int[] code, int[] guess) {

        hints[0] = 0;
        hints[1] = 0;
        try {
            for(int i = 0; i < 4; i++) {

                if(guess[i] == code[i]) {
                    hints[1] += 1;      // posizione 1 dell'array per pioli indizio rossi
                } else {

                    for(int j = 0; j < 4; j++) {

                        if(j != i && guess[i] == code[j]) {
                            hints[0] += 1;      // posizione 0 dell'array per pioli indizio bianchi
                        }

                    }

                }
            }
        }catch (Exception e) {
            System.out.println("An error occured during code evaluation!");
            return hints;
        }
        return hints;
    }
}
