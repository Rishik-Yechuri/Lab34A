import java.util.Scanner;

public class CTCIStringRotation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        System.out.println(isRotation(string1,string2));
    }
    public static boolean isRotation(String string1,String string2){
        string1 += string1;
        if(string1.contains(string2) && string1.length()/2 == string2.length())return true;
        return  false;
    }
}
