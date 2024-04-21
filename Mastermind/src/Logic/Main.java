package Logic;

import Graphics.MainGui;

import java.util.Arrays;

import static Logic.CodeEvaluation.*;
import static Logic.CodeGenerator.*;

public class Main {

    public static void main(String[] args) {

        final int attempts = 10;
        setCode();
        final int[] code = getCode();
        Arrays.stream(code).forEach(System.out::println);
        System.out.println();
        int[] guess = {0,1,2,3};

        int[] hints = codeConfront(code,guess);
        for (int hint : hints) {
            System.out.println(hint);
        }
        MainGui gui = new MainGui(attempts);
    }

}
