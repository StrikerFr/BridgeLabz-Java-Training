import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        // Count digits
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        int[] digits = new int[count];
        int[] frequency = new int[10]; // For digits 0-9

        temp = number;

        // Store digits in array
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }

        // Count frequency
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        // Display frequency
        System.out.println("\nDigit Frequency:");

        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " times");
            }
        }
    }
}
