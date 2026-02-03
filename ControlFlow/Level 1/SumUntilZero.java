import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double num;

        do {
            num = sc.nextDouble();
            total += num;
        } while (num != 0);

        System.out.println("Total = " + total);
    }
}
