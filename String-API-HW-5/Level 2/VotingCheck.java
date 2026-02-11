import java.util.Scanner;

public class VotingCheck {

    public static String[][] checkVote(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] >= 18)
                result[i][1] = "Can Vote";
            else
                result[i][1] = "Cannot Vote";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age: ");
            ages[i] = sc.nextInt();
        }

        String[][] result = checkVote(ages);

        System.out.println("Age\tStatus");
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i][0] + "\t" + result[i][1]);
    }
}
