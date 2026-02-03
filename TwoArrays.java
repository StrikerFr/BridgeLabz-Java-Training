import java.util.Scanner;

public class TwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter size of arrays: ");
        n = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[n];

        System.out.println("Enter elements of first array:");
        for(int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second array:");
        for(int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("First Array:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println("\nSecond Array:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
