package wordle2;
import java.util.Random;
public class wordchooser {
    Random random=new Random();
    static int anInt;


    wordchooser()
    {
        int random_int=random.nextInt(36);
        anInt=random_int;

        System.out.println("the num is:"+anInt);

    }


}