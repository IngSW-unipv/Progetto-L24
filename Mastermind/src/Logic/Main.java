package Logic;

import Graphics.MainGui;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        final int attempts = 10;
        final int[] secretCode = generateSecretCode();

//        print di verifica generazione codice segreto
        Arrays.stream(secretCode).forEach(System.out::println);
        System.out.println();

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
