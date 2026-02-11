import java.util.Scanner;

class Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] result = new int[10];

        for(int i = 1; i <= 10; i++) {
            result[i-1] = number * i;
        }

        for(int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + result[i-1]);
        }
    }
}
