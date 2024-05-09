package Logic;

import Graphics.MainGui;

import java.util.Arrays;

import static Logic.CodeEvaluation.*;

public class Main {

    public static void main(String[] args) {

        final int attempts = 10;
        final int[] secretCode = generateSecretCode();

//        print di verifica generazione codice segreto
        Arrays.stream(secretCode).forEach(System.out::println);
        System.out.println();

//        int[] guess = {0,1,2,3};
//
//        int[] hints = codeConfront(code,guess);
//        for (int hint : hints) {
//            System.out.println(hint);
//        }
        MainGui gui = new MainGui(secretCode);
    }


    private static int[] generateSecretCode() {
        int[] code = new int[4];
        code[0] = (int) (Math.random() * 6);
        for (int i = 1; i < code.length; i++) {

            code[i] = (int) (Math.random() * 6);
            for(int j = 0; j < i; j++) {

                while (code[i] == code[j]) {
                    code[i] = (int) (Math.random() * 6);
                    j = 0;
                }
            }
        }
        return code;
    }
}
