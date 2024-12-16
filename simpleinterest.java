import java.util.Scanner;

class simpleinterest {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the Principal: ");
    double principal = sc.nextDouble();

    System.out.print("Enter the Rate: ");
    double rate = sc.nextDouble();

    System.out.print("Enter the Time: ");
    double time = sc.nextDouble();

    double interest = (principal * time * rate) / 100;

    System.out.println("Principal: " + principal);
    System.out.println("Interest Rate: " + rate);
    System.out.println("Time Duration: " + time);
    System.out.println("Simple Interest: " + interest);
  }
}
