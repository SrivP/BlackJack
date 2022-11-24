import java.util.*;

public class Game {
    static boolean over;

    static Scanner sc = new Scanner(System.in);
    static String name = sc.nextLine();
    static Person player = new Person(name);
    static Dealer dealer = new Dealer();
    static Cards deck = new Cards();
    static String hitStand = "";
    static String again = "";
    static int rounds = 1;

    static String winner = "";
    static Person[] players = {player,dealer};


    // prints out the deck and it's shuffled order

    public static void playGame() {
        add(2,players[0]);
        add(2,players[1]);
        do {
            while (!over) {
                System.out.println("Round #" + rounds + "\n");
                System.out.println(dealer.output() + "\n");
                System.out.println(players[0] + "\n");
                isWinner(players[0],players[1]);
                if (over) {
                    break;
                }
                userChoice();
                compChoice();

                System.out.println("__________" + "\n");
                System.out.println("Results: ");
                declareWinner();


                System.out.println("****************************************************************************************");

            }


            System.out.println("Do you want to play again? [Y/N]: ");
            again = sc.nextLine();
            if (again.equalsIgnoreCase("Y")) {
                over = false;
                players[0].clear();
                players[1].clear();
                add(2,players[1]);
                add(2,players[0]);

                System.out.println("****************************************************************************************");
            }

            rounds++;
        } while (again.equalsIgnoreCase("Y"));
        System.out.println("Thank you for playing my game");
    }



    public static void isWinner(Person player, Person dealer) {
        if (dealer.getSum() > 21 && player.getSum() > 21) {
            winner = players[1].getName();
            over = true;

        } else if (player.getSum() == 21) {
            winner = player.getName();
            over = true;

        } else if (dealer.getSum() == 21) {
            winner = players[1].getName();
            over = true;

        } else if (dealer.getSum() > 21) {
            winner = players[0].getName();
            over = true;

        } else if (player.getSum() > 21) {
            winner = players[1].getName();
            over = true;

        } else {
            if (dealer.getSum() <= 21 && dealer.getSum() > players[0].getSum()) {
                winner = players[1].getName();
                over = true;
            } else {
                winner = players[0].getName();
                over = true;
            }
            }
        }



    public static void declareWinner() {
        if (!over) {
            System.out.println(dealer.output() + "\n \n");
            System.out.println(players[0] + "\n \n");

        } else {
            System.out.println("The winner is: " + winner);
            System.out.print(players[1] + "\n \n");
            System.out.println(players[0] + "\n \n");
            try {
                System.out.println(players[1].getName() + " says: " + Jokes.nextJoke());
            } catch (Exception e) {
                System.out.println(e);
            }

        }


    }

    public static void intro() {
        System.out.println(deck + "\n");
        deck.shuffle();
        System.out.println(deck);
        System.out.println("____________________________________________________________________________________________");
    }

    public static void add(int x, Person y) {
        for (int k = 1; k <= x; k++) {
            y.addCard(deck.giveCard());
            y.updateSum();
        }
    }

    // method to do hit stand for the user
    public static void userChoice() {
        System.out.println("Hit or Stand?");
        hitStand = sc.nextLine();
        System.out.println();
        while (players[0].getSum() < 21 && hitStand.equalsIgnoreCase("hit")) {
            add(1,players[0]);
            System.out.println(players[0] + "\n");
            isWinner(players[0], players[1]);
            if (players[0].getSum() < 21){
                System.out.println("Hit or Stand?");
                hitStand = sc.nextLine();
            }
            if (players[0].getSum() > 21) {
                System.out.println("Player Bust!");
                over = true;
            }
        }
    }

    // method to do hit stand for the computer
    public static void compChoice() {
        while (players[0].getSum() < 21 && dealer.makeDecision()) {
            System.out.println("Dealer choice: Hit!");
            add(1, players[1]);
            System.out.println(players[0]);
            System.out.println(dealer.output() + "\n");
        }
        isWinner(players[0], players[1]);
        if (players[1].getSum() > 21) {
            System.out.println("Dealer Bust!");
        } else if (players[1].getSum() < 21 && players[0].getSum() < 21) {
            System.out.println("Dealer choice: Stand!");
        }
    }


}
