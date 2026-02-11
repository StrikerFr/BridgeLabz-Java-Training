import java.util.Scanner;

public class UpperCaseDemo {

    public static String toUpper(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                ch = (char)(ch - 32);
            result += ch;
        }
        return result;
    }

    public static boolean compare(String s1, String s2) {
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String result1 = toUpper(text);
        String result2 = text.toUpperCase();

        System.out.println("Using ASCII: " + result1);
        System.out.println("Using Built-in: " + result2);
        System.out.println("Are equal? " + compare(result1, result2));
    }
}
