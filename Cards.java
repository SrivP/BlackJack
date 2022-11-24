import java.util.*;

public class Cards {

    private ArrayList<Integer> cardList = new ArrayList<Integer>(51);

    // contructs the Cards object initializing it with an array of index 1 - 51
    public Cards() {
        for (int i = 0; i <= 51; i++) {
            cardList.add(i);
        }
    }

    // shuffles the cards
    public void shuffle() {
        Collections.shuffle(cardList);
    }

    // checks if the deck is below 10 card and adds cards, else passes a card index whilst removing it from the list
    public int giveCard() {
        if (cardList.size() <= 10) {
            cardList.clear();
            for (int i = 0; i <= 51; i++) {
                cardList.add(i);
            }
            Collections.shuffle(cardList);
        }
        int card = cardList.get(0);
        cardList.remove(0);
        return card;
    }

    public static int getValue(int x) {
        int[] values = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10};
        return values[x % 13];
    }

    // prints out the deck
    public String toString() {
        String output = "";
        String[] values = {"K", "A", "2" , "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q"};
        char[] suite = {3,4,5,6};
        for (int l = 0; l <= cardList.size() - 1; l++ ) {
            output += values[cardList.get(l) % 13] + suite[cardList.get(l) / 13] + " ";
        }
        return output;
    }

}






