import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3]; // 0-Physics, 1-Chemistry, 2-Maths
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            // Input with validation
            for (int j = 0; j < 3; j++) {

                String subject = "";
                if (j == 0) subject = "Physics";
                if (j == 1) subject = "Chemistry";
                if (j == 2) subject = "Maths";

                System.out.print("Enter marks in " + subject + ": ");
                marks[i][j] = sc.nextDouble();

                if (marks[i][j] < 0) {
                    System.out.println("Invalid marks! Enter positive value.");
                    j--; // decrement subject index
                }
            }

            // Calculate percentage
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;

            // Assign grade
            if (percentage[i] >= 80)
                grade[i] = "A";
            else if (percentage[i] >= 70)
                grade[i] = "B";
            else if (percentage[i] >= 60)
                grade[i] = "C";
            else if (percentage[i] >= 50)
                grade[i] = "D";
            else if (percentage[i] >= 40)
                grade[i] = "E";
            else
                grade[i] = "R";
        }

        // Display result
        System.out.println("\n----- RESULT -----");

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }
    }
}
