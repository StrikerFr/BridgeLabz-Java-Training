import java.util.Scanner;

public class ShortestLongestWord {

    // Method to split text without split()
    public static String[] splitText(String text) {
        int wordCount = 1;

        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == ' ')
                wordCount++;

        String[] words = new String[wordCount];
        String word = "";
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ')
                word += text.charAt(i);
            else {
                words[index++] = word;
                word = "";
            }
        }
        words[index] = word;

        return words;
    }

    // Method to find length without length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    // Method to find shortest & longest
    public static int[] findMinMax(String[] words) {
        int minIndex = 0, maxIndex = 0;

        for (int i = 1; i < words.length; i++) {
            if (findLength(words[i]) < findLength(words[minIndex]))
                minIndex = i;

            if (findLength(words[i]) > findLength(words[maxIndex]))
                maxIndex = i;
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitText(text);
        int[] result = findMinMax(words);

        System.out.println("Shortest Word: " + words[result[0]]);
        System.out.println("Longest Word: " + words[result[1]]);
    }
}
