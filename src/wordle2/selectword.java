package wordle2;

import java.sql.ResultSet;

public class selectword {
    static String word;
    static String gotword;

    public static String getword() {
        connect c = new connect();
        String query = "SELECT words FROM wordof5 WHERE nos = " + wordchooser.anInt + ";";

        try {
            ResultSet choose = c.s.executeQuery(query);
            if (choose.next()) {
                word = choose.getString("words");
            }
            System.out.println("successful");
        } catch (Exception e) {
            System.out.println("query not executed");
        }
        return word;
    }


    public static void main(String[] args) {
       new wordchooser();
//        new selectword();
        gotword=selectword.getword();
        System.out.println("the got word is:"+gotword);

    }


}
