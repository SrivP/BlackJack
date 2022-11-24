public class Dealer extends Person {

    static String finalOutput;

    // initializes a dealer object + initializes finalOutput String
    public Dealer () {
        super("Casino God");
        finalOutput = "";
    }

    // A special method to replace all the dealer's cards with ?, prints out if the sum of the Dealer's cards are greater than or less than 10

    public String output() {
        String outSum = "";
        String output = "";
        char [] suite = {3,4,5,6};
        String[] value = {"K", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10","J", "Q"};
        for (int i= 0; i< gethand().size(); i++) {
            if (i == 0) {
                output += value[gethand().get(i) % 13] + suite[gethand().get(i) / 13];
            } else {

                output += " ?";
            }

        }
        if (getSum() > 10) {
            outSum = "Sum: > 10";
        } else {
            outSum = "Sum: < 10";
        }
        return getName() + "'s hand: " + output + " " + outSum;
    }

    // decides if dealer should hit or stand
    public boolean makeDecision() {
        return getSum() < 18;
    }
}
