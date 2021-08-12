import java.util.Arrays;
import java.util.Scanner;

public class CTCICheckPermutation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String input2 = scanner.nextLine();
        char[] inputChars = input.toCharArray();
        char[] inputChars2 = input2.toCharArray();
        Arrays.sort(inputChars);
        Arrays.sort(inputChars2);
        System.out.println(checkIfArrayContains(inputChars,inputChars2));
    }
    public static boolean checkIfArrayContains(char[] array1,char[] array2){
        if(array1.length != array2.length){
            return false;
        }
        for(int x=0;x< array1.length;x++){
            if(array1[x] != array2[x]){
                return false;
            }
        }
        return true;
    }
}