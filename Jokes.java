import java.util.*;
import java.io.*;

public class Jokes {

    private static String joke;
    private static ArrayList<String> jokes = new ArrayList<String>();

    // loads a new joke from a file if needed, and returns a random joke, while removing it from the list.
    static String nextJoke() {
        joke = "";
        try {if (jokes.isEmpty()) {
            loadJokes();
            Collections.shuffle(jokes);
        }

        } catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < jokes.size(); i++) {
            joke = jokes.get(i);
            jokes.remove(i);
            }
        return joke;
        }

        // load a new joke
    static void loadJokes() throws Exception {
        Scanner scFile = new Scanner(new File("C:\\Users\\Sri\\IdeaProjects\\BJ Final\\src\\jList.txt"));
        for(int i=0;i<8;i++){
            jokes.add(scFile.nextLine());
        }


    }


}
