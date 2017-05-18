/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author anormal
 */
public class HangMan {
    String word;
    int wrong;
    Scanner getter;
    static String[] hangmans = {
              
              " ______\n"
            + "      |\n"
            + "      |\n"
            + "      |\n"
            + "      |\n",
              
              " ______\n"
            + " O    |\n"
            + "      |\n"
            + "      |\n"
            + "      |\n",
              
              " ______\n"
            + " O    |\n"
            + " |    |\n"
            + "      |\n"
            + "      |\n",
              
              " ______\n"
            + " O    |\n"
            + "/|    |\n"
            + "      |\n"
            + "      |\n",
              
              " ______\n"
            + " O    |\n"
            + "/|\\   |\n"
            + "      |\n"
            + "      |\n",
              
              " ______\n"
            + " O    |\n"
            + "/|\\   |\n"
            + "/     |\n"
            + "      |\n",
              
              " ______\n"
            + " O    |\n"
            + "/|\\   |\n"
            + "/ \\   |\n"
            + "      |\n",
            
    };
    public HangMan(){
            getter = new Scanner(System.in);
            wrong = 0;
            word = randWord();
            
    }
    
    public static boolean[] isContain(boolean[] guessed,String word,char guess){
        for(int i = 0; i< word.length();i++){
            if(word.charAt(i)==guess){
                guessed[i] = true;
            }
            
        }
        
        return guessed;
    }
    
    public static void writeWord(boolean[] guessed,HangMan beg){
        
        for(int i = 0; i < beg.word.length();i++){
            
                if(guessed[i]){
                    System.out.print(" " + beg.word.charAt(i)+ " ");
                }
                else{
                    System.out.print(" _ ");
                }
            }
    
    }
    
   
    public static boolean win(boolean[] guessed){
        for (boolean i:guessed){
            if (i != true)
                return false;
        }
        return true;
    }
    
    
    public static void play(HangMan beg){
        String word = beg.word.toLowerCase();
        //System.out.println(beg.word);
        
        boolean[] guessed = new boolean[word.length()];
        
        
        System.out.println("  Welcome to HangMan V0.0  ");
        System.out.println("*-------------------------*");
        
        
        while (beg.wrong != 6 && !win(guessed)){
            String getter;
            System.out.println(hangmans[beg.wrong]);
            System.out.print("Word : ");
            writeWord(guessed,beg);
            
            System.out.print("\nGuess a character : ");
            while(true){
                getter = beg.getter.nextLine();
                if (getter.length() != 1 || !Character.isLetter(getter.charAt(0)) || !Character.isLowerCase(getter.charAt(0))){
                    System.out.print("Single a character : ");
                }
                else
                    break;
               
            }
            char guess = getter.charAt(0);
            
            boolean[] gue = isContain(guessed.clone(),word,guess);
            if (checkBools(gue,guessed)){
                
                beg.wrong++;}
            else{
                
                guessed = gue;
                
            }
            
            
        }
        System.out.print("Word is : ");
        writeWord(guessed, beg);
        System.out.println("");
    }
    
    public static boolean checkBools(boolean[] b1, boolean[] b2){
        for(int i = 0; i < b1.length; i++){
            if (b1[i] != b2[i]){
                
                return false;
            }
        }
        return true;
    } 
    
    
    public static String randWord(){
        String son;
        
        String[] words  = {"Word","Abakus","Java","Killer","Mankind","Crazy","Pyscho","Loneliness","Change","Death","Drugs","PainKiller","Berkant"};
        Random randgen = new Random();
        son = words[randgen.nextInt(words.length-1)];
        return son;
    
    }
    
    public static void main(String[] args) {
        boolean cont = true;
        while (cont){
            HangMan beg = new HangMan();
            play(beg);
            if(beg.wrong != 6 ){
                System.out.println("Congratulations!");

            }
            else{
                System.out.println(hangmans[6]);
                System.out.println("Too Bad!");
            }
            
            while (true){
                System.out.print("Play again?(Y/N):");
                String get = beg.getter.nextLine();
                if(get.length()== 1){
                    if (get.toLowerCase().charAt(0) == 'n'){
                        cont = false;
                        break;
                    }
                    else if (get.toLowerCase().charAt(0) == 'y'){
                        break;
                    }
                }
                
            }
        }
        
    }
    
}
