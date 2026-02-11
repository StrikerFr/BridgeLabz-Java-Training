import java.util.Scanner;

public class CharacterTypeDisplay {

    // Method to check vowel/consonant
    public static String checkChar(char ch) {

        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z')
            ch = (char)(ch + 32);

        if (ch >= 'a' && ch <= 'z') {
            if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    // Create 2D array
    public static String[][] analyzeText(String text) {
        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkChar(text.charAt(i));
        }
        return result;
    }

    // Display in tabular format
    public static void display(String[][] arr) {
        System.out.println("\nCharacter\tType");
        System.out.println("------------------------");

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] result = analyzeText(text);
        display(result);
    }
}
