import java.util.Arrays;
import java.util.Scanner;

public class CTCIPalindromePermutation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(isPalindromePermutation(input));
    }
    public static boolean isPalindromePermutation(String string){
        char[] holdChars = string.toCharArray();
        Arrays.sort(holdChars);
        int numOfSingles = 0;
        for(int x=0;x<holdChars.length;x++){
            if(x + 1 < holdChars.length && holdChars[x] != holdChars[x+1]){
                numOfSingles++;
            }else{
                x++;
            }
        }
        if(numOfSingles > 1)return  false;
        return true;
    }
}
