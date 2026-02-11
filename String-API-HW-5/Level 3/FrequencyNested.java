import java.util.Scanner;

public class FrequencyNested {

    public static String[] findFrequency(String text) {

        char[] arr = text.toCharArray();
        int[] freq = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            freq[i] = 1;

            if (arr[i] == '0')
                continue;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    freq[i]++;
                    arr[j] = '0';
                }
            }
        }

        String[] result = new String[arr.length];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0')
                result[index++] = arr[i] + " : " + freq[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] result = findFrequency(text);

        System.out.println("Character Frequencies:");
        for (String s : result)
            if (s != null)
                System.out.println(s);
    }
}
