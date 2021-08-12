import java.util.Arrays;
import java.util.Scanner;

public class CTCIIsUnique {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputChars = input.toCharArray();
        int[] holdCharsAsInt = new int[inputChars.length];
        for(int x=0;x< inputChars.length;x++){
            holdCharsAsInt[x] = (int)inputChars[x];
        }
        Arrays.sort(holdCharsAsInt);
        boolean foundDuplicate = false;
        for(int x=0;x< holdCharsAsInt.length;x++){
            if(!foundDuplicate) {
                if (checkIfArrayContains(holdCharsAsInt, holdCharsAsInt[x],x)) {
                    foundDuplicate = true;
                }
            }
        }
        System.out.println(!foundDuplicate);
    }
    public static boolean checkIfArrayContains(int[] array,int key,int indexToIgnore){
        boolean keepGoing = true;
        int maxRight = array.length-1;
        int maxLeft = 0;
        int indexOfPointer;
        while(keepGoing){
            indexOfPointer = (maxLeft+maxRight)/2;
            if(indexToIgnore - 1 >= 0){
                array[indexToIgnore] = array[indexToIgnore-1];
            }else if(indexToIgnore + 1 < array.length){
                array[indexToIgnore] = array[indexToIgnore+1];
            }
            if(array[indexOfPointer] == key){
                array[indexToIgnore] = key;
                return true;
            }else if(array[indexOfPointer] > key){
                maxRight = indexOfPointer - 1;
            }else if(array[indexOfPointer] < key){
                maxLeft = indexOfPointer + 1;
            }
            if(maxRight - maxLeft <= 1){
                array[indexToIgnore] = key;
                keepGoing = false;
            }
        }
        return false;
    }
}