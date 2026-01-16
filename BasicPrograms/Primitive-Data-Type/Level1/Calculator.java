import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double n1 = input.nextDouble();
        double n2 = input.nextDouble();

        System.out.println("Addition: " + (n1 + n2));
        System.out.println("Subtraction: " + (n1 - n2));
        System.out.println("Multiplication: " + (n1 * n2));
        System.out.println("Division: " + (n1 / n2));
    }
}
