import java.util.Scanner;

public class BMI2DArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];

        // Input
        for (int i = 0; i < number; i++) {

            System.out.println("\nPerson " + (i + 1));

            // Weight input validation
            do {
                System.out.print("Enter weight (kg): ");
                personData[i][0] = sc.nextDouble();
                if (personData[i][0] <= 0)
                    System.out.println("Invalid! Enter positive value.");
            } while (personData[i][0] <= 0);

            // Height input validation
            do {
                System.out.print("Enter height (m): ");
                personData[i][1] = sc.nextDouble();
                if (personData[i][1] <= 0)
                    System.out.println("Invalid! Enter positive value.");
            } while (personData[i][1] <= 0);

            // Calculate BMI
            personData[i][2] = personData[i][0] / 
                              (personData[i][1] * personData[i][1]);

            // Determine Status
            if (personData[i][2] <= 18.4)
                weightStatus[i] = "Underweight";
            else if (personData[i][2] <= 24.9)
                weightStatus[i] = "Normal";
            else if (personData[i][2] <= 39.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        // Display
        System.out.println("\n----- BMI REPORT -----");

        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.println("Weight: " + personData[i][0] + " kg");
            System.out.println("Height: " + personData[i][1] + " m");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
        }
    }
}
