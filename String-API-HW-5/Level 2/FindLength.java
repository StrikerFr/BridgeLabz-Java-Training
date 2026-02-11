import java.util.Scanner;

public class FindLength {

    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Exception occurs when index exceeds length
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();

        int len1 = findLength(text);
        int len2 = text.length();

        System.out.println("Without length(): " + len1);
        System.out.println("Using length(): " + len2);
    }
}
