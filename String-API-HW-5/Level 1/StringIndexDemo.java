import java.util.Scanner;

public class StringIndexDemo {

    public static void generate(String text) {
        System.out.println(text.charAt(text.length())); 
    }

    public static void handle(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();

        // generate(text);
        handle(text);
    }
}
