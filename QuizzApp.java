import java.io.*;
import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        String fileName = "questions.txt"; 
        List<Question> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String questionText = line;
                String[] options = new String[4];
                for (int i = 0; i < 4; i++) {
                    options[i] = br.readLine();
                }
                String correctOption = br.readLine();
                questions.add(new Question(questionText, options, correctOption));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        System.out.println("Welcome to the Quiz! Answer the following questions:");

        for (Question q : questions) {
            System.out.println("\n" + q.getQuestionText());
            String[] options = q.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (options[userAnswer - 1].equalsIgnoreCase(q.getCorrectOption())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + q.getCorrectOption());
            }
        }

        System.out.println("\nQuiz Over! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}
class Question {
    private String questionText;
    private String[] options;
    private String correctOption;

    public Question(String questionText, String[] options, String correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectOption() {
        return correctOption;
    }
}
