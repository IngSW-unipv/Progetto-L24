package Logic;

import Graphics.MainGui;

import static Logic.CodeGenerator.*;

public class Main {

    public static void main(String[] args) {

        final int attempts = 10;
        setCode();
        final int[] code = getCode();
        MainGui gui = new MainGui(attempts);

    }

}
