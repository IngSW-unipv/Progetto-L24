package Logic;

public class CodeGenerator {

    private static final int[] code = new int[4];

    public static void setCode() {

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
    }

    public static int[] getCode() {

        return code;
    }
}
