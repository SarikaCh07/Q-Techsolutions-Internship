import java.util.Scanner;

public class currencyconverter {
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double usdToInr = 82.5;
        double inrToUsd = 0.012;
        double usdToEur = 0.92;
        double eurToUsd = 1.09;
        double inrToEur = 0.011;
        double eurToInr = 89.0;

        if (fromCurrency.equalsIgnoreCase("USD") && toCurrency.equalsIgnoreCase("INR")) {
            return amount * usdToInr;
        } else if (fromCurrency.equalsIgnoreCase("INR") && toCurrency.equalsIgnoreCase("USD")) {
            return amount * inrToUsd;
        } else if (fromCurrency.equalsIgnoreCase("USD") && toCurrency.equalsIgnoreCase("EUR")) {
            return amount * usdToEur;
        } else if (fromCurrency.equalsIgnoreCase("EUR") && toCurrency.equalsIgnoreCase("USD")) {
            return amount * eurToUsd;
        } else if (fromCurrency.equalsIgnoreCase("INR") && toCurrency.equalsIgnoreCase("EUR")) {
            return amount * inrToEur;
        } else if (fromCurrency.equalsIgnoreCase("EUR") && toCurrency.equalsIgnoreCase("INR")) {
            return amount * eurToInr;
        } else {
            System.out.println("Invalid currency combination.");
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the source currency (USD/INR/EUR): ");
        String fromCurrency = scanner.next();
        System.out.print("Enter the target currency (USD/INR/EUR): ");
        String toCurrency = scanner.next();
        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
        if (convertedAmount != -1) {
            System.out.printf("Converted amount: %.2f %s%n", convertedAmount, toCurrency);
        }

        scanner.close();
    }
}
