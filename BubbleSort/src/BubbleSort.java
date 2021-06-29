import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) throws InterruptedException {
        //Creates an array to store the values
        int[] unsortedList = new int[100];
        //Fills the array with random numbers ranging from 1-100
        for (int x = 0; x < 100; x++) {
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;
            unsortedList[x] = randomNumber;
        }
        //Prints out the unsorted list
        System.out.println("Unsorted List:" + Arrays.toString(unsortedList));
        //Sorts the list using bubblesort and prints it out
        System.out.println("Sorted List:" + Arrays.toString(bubbleSort(unsortedList)));
    }

    public static int[] bubbleSort(int[] unsortedArray) throws InterruptedException {
        //Stores whether or not a swap has occurred during a pass
        boolean noSwaps = true;
        do {
            //Resets to true each pass
            noSwaps = true;
            //Loops through each element
            for (int x = 0; x < unsortedArray.length - 1; x++) {
                //Compares the two elements to see if they need to be swapped
                if (unsortedArray[x] > unsortedArray[x + 1]) {
                    //Stores the second number's value
                    int tempValue = unsortedArray[x + 1];
                    //Replaces the second number's value with the first
                    unsortedArray[x + 1] = unsortedArray[x];
                    //Replaces the first number's value with the second
                    unsortedArray[x] = tempValue;
                    //noSwaps is set to false, indicating that a swap has occurred
                    noSwaps = false;
                }
            }
        }
        //Continues to loop as long as a swap has occurred in the previous pass
        while (!noSwaps);
        //Returns the sorted array
        return unsortedArray;
    }
}