import java.util.Scanner;

public class MatrixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows, cols;
        System.out.print("Enter number of rows: ");
        rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        cols = sc.nextInt();

        int matrix[][] = new int[rows][cols];
        int sum = 0;

        System.out.println("Enter matrix elements:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
                sum = sum + matrix[i][j];
            }
        }

        System.out.println("Sum of all elements = " + sum);
    }
}
