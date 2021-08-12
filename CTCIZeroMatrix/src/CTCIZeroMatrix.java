import java.util.Arrays;
import java.util.Scanner;

public class CTCIZeroMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Height:");
        int arrayHeight = scanner.nextInt();
        System.out.print("Width");
        int arrayWidth = scanner.nextInt();
        int[][] array = new int[arrayHeight][arrayWidth];
        for (int y = 0; y < arrayHeight; y++) {
            for (int x = 0; x < arrayWidth; x++) {
                array[y][x] = scanner.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(zeroOutArray(array)));
    }

    public static int[][] zeroOutArray(int[][] array) {
        int[][] newArray = new int[array.length][array[0].length];
        for(int y=0;y< array.length;y++){
            for(int x=0;x< array[0].length;x++){
                newArray[y][x] = array[y][x];
            }
        }
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                if (array[y][x] == 0) {
                    for (int newX = 0; newX < array[0].length; newX++) {
                        newArray[y][newX] = 0;
                    }
                    for (int newY = 0; newY < array.length; newY++) {
                        newArray[newY][x] = 0;
                    }
                    y++;
                    x=-1;
                }
            }
        }
        return newArray;
    }
}
