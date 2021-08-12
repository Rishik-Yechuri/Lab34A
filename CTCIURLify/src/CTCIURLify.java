import java.util.Scanner;

public class CTCIURLify {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(urlifyString(input));
    }
    public static String urlifyString(String string){
        char[] holdNewString = new char[string.length()];
        char[] oldString = string.toCharArray();
        int offset = 0;
        int x = 0;
        while(offset + x < oldString.length){
            if(oldString[x] == ' '){
                holdNewString[x + offset] = '%';
                holdNewString[x+1 + offset] = '2';
                holdNewString[x+2 + offset] = '0';
                offset += 2;
            }else{
                holdNewString[x + offset] = oldString[x];
            }
            x++;
        }
        return String.valueOf(holdNewString);
    }
}
