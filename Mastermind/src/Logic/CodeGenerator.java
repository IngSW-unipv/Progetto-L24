package Logic;

public class CodeGenerator {

    private static final int[] code = new int[4];

    public static void setCode() {

        for (int i = 0; i < code.length; i++) {

            code[i] = (int) (Math.random() * 6);

        }
    }

    public static int[] getCode() {

        return code;
    }
}
