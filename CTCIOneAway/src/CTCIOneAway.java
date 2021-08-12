import java.util.Scanner;

public class CTCIOneAway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        String input2 = scanner.next();
        System.out.println(oneStep(input1, input2));
    }

    public static boolean oneStep(String string1, String string2) {
        if (string1.length() - string2.length() == 1) {
            return checkIfAddition(string1, string2, true);
        } else if (string2.length() - string1.length() == 1) {
            return checkIfAddition(string2, string1, true);
        } else if (string1.equals(string2)) {
            return true;
        } else if (string1.length() == string2.length()) {
            return checkIfAddition(string1, string2, false);
        }
        return false;
    }

    public static boolean checkIfAddition(String big, String small, boolean hasOffset) {
        boolean singleFake = true;
        int offset = 0;
        char[] bigChar = big.toCharArray();
        char[] smallChar = small.toCharArray();
        for (int x = 0; x < bigChar.length; x++) {
            if(x == bigChar.length - 1 && offset == 0 && hasOffset)offset--;
            if (bigChar[x] != smallChar[x + offset]) {
                if (hasOffset) {
                    offset--;
                }
                if (singleFake) {
                    singleFake = false;
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
