package wordle2;

import java.util.ArrayList;

public class wordle_logic {
    static int wordSize;
    static ArrayList<String> answer = new ArrayList<>();

    wordle_logic() {
        String word = selectword.getword();
        for (char c : word.toCharArray()) {
            answer.add(String.valueOf(c));
        }
        wordSize = answer.size();
        System.out.println("Answer: " + answer);
    }

    static boolean matchExactLetter(int i) {
        return wordle.tf.get(i).getText().equals(answer.get(i));
    }

    static boolean matchLetter(int i) {
        return answer.contains(wordle.tf.get(i).getText());
    }
}
