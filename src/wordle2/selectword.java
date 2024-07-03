package wordle2;

import java.sql.ResultSet;
import java.util.Random;

 class wordchooser {
     Random random = new Random();
     static int anInt;


     wordchooser() {
         int random_int = random.nextInt(50);
         anInt = random_int;

         System.out.println("the num is:" + anInt);

     }
 }
class WordHint {
    String word;
    String hint;

    public WordHint(String word, String hint) {
        this.word = word;
        this.hint = hint;
    }

    @Override
    public String toString() {
        return "Word: " + word + ", Hint: " + hint;
    }
}


public class selectword {
    static WordHint gotWordHint;

    public static WordHint getWordAndHint() {
        connect c = new connect();
        String query = "SELECT words, hint FROM word WHERE nos = " + wordchooser.anInt + ";";

        try {
            ResultSet choose = c.s.executeQuery(query);
            if (choose.next()) {
                String word = choose.getString("words");
                String hint = choose.getString("hint");
                System.out.println("Query executed successfully");
                return new WordHint(word, hint);
            }
        } catch (Exception e) {
            System.out.println("Query not executed");

        }
        return null;
    }

    public static void main(String[] args) {
        new wordchooser();
        gotWordHint = selectword.getWordAndHint();
        if (gotWordHint != null) {
            System.out.println("The got word is: " + gotWordHint.word);
            System.out.println("The hint is: " + gotWordHint.hint);
        } else {
            System.out.println("No word and hint found.");
        }
    }
}



