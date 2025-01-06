import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import javax.xml.transform.Templates;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Main extends JFrame { 
    public static Scanner s = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
  
  public Main (){
    JFrame frame = new JFrame();
  ImageIcon icon = new ImageIcon("imgs/cheezburger-image-9433286912.jpg");
  JLabel label = new JLabel(icon);
  frame.add(label);
  frame.setDefaultCloseOperation
         (JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);

  }
  
  public void paint(Graphics gui){
    Font title = new Font("Serif", Font.BOLD, 45);
    gui.setFont(title);
    gui.setColor(Color.blue);
    gui.fillRect(90,55,60,55);
    gui.fillRect(205,55,60,55);
    gui.fillRect(300,55,60,55);
    gui.setColor(Color.red);
    gui.fillRect(150,55,60,55);
    gui.fillRect(265,55,50,55);
    gui.fillRect(360,55,50,55);
    gui.setColor(Color.black);
    gui.drawString("W O R D L E",92,100);
    gui.setColor(Color.black);
    gui.drawRect(90,55,320,55);
  }
   public static void main(String[] args) {
    Main window = new Main();
        long startTime = System.currentTimeMillis();
        int tries = 0;
        System.out.println("Wordle: Type A Five Letter Word");
        String answerChoosen = ReturnRandomWord();
        char[] answer = new char[5];
        for (int i = 0; i < 5; i++ ) answer[i] = answerChoosen.charAt(i);
        char[] input = new char[5];        
        boolean done = false;
        
        while (!done){
            tries++;
            String R1 = s.nextLine().toLowerCase();
            while (R1.length() < 5) {
                R1 = s.nextLine().toLowerCase();
            }
            for (int i = 0; i < 5; i++ ) { //puts the inputWord into a char[]
                answer[i] = answerChoosen.charAt(i);
                input[i] = R1.charAt(i);
            }
            if (PrintWordWithColor(input, answer)) done = true;
        }

        System.out.println("Hey, You Found The Answer in " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds and " + tries + " tries.");
    }

    public static boolean PrintWordWithColor(char[] inputWord, char[] correctWord) {
        boolean correct = true;
        char[] answerTemp = correctWord;
        int[] colorForLetter = new int[5]; //0 is grey, yellow is 1, green is 2

        for (int i = 0; i < 5; i++) { //check for any correct position+letter (green)
            if (inputWord[i] == answerTemp[i]) {
                answerTemp[i] = '-';
                colorForLetter[i] = 2;
            } else correct = false;
        }

        for (int j = 0; j < 5; j++) { //check for any correct letter (yellow)
            for (int k = 0; k < 5; k++){
                if (inputWord[j] == answerTemp[k] && colorForLetter[j] != 2) {
                    //if that letter is not already green and matches some other letter
                    colorForLetter[j] = 1;
                    answerTemp[k] = '-';
                }
            }
        }

        for (int m = 0; m < 5; m++) {
            if (colorForLetter[m] == 0) System.out.print(inputWord[m]);
            if (colorForLetter[m] == 1) System.out.print(ANSI_YELLOW + inputWord[m] + ANSI_RESET);
            if (colorForLetter[m] == 2) System.out.print(ANSI_GREEN + inputWord[m] + ANSI_RESET);
        }
        System.out.println("");
        return correct;
    }
  

    public static String ReturnRandomWord(){
        String[] answerList = { "fappy", "daddy", "babas", "haram", "happy", "clapy", "shave", "brave", "booby", "forth", "first", "stand", "belly", "ivory", "seedy", "print", "yearn", "drain", "bribe", "stout", "panel", "crass", "flume", "offal", "agree", "error", "swirl", "argue", "bleed", "delta", "flick", "totem", "wooer", "front", "shrub", "parry", "biome", "lapel", "start", "greet", "goner", "golem", "lusty", "loopy", "round", "audit", "lying", "gamma", "labor", "islet", "civic", "forge", "corny", "moult", "basic", "salad", "agate", "spicy", "spray", "essay", "fjord", "spend", "kebab", "guild", "aback", "motor", "alone", "hatch", "hyper", "thumb", "dowry", "ought", "belch", "dutch", "pilot", "tweed", "comet", "jaunt", "enema", "steed", "abyss", "growl", "fling", "dozen", "boozy", "erode", "world", "gouge", "click", "briar", "great", "altar", "pulpy", "blurt", "coast", "duchy", "groin", "fixer", "group", "rogue", "badly", "smart", "pithy", "gaudy", "chill", "heron", "vodka", "finer", "surer", "radio", "rouge", "perch", "retch", "wrote", "clock", "tilde", "store", "prove", "bring", "solve", "cheat", "grime", "exult", "usher", "epoch", "triad", "break", "rhino", "viral", "conic", "masse", "sonic", "vital", "trace", "using", "peach", "champ", "baton", "brake", };
        return answerList[(int)(Math.random() * (answerList.length - 1))]; //just returns a random word from this large list
    }
}
    
  





    


  