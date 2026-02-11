import java.util.Scanner;

public class BMICalculator {

    // b) Method to calculate BMI and status
    public static String[][] calculateBMI(int[][] data) {

        int n = data.length;
        String[][] result = new String[n][4];
        // 0=Weight, 1=Height, 2=BMI, 3=Status

        for (int i = 0; i < n; i++) {

            double weight = data[i][0];
            double heightCm = data[i][1];

            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);

            bmi = Math.round(bmi * 100.0) / 100.0;

            String status;

            if (bmi <= 18.4)
                status = "Underweight";
            else if (bmi <= 24.9)
                status = "Normal";
            else if (bmi <= 39.9)
                status = "Overweight";
            else
                status = "Obese";

            result[i][0] = String.valueOf(weight);
            result[i][1] = String.valueOf(heightCm);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }

        return result;
    }

    // d) Display Method
    public static void display(String[][] result) {

        System.out.println("\n------------------------------------------------------");
        System.out.println("Weight(kg)\tHeight(cm)\tBMI\t\tStatus");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                result[i][0] + "\t\t" +
                result[i][1] + "\t\t" +
                result[i][2] + "\t\t" +
                result[i][3]
            );
        }
    }

    // e) Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] data = new int[10][2]; 
        // 10 rows (persons)
        // Column 0 = Weight
        // Column 1 = Height

        for (int i = 0; i < 10; i++) {

            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Enter Weight (kg): ");
            data[i][0] = sc.nextInt();

            System.out.print("Enter Height (cm): ");
            data[i][1] = sc.nextInt();
        }

        String[][] result = calculateBMI(data);

        display(result);
    }
}
