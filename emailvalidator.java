import java.util.Scanner;
import java.util.regex.Pattern;

public class emailvalidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an email to validate: ");
        String email = scanner.nextLine();
        if (isValidEmail(email)) {
            System.out.println(email + " is a valid email format.");
        } else {
            System.out.println(email + " is not a valid email format.");
        }

        scanner.close();
    }
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }
}
