import java.io.*;
import java.util.*;

public class SpellingChecker {
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        String dictionaryFile = "dictionary.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(dictionaryFile))) {
            String word;
            while ((word = br.readLine()) != null) {
                dictionary.add(word.toLowerCase());
            }
        } catch (IOException e) {
            System.out.println("Error loading dictionary: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Spelling Checker!");
        System.out.println("Type 'exit' to quit the program.\n");

        while (true) {
            System.out.print("Enter a word to check: ");
            String inputWord = scanner.nextLine().toLowerCase();

            if (inputWord.equals("exit")) {
                System.out.println("Exiting the Spelling Checker. Goodbye!");
                break;
            }

            if (dictionary.contains(inputWord)) {
                System.out.println("Correct! The word \"" + inputWord + "\" is spelled correctly.");
            } else {
                System.out.println("Incorrect! The word \"" + inputWord + "\" is not in the dictionary.");
            }
        }

        scanner.close();
    }
}
