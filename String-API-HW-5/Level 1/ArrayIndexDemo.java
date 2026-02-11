import java.util.Scanner;

public class ArrayIndexDemo {

    public static void generate(String[] arr) {
        System.out.println(arr[arr.length]);
    }

    public static void handle(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled: " + e);
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }

        // generate(names);
        handle(names);
    }
}
