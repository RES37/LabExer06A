import java.io.BufferedReader;
import java.io.*;
import java.util.Scanner;

public class Program extends Words {
    void onCreate() {
        getWordsTxt();
        programStart();
    }
    
    void getWordsTxt() {
        try {
            FileReader file = new FileReader("words.txt");
            BufferedReader input = new BufferedReader(file);

            // Local Variable
            String line;

            // Stores all words to a Local Array
            while ((line = input.readLine()) != null) {
                collectWord(line);
            }

            // Closes BufferedReader
            input.close();
        } catch (Exception e) {
            System.out.println("File does not exist.");
            System.exit(0);
        }
    }

    void programStart() {
        // Scanner class
        Scanner sc = new Scanner(System.in);

        // Local Variable
        String word = randomWord();
        String answer = "";
        char choice;

        // Converts random word into ???
        char[] questionMark = String.format("%" + word.length() + "s", "?").replace(" ", "?").toCharArray();
        
        try {
            while(!answer.equals(word)) {
                System.out.println("--------------------------");
                System.out.println("GUESS THE WORD");
                System.out.println("--------------------------");
                System.out.println(questionMark);
                System.out.println("--------------------------");
                choice = Character.toUpperCase(sc.next().charAt(0));

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == choice) {
                        questionMark[i] = choice;
                        answer = String.valueOf(questionMark);
                    }
                }
                clearScreen();
            }
            System.out.println("You've guessed the word [" + answer + "], Congrats!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");
    }  
}
