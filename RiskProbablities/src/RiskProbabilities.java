import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class RiskProbabilities {
    public static void main(String[] args) {
        int numberOfTerritories = 42;
        int sizeOfContinent = 2;
        int numberOfCards = 14;
        double iterationsToDo = 10000000;
        double numOfSuccess = 0;
        for (int y = 0; y < iterationsToDo; y++) {
            if (newContinentAttempt(numberOfTerritories, sizeOfContinent, numberOfCards)) {
                numOfSuccess++;
            }//
        }
        System.out.println(numOfSuccess/iterationsToDo * 100);
       /* boolean handContainsContinent = true;
        ArrayList<Integer> cardsInHand = new ArrayList<>();
        ArrayList<Integer> holdCards = new ArrayList<>();
        for (int x = 0; x < numberOfTerritories; x++) {
            holdCards.add(x + 1);
        }
        Collections.shuffle(holdCards);
        for(int x=0;x<numberOfCards;x++){
            cardsInHand.add(holdCards.remove(0));
        }
        for(int x=1;x<=sizeOfContinent;x++){
            if(!cardsInHand.contains(x)){
                handContainsContinent = false;
            }
        }
        System.out.print(handContainsContinent);*/
    }

    public static boolean newContinentAttempt(int numberOfTerritories, int sizeOfContinent, int numberOfCards) {
        boolean handContainsContinent = true;
        ArrayList<Integer> cardsInHand = new ArrayList<>();
        ArrayList<Integer> holdCards = new ArrayList<>();
        for (int x = 0; x < numberOfTerritories; x++) {
            holdCards.add(x + 1);
        }
        Collections.shuffle(holdCards);
        for (int x = 0; x < numberOfCards; x++) {
            cardsInHand.add(holdCards.remove(0));
        }
        for (int x = 1; x <= sizeOfContinent; x++) {
            if (!cardsInHand.contains(x)) {
                handContainsContinent = false;
            }
        }
        return handContainsContinent;
    }
}
