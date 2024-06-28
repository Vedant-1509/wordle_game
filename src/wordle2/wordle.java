package wordle2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class wordle extends JFrame implements ActionListener {
    JPanel p1, main;
    JButton check, clear;
    JLabel chn;
    Font f1 = new Font("Tahoma", Font.PLAIN, 22);
    int chances = 5;
    boolean[] flag = new boolean[wordle_logic.wordSize];
    static ArrayList<JTextField> tf = new ArrayList<>();

    wordle(){
        setTitle("Wordle Game");

        main = new JPanel();
        this.setContentPane(main);
        setSize(500,500);
        main.setBackground(Color.decode("#1a1918"));

        p1 = new JPanel();
        p1.setBounds(100,80,300,60);
        p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
        p1.setBackground(Color.GRAY);
        add(p1);
        createTexfields();

        chn = new JLabel("Chances remaining: "+chances);
        chn.setBounds(140,250,250,50);
        chn.setFont(new Font("Tahoma", Font.BOLD, 18));
        chn.setForeground(Color.white);
        add(chn);

        check = new JButton("Check");
        check.setBounds(100,350,150,50);
        check.addActionListener(this);
        check.setFont(f1);
        add(check);

        clear = new JButton("Clear");
        clear.setBounds(300,350,150,50);
        clear.addActionListener(this);
        clear.setFont(f1);
        add(clear);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        UIManager.put("OptionPane.messageFont", f1);
        if(ae.getSource()==check) {
            if (chances > 0) {

                for (int i = 0; i < wordle_logic.wordSize; i++)
                {
                    if (wordle_logic.matchExactLetter(i))
                    {
                        tf.get(i).setBackground(Color.decode("#2fa84f"));
                        flag[i] = true;
                    }
                    else if (wordle_logic.matchLetter(i))
                    {
                        tf.get(i).setBackground(Color.decode("#d1d424"));
                        flag[i]=false;
                    }
                    else
                    {
                        tf.get(i).setBackground(Color.red);
                        flag[i]=false;

                    }
                }
                boolean allCorrect = true;
                for (boolean ele : flag) {
                    if (!ele) {
                        allCorrect = false;
                        break;
                    }
                }

                if (allCorrect) {
                    JOptionPane.showMessageDialog(null, "Congratulations You Made it!");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Try again!!!!");
                }


                chances--;

                chn.setText("Chances remaining: "+chances);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"you couldnt make it noob!");
                System.exit(0);
            }
        }

        if(ae.getSource()==clear){
            for (int i = 0; i < wordle_logic.wordSize; i++) {
                tf.get(i).setText("");
                tf.get(i).setBackground(Color.decode("#3b3a39"));
                for(boolean ele: flag){
                    ele = false;
                }
            }
        }
    }

    void createTexfields(){

        for(int i =0; i<wordle_logic.wordSize ; i++){
            tf.add(new JTextField());
            tf.get(i).setFont(new Font("Tahoma",Font.BOLD,32));
            tf.get(i).setBackground(Color.decode("#3b3a39"));
            tf.get(i).setForeground(Color.white);
            tf.get(i).setHorizontalAlignment(JTextField.CENTER);


        }

        for(int i =0;i<wordle_logic.wordSize;i++){
            p1.add(tf.get(i));
        }

    }

    public static void main(String[] args) {
        new wordchooser();
        new wordle_logic();
        new wordle();


    }
}
