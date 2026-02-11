import java.util.Scanner;

public class NumberFormatDemo {

    public static void generate(String text) {
        int num = Integer.parseInt(text);
        System.out.println(num);
    }

    public static void handle(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Handled: " + e);
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        String text = sc.next();

        // generate(text);
        handle(text);
    }
}
