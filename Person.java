import java.util.*;

public class Person {


    private ArrayList<Integer> hand = new ArrayList<Integer>();
    private int sum;
    private String name;
    static String output;

    // contructs the Person object & initalizes name and sum
    public Person(String name) {
        this.name = name;
        sum = 0;
    }

    // getter method for getting the card indexs of a person object's hand
    public ArrayList<Integer> gethand() {
        return hand;
    }

    // getter name
    public String getName() {
        return name;
    }

    // getter for sum
    public int getSum() {
        return sum;
    }


    // takes the given card index, and assigns it a value from (only) 1 to 10, while adding it to the hand
    public void addCard(int x) {
        hand.add(x);
    }



    // a short method to determine if "A" should be considered 1 or 11
    public void updateSum() {
        int counta = 0;
        int newsum = 0;
        for (Integer card : hand) {
            if (Cards.getValue(card) == 1) {
                counta += 1;
            } else {
                newsum += Cards.getValue(card);
            }
        }
        for(int i = 0; i < counta; i++){
            if(newsum + 11 <= 21)
                newsum += 11;
            else
                newsum += 1;
        }

        sum = newsum;


    }






    // takes the players hand and displays it in a string format along with the total sum of the card values
    public String toString() {
        String output = "";
        char [] suite = {3,4,5,6};
        String[] value = {"K", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10","J", "Q"};
        for (int i= 0; i< hand.size(); i++) {
            output += value[hand.get(i) % 13] + suite[hand.get(i) / 13] + " ";
        }
        return name + "'s hand: " + output + " " + sum;

    }

    // clears the person's hand, sum and resets output
    public void clear() {
        sum = 0;
        hand.clear();
        output = "";
    }




}
