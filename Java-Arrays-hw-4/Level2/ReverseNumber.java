import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        int number = sc.nextInt();
        int temp = number;
        int count = 0;

        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        int[] digits = new int[count];
        temp = number;

        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }

        System.out.print("Reversed Number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }
    }
}
