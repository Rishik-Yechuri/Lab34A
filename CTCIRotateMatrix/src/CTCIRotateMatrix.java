import java.util.Arrays;
import java.util.Scanner;

public class CTCIRotateMatrix {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int arrayWidth = scanner.nextInt();
        int arrayHeight = scanner.nextInt();
        int[][] picture = new int[arrayHeight][arrayWidth];
        for(int y=0;y<picture.length;y++){
            for(int x=0;x<picture[0].length;x++){
                picture[y][x] = scanner.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(rotatePicture(picture)));
    }
    public static int[][] rotatePicture(int[][] pictureToRotate){
        System.out.println(Arrays.deepToString(pictureToRotate));
        int[][] newPicture = new int[pictureToRotate.length][pictureToRotate[0].length];
        for(int x=0;x<pictureToRotate[0].length;x++){
            for(int y=pictureToRotate.length-1;y>=0;y--){
                newPicture[x][pictureToRotate.length - 1 - y] = pictureToRotate[y][x];
            }
        }
        return newPicture;
    }
}
