import java.util.Scanner;

public class LowerCaseDemo {

    public static String toLower(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                ch = (char)(ch + 32);
            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String result1 = toLower(text);
        String result2 = text.toLowerCase();

        System.out.println("Using ASCII: " + result1);
        System.out.println("Using Built-in: " + result2);
        System.out.println("Are equal? " + result1.equals(result2));
    }
}
