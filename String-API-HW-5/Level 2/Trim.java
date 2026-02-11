import java.util.Scanner;

public class TrimWithoutBuiltIn {

    // Find start and end index
    public static int[] trimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ')
            start++;

        while (end >= start && text.charAt(end) == ' ')
            end--;

        return new int[]{start, end};
    }

    // Create substring manually
    public static String createSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i <= end; i++)
            result += text.charAt(i);

        return result;
    }

    // Compare strings using charAt()
    public static boolean compare(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i))
                return false;

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        int[] indexes = trimIndexes(text);
        String trimmed1 = createSubstring(text, indexes[0], indexes[1]);

        String trimmed2 = text.trim();

        System.out.println("Without trim(): '" + trimmed1 + "'");
        System.out.println("Using trim(): '" + trimmed2 + "'");
        System.out.println("Are both equal? " + compare(trimmed1, trimmed2));
    }
}
